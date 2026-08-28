package lk.ijse.spms.parkingspaceservice.service.custom;

import lk.ijse.spms.parkingspaceservice.dto.ParkingSpaceRequestDTO;
import lk.ijse.spms.parkingspaceservice.dto.ParkingSpaceResponseDTO;

import java.util.List;

public interface ParkingSpaceService {
    ParkingSpaceResponseDTO createParkingSpace(ParkingSpaceRequestDTO parkingSpaceRequestDTO);
    ParkingSpaceResponseDTO getById(Long id);
    List<ParkingSpaceResponseDTO> getAll();
    List<ParkingSpaceResponseDTO> getByLocation(String location);
    ParkingSpaceResponseDTO reserve(Long id);
    ParkingSpaceResponseDTO release(Long id);
    void delete(Long id);
}
