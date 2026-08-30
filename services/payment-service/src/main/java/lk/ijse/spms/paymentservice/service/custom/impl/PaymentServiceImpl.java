package lk.ijse.spms.paymentservice.service.custom.impl;

import lk.ijse.spms.paymentservice.dto.PaymentRequestDTO;
import lk.ijse.spms.paymentservice.dto.PaymentResponseDTO;
import lk.ijse.spms.paymentservice.enums.PaymentStatus;
import lk.ijse.spms.paymentservice.exception.PaymentNotFoundException;
import lk.ijse.spms.paymentservice.model.Payment;
import lk.ijse.spms.paymentservice.repository.PaymentRepository;
import lk.ijse.spms.paymentservice.service.custom.PaymentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final ModelMapper modelMapper;

    @Override
    public PaymentResponseDTO processPayment(PaymentRequestDTO dto) {
        boolean isValidCard = !dto.getCardNumber().endsWith("0000");

        Payment payment = Payment.builder()
                .userId(dto.getUserId())
                .parkingSpaceId(dto.getParkingSpaceId())
                .amount(dto.getAmount()).cardLastFourDigits(dto.getCardNumber().substring(dto.getCardNumber().length() - 4))
                .status(isValidCard ? PaymentStatus.SUCCESS : PaymentStatus.FAILED)
                .receiptNumber("RCPT-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase()).build();

        Payment savedPayment = paymentRepository.save(payment);
        return modelMapper.map(savedPayment, PaymentResponseDTO.class);

    }

    @Override
    public PaymentResponseDTO getById(Long id) {
        Payment payment = paymentRepository.findById(id).orElseThrow(() -> new PaymentNotFoundException(id));
        return modelMapper.map(payment, PaymentResponseDTO.class);
    }

    @Override
    public List<PaymentResponseDTO> getAll() {
        return paymentRepository.findAll().stream().map(p -> modelMapper.map(p, PaymentResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<PaymentResponseDTO> getByUser(String userId) {
        return paymentRepository.findByUserId(userId).stream()
                .map(p -> modelMapper.map(p, PaymentResponseDTO.class))
                .collect(Collectors.toList());
    }
}

