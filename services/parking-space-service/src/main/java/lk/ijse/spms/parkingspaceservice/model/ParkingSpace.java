package lk.ijse.spms.parkingspaceservice.model;

import jakarta.persistence.*;
import lk.ijse.spms.parkingspaceservice.enums.ParkingStatus;
import lombok.*;

@Entity
@Table(name = "ParkingSpace")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParkingSpace {

     @Id
     @GeneratedValue(strategy =  GenerationType.IDENTITY)
     private Long id;

     @Column(nullable = false)
     private String location;

     @Column(nullable = false)
     private String zone;

     @Enumerated(EnumType.STRING)
     @Column(nullable = false)
     private ParkingStatus status;

     @Column(nullable = false)
     private Double pricePerHour;

     private Long ownerId;
}
