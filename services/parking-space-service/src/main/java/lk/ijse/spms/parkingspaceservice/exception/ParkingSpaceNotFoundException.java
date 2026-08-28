package lk.ijse.spms.parkingspaceservice.exception;

public class ParkingSpaceNotFoundException extends RuntimeException {
    public ParkingSpaceNotFoundException(Long id) {
        super("Parking space not found with id: " + id);
    }
}
