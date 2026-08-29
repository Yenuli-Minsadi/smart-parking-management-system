package lk.ijse.spms.parkingspaceservice.service.custom.impl;

import lk.ijse.spms.parkingspaceservice.dto.ParkingSpaceRequestDTO;
import lk.ijse.spms.parkingspaceservice.dto.ParkingSpaceResponseDTO;
import lk.ijse.spms.parkingspaceservice.enums.ParkingStatus;
import lk.ijse.spms.parkingspaceservice.exception.ParkingSpaceNotFoundException;
import lk.ijse.spms.parkingspaceservice.model.ParkingSpace;
import lk.ijse.spms.parkingspaceservice.repository.ParkingSpaceRepository;
import lk.ijse.spms.parkingspaceservice.service.custom.ParkingSpaceService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public ParkingSpaceResponseDTO getById(Long id) {
        ParkingSpace parkingSpace = parkingSpaceRepository.findById(id).orElseThrow(() -> new ParkingSpaceNotFoundException(id));
        return modelMapper.map(parkingSpace, ParkingSpaceResponseDTO.class);
    }

    @Override
    public List<ParkingSpaceResponseDTO> getAll() {
        return parkingSpaceRepository.findAll().stream().map(parkingSpace -> modelMapper.map(parkingSpace, ParkingSpaceResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ParkingSpaceResponseDTO> getByLocation(String location) {
        return parkingSpaceRepository.findByLocation(location).stream()
                .map(parkingSpace -> modelMapper.map(parkingSpace, ParkingSpaceResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ParkingSpaceResponseDTO reserve(Long id) {
        ParkingSpace parkingSpace = parkingSpaceRepository.findById(id).orElseThrow(() -> new ParkingSpaceNotFoundException(id));
        parkingSpace.setStatus(ParkingStatus.RESERVED);
        ParkingSpace updatedParkingSpace = parkingSpaceRepository.save(parkingSpace);
        return modelMapper.map(updatedParkingSpace, ParkingSpaceResponseDTO.class);
    }

    @Override
    public ParkingSpaceResponseDTO release(Long id) {
        ParkingSpace parkingSpace = parkingSpaceRepository.findById(id).orElseThrow(() -> new ParkingSpaceNotFoundException(id));
        parkingSpace.setStatus(ParkingStatus.AVAILABLE);
        ParkingSpace updatedParkingSpace = parkingSpaceRepository.save(parkingSpace);
        return modelMapper.map(updatedParkingSpace, ParkingSpaceResponseDTO.class);
    }

    @Override
    public void delete(Long id) {
        if(!parkingSpaceRepository.existsById(id)) {
            throw new ParkingSpaceNotFoundException(id);
        }
        parkingSpaceRepository.deleteById(id);
    }
}
