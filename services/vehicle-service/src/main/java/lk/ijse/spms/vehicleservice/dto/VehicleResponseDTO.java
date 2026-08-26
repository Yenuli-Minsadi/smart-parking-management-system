package lk.ijse.spms.vehicleservice.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VehicleResponseDTO {

    private Long id;
    private String licensePlateNumber;
    private String model;
    private String vehicleType;
    private Long ownerId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean currentlyParked;

}
