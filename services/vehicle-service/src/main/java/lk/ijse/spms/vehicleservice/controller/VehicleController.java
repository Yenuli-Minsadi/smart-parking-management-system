package lk.ijse.spms.vehicleservice.controller;

import jakarta.validation.Valid;
import lk.ijse.spms.vehicleservice.dto.VehicleRequestDTO;
import lk.ijse.spms.vehicleservice.dto.VehicleResponseDTO;
import lk.ijse.spms.vehicleservice.service.custom.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vehicles")
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleService vehicleService;

    @PostMapping
    public ResponseEntity<VehicleResponseDTO> register(@Valid @RequestBody VehicleRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(vehicleService.register(dto));
    }

    @GetMapping({"/id"})
    public ResponseEntity<VehicleResponseDTO> getById(@PathVariable Long id){
        return ResponseEntity.ok(vehicleService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<VehicleResponseDTO>> getAll(@RequestParam(required = false)Long ownerId) {
        if (ownerId != null) return ResponseEntity.ok(vehicleService.getByOwner(ownerId));
        return ResponseEntity.ok(vehicleService.getAll());
    }

    @PutMapping({"/{id}/entry"})
    public ResponseEntity<VehicleResponseDTO> recordEntry(@PathVariable Long id) {
        return ResponseEntity.ok(vehicleService.recordEntry(id));
    }

    @PutMapping({"/{id}/exit"})
    public ResponseEntity<VehicleResponseDTO> recordExit(@PathVariable Long id) {
        return ResponseEntity.ok(vehicleService.recordExit(id));
    }

    @DeleteMapping({"/id"})
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        vehicleService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
