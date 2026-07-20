package com.hilton.hotel.dto;

import com.hilton.hotel.domain.RoomStatus;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomStatusUpdateRequest {

    @NotNull(message = "Room status is required")
    private RoomStatus status;

}