package com.hilton.hotel.repository;

import com.hilton.hotel.domain.Booking;
import com.hilton.hotel.domain.BookingStatus;
import com.hilton.hotel.domain.Guest;
import com.hilton.hotel.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByGuest(Guest guest);

    List<Booking> findByRoom(Room room);

    List<Booking> findByStatus(BookingStatus status);

    List<Booking> findByGuestAndStatus(Guest guest, BookingStatus status);

    boolean existsByRoomAndCheckInDateLessThanAndCheckOutDateGreaterThan(
            Room room,
            LocalDate checkOutDate,
            LocalDate checkInDate
    );

}