package lk.ijse.spms.parkingspaceservice.dto;

import lk.ijse.spms.parkingspaceservice.enums.ParkingStatus;

public class ParkingSpaceResponseDTO {
    private Long id;
    private String location;
    private String zone;
    private ParkingStatus status;
    private Double pricePerHour;
    private Long ownerId;
}
