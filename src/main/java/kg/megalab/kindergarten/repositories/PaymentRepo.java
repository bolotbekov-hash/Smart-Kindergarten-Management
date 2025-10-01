package kg.megalab.kindergarten.repositories;

import kg.megalab.kindergarten.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface PaymentRepo extends JpaRepository<Payment, Long> {
    List<Payment> findByGroupChildrenIdAndPaymentDateBetween(Long groupChildrenId, LocalDate from, LocalDate to);
}
