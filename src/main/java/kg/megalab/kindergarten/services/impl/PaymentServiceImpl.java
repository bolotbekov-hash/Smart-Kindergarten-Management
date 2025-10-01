package kg.megalab.kindergarten.services.impl;

import jakarta.persistence.EntityNotFoundException;
import kg.megalab.kindergarten.models.GroupChildren;
import kg.megalab.kindergarten.models.Payment;
import kg.megalab.kindergarten.models.dto.PaymentDto;
import kg.megalab.kindergarten.models.dto.PreviousMonthDebtDto;
import kg.megalab.kindergarten.repositories.GroupChildrenRepo;
import kg.megalab.kindergarten.repositories.PaymentRepo;
import kg.megalab.kindergarten.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepo paymentRepo;
    private final GroupChildrenRepo groupChildrenRepo;

    @Autowired
    public PaymentServiceImpl(PaymentRepo paymentRepo, GroupChildrenRepo groupChildrenRepo) {
        this.paymentRepo = paymentRepo;
        this.groupChildrenRepo = groupChildrenRepo;
    }

    @Override
    public Payment addPayment(PaymentDto dto) {
        GroupChildren gc = groupChildrenRepo.findById(dto.getGroupChildrenId()).orElseThrow(() -> new EntityNotFoundException("GroupChildren not found"));
        Payment p = Payment.builder()
                .groupChildren(gc)
                .amount(dto.getAmount())
                .paymentDate(dto.getPaymentDate())
                .build();
        return paymentRepo.save(p);
    }

    @Override
    public PreviousMonthDebtDto getPreviousMonthDebt(Long childId) {
        GroupChildren gc = groupChildrenRepo.findByChildIdAndEndDateIsNull(childId)
                .orElseThrow(() -> new EntityNotFoundException("Active group for child not found"));

        LocalDate today = LocalDate.now();
        LocalDate firstDayOfThisMonth = today.withDayOfMonth(1);
        LocalDate endOfPrevMonth = firstDayOfThisMonth.minusDays(1);
        LocalDate startOfPrevMonth = endOfPrevMonth.withDayOfMonth(1);

        // check if child was active during previous month
        if (gc.getStartDate().isAfter(endOfPrevMonth) || (gc.getEndDate() != null && gc.getEndDate().isBefore(startOfPrevMonth))) {
            throw new EntityNotFoundException("Child was not active in previous month");
        }

        Integer price = gc.getPrice();
        if (price == null) {
            price = gc.getGroup().getPrice() != null ? gc.getGroup().getPrice()
                    : gc.getGroup().getGroupCategory() != null ? gc.getGroup().getGroupCategory().getPrice() : 0;
        }

        List payments = paymentRepo.findByGroupChildrenIdAndPaymentDateBetween(gc.getId(), startOfPrevMonth, endOfPrevMonth);
        Integer sumPaid = ((List<Payment>)payments).stream().mapToInt(Payment::getAmount).sum();

        int due = price - sumPaid;
        return new PreviousMonthDebtDto(childId, due);
    }
}
