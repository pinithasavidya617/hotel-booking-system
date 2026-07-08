package com.hilton.hotel.dto;

import com.hilton.hotel.domain.Room;
import com.hilton.hotel.domain.RoomStatus;
import com.hilton.hotel.domain.RoomType;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomResponse {

    private Long id;

    private String roomNumber;

    private RoomType type;

    private BigDecimal pricePerNight;

    private Integer capacity;

    private RoomStatus status;

    private String description;

    private LocalDateTime createdAt;

    public static RoomResponse from(Room room){
        return RoomResponse
                .builder()
                .id(room.getId())
                .roomNumber(room.getRoomNumber())
                .type(room.getType())
                .pricePerNight(room.getPricePerNight())
                .capacity(room.getCapacity())
                .status(room.getStatus())
                .description(room.getDescription())
                .createdAt(room.getCreatedAt())
                .build();
    }

}