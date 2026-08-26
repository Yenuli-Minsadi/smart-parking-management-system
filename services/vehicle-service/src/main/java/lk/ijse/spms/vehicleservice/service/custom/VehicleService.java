package lk.ijse.spms.vehicleservice.service.custom;

import lk.ijse.spms.vehicleservice.dto.VehicleRequestDTO;
import lk.ijse.spms.vehicleservice.dto.VehicleResponseDTO;

import java.util.List;

public interface VehicleService {
    VehicleResponseDTO register(VehicleRequestDTO dto);
    VehicleResponseDTO getById(Long id);
    List<VehicleResponseDTO> getAll();
    List<VehicleResponseDTO> getByOwner(Long ownerId);
    VehicleResponseDTO recordEntry(Long id);
    VehicleResponseDTO recordExit(Long id);
    void delete(Long id);
}