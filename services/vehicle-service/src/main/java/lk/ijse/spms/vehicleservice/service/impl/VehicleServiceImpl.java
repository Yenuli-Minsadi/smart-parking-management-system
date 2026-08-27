package lk.ijse.spms.vehicleservice.service.impl;

import lk.ijse.spms.vehicleservice.dto.VehicleRequestDTO;
import lk.ijse.spms.vehicleservice.dto.VehicleResponseDTO;
import lk.ijse.spms.vehicleservice.exception.VehicleNotFoundException;
import lk.ijse.spms.vehicleservice.model.Vehicle;
import lk.ijse.spms.vehicleservice.repository.VehicleRepository;
import lk.ijse.spms.vehicleservice.service.custom.VehicleService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {
    private final VehicleRepository vehicleRepository;
    private final ModelMapper modelMapper;

    @Override
    public VehicleResponseDTO register(VehicleRequestDTO dto) {
        Vehicle vehicle = modelMapper.map(dto, Vehicle.class);
        vehicle.setCurrentlyParked(false);
        Vehicle savedVehicle = vehicleRepository.save(vehicle);
        return modelMapper.map(savedVehicle, VehicleResponseDTO.class);
    }

    @Override
    public VehicleResponseDTO getById(Long id) {
        Vehicle vehicle = vehicleRepository.findById(id).orElseThrow(() -> new VehicleNotFoundException(id));
        return modelMapper.map(vehicle, VehicleResponseDTO.class);
    }

    @Override
    public List<VehicleResponseDTO> getAll() {
        return vehicleRepository.findAll().stream().map( vehicle -> modelMapper.map(vehicle, VehicleResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<VehicleResponseDTO> getByOwner(Long ownerId) {
        return vehicleRepository.findById(ownerId).stream().map(vehicle -> modelMapper.map(vehicle, VehicleResponseDTO.class))
                .collect(Collectors.toList());

    }

    @Override
    public void delete(Long id) {
        if (!vehicleRepository.existsById(id)) {
            throw new VehicleNotFoundException(id);
        }
        vehicleRepository.deleteById(id);
    }

    @Override
    public VehicleResponseDTO recordEntry(Long id) {
        Vehicle vehicle = findEntity(id);
        vehicle.setEntryTime(LocalDateTime.now());
        vehicle.setCurrentlyParked(true);
        return modelMapper.map(vehicleRepository.save(vehicle), VehicleResponseDTO.class);
    }

    @Override
    public VehicleResponseDTO recordExit(Long id) {
        Vehicle vehicle = findEntity(id);
        vehicle.setExitTime(LocalDateTime.now());
        vehicle.setCurrentlyParked(false);
        return modelMapper.map(vehicleRepository.save(vehicle), VehicleResponseDTO.class);
    }

    private Vehicle findEntity(Long id) {
        return vehicleRepository.findById(id).orElseThrow(() -> new VehicleNotFoundException(id));
    }
}
