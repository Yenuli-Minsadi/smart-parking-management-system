package lk.ijse.spms.userservice.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import lk.ijse.spms.userservice.enums.Role;
import lk.ijse.spms.userservice.enums.Status;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    private String id;
    private String fullName;
    private String email;
    private String password;
    private String phoneNumber;
    private Role role; // driver, owner
    private Status status; // active, inactive

    @Builder.Default
    private List<BookingLog> BookingHistory = new ArrayList<>();

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

}