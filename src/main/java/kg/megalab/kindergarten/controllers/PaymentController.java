package kg.megalab.kindergarten.controllers;

import kg.megalab.kindergarten.models.Payment;
import kg.megalab.kindergarten.models.dto.PaymentDto;
import kg.megalab.kindergarten.models.dto.PreviousMonthDebtDto;
import kg.megalab.kindergarten.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    private final PaymentService service;

    @Autowired
    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Payment> addPayment(@Validated @RequestBody PaymentDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addPayment(dto));
    }

    @GetMapping("/previous-month/{childId}")
    public ResponseEntity<PreviousMonthDebtDto> previousMonthDebt(@PathVariable Long childId) {
        return ResponseEntity.ok(service.getPreviousMonthDebt(childId));
    }
}
