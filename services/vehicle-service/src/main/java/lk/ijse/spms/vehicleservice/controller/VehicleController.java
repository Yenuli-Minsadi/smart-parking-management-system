package lk.ijse.spms.vehicleservice.controller;

import jakarta.validation.Valid;
import lk.ijse.spms.vehicleservice.dto.VehicleRequestDTO;
import lk.ijse.spms.vehicleservice.dto.VehicleResponseDTO;
import lk.ijse.spms.vehicleservice.service.custom.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/vehicles")
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleService vehicleService;

    @PostMapping
    public ResponseEntity<VehicleResponseDTO> register(@Valid @RequestBody VehicleRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(vehicleService.register(dto));
    }

}
