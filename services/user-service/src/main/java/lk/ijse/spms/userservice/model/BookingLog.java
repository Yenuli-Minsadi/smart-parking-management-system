package lk.ijse.spms.userservice.model;

import lk.ijse.spms.userservice.enums.Action;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingLog {
    private String parkingSpaceId;
    private String vehicleId;
    private Action action; // reserved, released, paid

    @Builder.Default
    private LocalDateTime timestamp = LocalDateTime.now();
}
