package com.hilton.hotel.dto;

import com.hilton.hotel.domain.BookingStatus;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingResponse {

    private Long id;

    private Long guestId;

    private String guestName;

    private Long roomId;

    private String roomNumber;

    private LocalDate checkInDate;

    private LocalDate checkOutDate;

    private BookingStatus status;

    private BigDecimal totalPrice;

    private LocalDateTime createdAt;
}