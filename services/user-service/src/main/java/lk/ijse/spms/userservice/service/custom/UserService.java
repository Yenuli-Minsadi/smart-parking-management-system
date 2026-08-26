package lk.ijse.spms.userservice.service.custom;

import lk.ijse.spms.userservice.dto.UserRequestDTO;
import lk.ijse.spms.userservice.dto.UserResponseDTO;
import java.util.List;

public interface UserService {
    UserResponseDTO register(UserRequestDTO dto);
    UserResponseDTO getById(String id);
    List<UserResponseDTO> getAll();
    UserResponseDTO update(String id, UserRequestDTO dto);
    UserResponseDTO addReservationToHistory(String id, String reservationRef);
    void delete(String id);
}