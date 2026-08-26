package lk.ijse.spms.userservice.service.custom.impl;

import lk.ijse.spms.userservice.dto.UserRequestDTO;
import lk.ijse.spms.userservice.dto.UserResponseDTO;
import lk.ijse.spms.userservice.enums.Action;
import lk.ijse.spms.userservice.enums.Role;
import lk.ijse.spms.userservice.exception.UserNotFoundException;
import lk.ijse.spms.userservice.model.BookingLog;
import lk.ijse.spms.userservice.model.User;
import lk.ijse.spms.userservice.repository.UserRepository;
import lk.ijse.spms.userservice.service.custom.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public UserResponseDTO register(UserRequestDTO userRequest) {
        User user = modelMapper.map(userRequest, User.class);
        User savedUser = userRepository.save(user);
        return modelMapper.map(savedUser, UserResponseDTO.class);
    }

    @Override
    public UserResponseDTO getById(String id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
        return modelMapper.map(user, UserResponseDTO.class);
    }

    @Override
    public UserResponseDTO update(String id, UserRequestDTO userRequest) {
        User existingUser = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
        modelMapper.map(userRequest, existingUser);
        User updatedUser = userRepository.save(existingUser);
        return modelMapper.map(updatedUser, UserResponseDTO.class);
    }

    @Override
    public void delete(String id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException(id);
        }
        userRepository.deleteById(id);
    }

    @Override
    public List<UserResponseDTO> getAll() {
        return userRepository.findAll().stream().map(user -> modelMapper.map(user, UserResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseDTO addReservationToHistory(String id, String reservationRef) {
        User reservingUser = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));

        BookingLog log = BookingLog.builder().parkingSpaceId(reservationRef).action(Action.RESERVED).build();

        reservingUser.getBookingHistory().add(log);
        User updatedUser = userRepository.save(reservingUser);
        return modelMapper.map(updatedUser, UserResponseDTO.class);
    }

}
