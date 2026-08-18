package lk.ijse.spms.userservice.service.custom.impl;

import lk.ijse.spms.userservice.dto.UserRequestDTO;
import lk.ijse.spms.userservice.dto.UserResponseDTO;
import lk.ijse.spms.userservice.enums.Role;
import lk.ijse.spms.userservice.model.User;
import lk.ijse.spms.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl {
    private final UserRepository userRepository;

    @Override
    public UserResponseDTO register(UserRequestDTO dto) {
        User user = User.builder()
                .fullName(dto.getFullName())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .phoneNumber(dto.getPhoneNumber())
                .role(Role.valueOf(dto.getRole()))
                .build();

        User saveUser = userRepository.save(user);
        return new UserResponseDTO(saveUser);

    }
}
