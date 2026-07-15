package com.hilton.hotel.dto;

import com.hilton.hotel.domain.Guest;
import com.hilton.hotel.repository.GuestRepository;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Builder
public class GuestResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private LocalDateTime createdAt;

    public static GuestResponse from (Guest guest){
        return GuestResponse.builder()
                .id(guest.getId())
                .firstName(guest.getFirstName())
                .lastName(guest.getLastName())
                .email(guest.getEmail())
                .phone(guest.getPhoneNo())
                .createdAt(guest.getCreatedAt())
                .build();
    }
}
