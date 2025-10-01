package kg.megalab.kindergarten.services;

import kg.megalab.kindergarten.models.Payment;
import kg.megalab.kindergarten.models.dto.PaymentDto;
import kg.megalab.kindergarten.models.dto.PreviousMonthDebtDto;

public interface PaymentService {
    Payment addPayment(PaymentDto dto);

    PreviousMonthDebtDto getPreviousMonthDebt(Long childId);
}
