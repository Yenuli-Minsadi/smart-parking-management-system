package lk.ijse.spms.parkingspaceservice.service.custom.impl;

import lk.ijse.spms.parkingspaceservice.dto.ParkingSpaceRequestDTO;
import lk.ijse.spms.parkingspaceservice.dto.ParkingSpaceResponseDTO;
import lk.ijse.spms.parkingspaceservice.model.ParkingSpace;
import lk.ijse.spms.parkingspaceservice.repository.ParkingSpaceRepository;
import lk.ijse.spms.parkingspaceservice.service.custom.ParkingSpaceService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ParkingSpaceServiceImpl implements ParkingSpaceService {
    private final ParkingSpaceRepository parkingSpaceRepository;
    private final ModelMapper modelMapper;

    @Override
    public ParkingSpaceResponseDTO createParkingSpace(ParkingSpaceRequestDTO parkingSpaceRequest) {
        ParkingSpace parkingSpace = modelMapper.map(parkingSpaceRequest, ParkingSpace.class);
        ParkingSpace savedParkingSpace = parkingSpaceRepository.save(parkingSpace);
        return modelMapper.map(savedParkingSpace, ParkingSpaceResponseDTO.class);
    }
}
