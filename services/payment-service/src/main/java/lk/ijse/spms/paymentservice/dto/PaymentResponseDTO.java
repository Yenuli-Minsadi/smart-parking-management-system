package lk.ijse.spms.paymentservice.dto;

import lk.ijse.spms.paymentservice.enums.PaymentStatus;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentResponseDTO {

    private Long id;
    private String userId;
    private String parkingSpaceId;
    private Double amount;
    private String lastFourDigits;
    private PaymentStatus paymentStatus;
    private String receiptNumber;
    private LocalDateTime paymentDate;

}
