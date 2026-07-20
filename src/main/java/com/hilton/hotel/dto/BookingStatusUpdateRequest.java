package com.hilton.hotel.dto;

import com.hilton.hotel.domain.BookingStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookingStatusUpdateRequest {

    private BookingStatus status;
}