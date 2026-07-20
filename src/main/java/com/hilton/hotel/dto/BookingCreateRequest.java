package com.hilton.hotel.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingCreateRequest {

    private Long roomId;

    private LocalDate checkInDate;

    private LocalDate checkOutDate;
}