package lk.ijse.spms.paymentservice.controller;

import jakarta.validation.Valid;
import lk.ijse.spms.paymentservice.dto.PaymentRequestDTO;
import lk.ijse.spms.paymentservice.dto.PaymentResponseDTO;
import lk.ijse.spms.paymentservice.service.custom.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/payments")
@RequiredArgsConstructor
public class PaymentServiceController {

    private final PaymentService paymentService;

    @PostMapping
    public ResponseEntity<PaymentResponseDTO> processPayment(@Valid @RequestBody PaymentRequestDTO paymentRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(paymentService.processPayment(paymentRequestDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentResponseDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(paymentService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<PaymentResponseDTO>> getAll(@RequestParam(required = false) String userId) {
        if (userId != null) {
            return ResponseEntity.ok(paymentService.getByUser(userId));
        }

        return ResponseEntity.ok(paymentService.getAll());
    }
}
