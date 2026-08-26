package lk.ijse.spms.vehicleservice.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehicleRequestDTO {

    @NotBlank(message = "License plate number is required")
    private String licensePlateNumber;

    @NotBlank(message = "Model is required")
    private String model;

    @NotBlank(message = "Vehicle type is required")
    private String vehicleType;

    @NotBlank(message = "Owner Id is required")
    private Long ownerId;

}
