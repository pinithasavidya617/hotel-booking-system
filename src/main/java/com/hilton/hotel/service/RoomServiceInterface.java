package com.hilton.hotel.service;

import com.hilton.hotel.domain.Room;
import com.hilton.hotel.domain.RoomStatus;
import com.hilton.hotel.domain.RoomType;
import com.hilton.hotel.dto.RoomRequest;
import com.hilton.hotel.dto.RoomResponse;
import com.hilton.hotel.dto.RoomStatusUpdateRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

public interface RoomServiceInterface {

    Page<RoomResponse> getAllRooms(Pageable pageable);

    RoomResponse createRoom(RoomRequest request);

    RoomResponse getRoomById(Long roomId);

    @Transactional
    RoomResponse updateRoomStatus(
            Long roomId,
            RoomStatusUpdateRequest request);

    Page<RoomResponse> searchRooms(
            RoomType type,
            Integer capacity,
            RoomStatus status,
            Pageable pageable);

    RoomResponse toResponse(Room room);
}