package lk.ijse.spms.parkingspaceservice.repository;

import lk.ijse.spms.parkingspaceservice.enums.ParkingStatus;
import lk.ijse.spms.parkingspaceservice.model.ParkingSpace;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParkingSpaceRepository extends JpaRepository<ParkingSpace, Long> {
    List<ParkingSpace> findByStatus(ParkingStatus parkingStatus);
    List<ParkingSpace> findByLocation(String location);
}
