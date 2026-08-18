package lk.ijse.spms.userservice.dto;

import lk.ijse.spms.userservice.model.BookingLog;
import lk.ijse.spms.userservice.model.User;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponseDTO {
    private String id;
    private String fullName;
    private String email;
    private String phoneNumber;
    private String role;
    private List<BookingLog> bookingHistory;

    public UserResponseDTO(User user) {
        this.id = user.getId();
        this.fullName = user.getFullName();
        this.email = user.getEmail();
        this.phoneNumber = user.getPhoneNumber();
        this.role = user.getRole() != null ? user.getRole().toString() : null;
        this.bookingHistory = user.getBookingHistory() != null ?
                new ArrayList<>(user.getBookingHistory()) : new ArrayList<>();
    }
}