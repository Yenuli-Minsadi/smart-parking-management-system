package lk.ijse.spms.vehicleservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "vehicles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String licensePlateNumber;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private String vehicleType;

    @Column(nullable = false)
    private Long ownerId;

    private LocalDateTime entryTime;
    private LocalDateTime exitTime;

    @Column(nullable = false)
    private boolean currentlyParked;
}
