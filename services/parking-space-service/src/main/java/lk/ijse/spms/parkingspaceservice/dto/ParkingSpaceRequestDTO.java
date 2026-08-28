package lk.ijse.spms.parkingspaceservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ParkingSpaceRequestDTO {

    @NotBlank(message = "Location is required")
    private String location;

    @NotBlank(message = "Zone is required")
    private String zone;

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be positive")
    private Double pricePerHour;

    @NotNull(message = "Owner ID is required")
    private Long ownerId;
}
