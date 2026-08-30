package lk.ijse.spms.paymentservice.model;

import jakarta.persistence.*;
import lk.ijse.spms.paymentservice.enums.PaymentStatus;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private String parkingSpaceId;

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    private String cardLastFourDigits;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentStatus status;

    @Column(unique = true, nullable = false)
    private String receiptNumber;

    @Column(nullable = false)
    private LocalDateTime paymentDate;
}
