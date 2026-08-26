package lk.ijse.spms.vehicleservice.repository;

import lk.ijse.spms.vehicleservice.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    Optional<Vehicle> findByLicensePlateNumber(String licensePlateNumber);
    List<Vehicle> findByOwnerId(Long ownerId);
}
