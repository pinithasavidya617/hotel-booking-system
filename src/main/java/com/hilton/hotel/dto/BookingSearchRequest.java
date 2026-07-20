package com.hilton.hotel.dto;

import com.hilton.hotel.domain.BookingStatus;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingSearchRequest {

    private LocalDate checkInDate;

    private LocalDate checkOutDate;

    private BookingStatus status;

    private Long guestId;

    private Long roomId;
}