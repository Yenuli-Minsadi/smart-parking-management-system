package lk.ijse.spms.paymentservice.service.custom;

import lk.ijse.spms.paymentservice.dto.PaymentRequestDTO;
import lk.ijse.spms.paymentservice.dto.PaymentResponseDTO;

import java.util.List;

public interface PaymentService {
    PaymentResponseDTO processPayment(PaymentRequestDTO dto);
    PaymentResponseDTO getById(Long id);
    List<PaymentResponseDTO> getAll();
    List<PaymentResponseDTO> getByUser(String userId);
}
