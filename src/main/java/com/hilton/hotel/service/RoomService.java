package com.hilton.hotel.service;

import com.hilton.hotel.domain.Room;
import com.hilton.hotel.domain.RoomStatus;
import com.hilton.hotel.domain.RoomType;
import com.hilton.hotel.dto.CreateRoomRequest;
import com.hilton.hotel.dto.RoomRequest;
import com.hilton.hotel.dto.RoomResponse;
import com.hilton.hotel.dto.RoomStatusUpdateRequest;
import com.hilton.hotel.exception.DuplicateResourceException;
import com.hilton.hotel.exception.ResourceNotFoundException;
import com.hilton.hotel.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RoomService implements RoomServiceInterface {

    private final RoomRepository roomRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<RoomResponse> getAllRooms(Pageable pageable) {
        return roomRepository.findAll(pageable)
                .map(this::toResponse);
    }

    @Override
    public RoomResponse createRoom(RoomRequest request) {

        if (roomRepository.existsByRoomNumber(request.getRoomNumber())) {
            throw new DuplicateResourceException(
                    "Room number already exists: " + request.getRoomNumber()
            );
        }

        Room room = Room.builder()
                .roomNumber(request.getRoomNumber())
                .type(request.getType())
                .pricePerNight(request.getPricePerNight())
                .capacity(request.getCapacity())
                .description(request.getDescription())
                .build();

        return toResponse(roomRepository.save(room));
    }

    @Override
    public RoomResponse getRoomById(Long roomId) {

        Room room = roomRepository.findById(roomId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Room not found with id: " + roomId
                        ));

        return toResponse(room);
    }

    @Transactional
    @Override
    public RoomResponse updateRoomStatus(
            Long roomId,
            RoomStatusUpdateRequest request) {

        Room room = roomRepository.findById(roomId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Room not found with id: " + roomId
                        ));

        room.setStatus(request.getStatus());

        return toResponse(room);
    }

    public Page<RoomResponse> searchRooms(
            RoomType type,
            Integer capacity,
            RoomStatus status,
            Pageable pageable) {

        return roomRepository.searchRooms(
                        type,
                        capacity,
                        status,
                        pageable)
                .map(this::toResponse);
    }

    @Override
    public RoomResponse toResponse(Room room) {
        return RoomResponse.builder()
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

    public Room updateRoom(Long id, CreateRoomRequest request) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Room with id - " + id + " Not found"));
        room.setRoomNumber(request.getRoomNumber());
        room.setCapacity(request.getCapacity());
        room.setType(request.getType());
        room.setDescription(request.getDescription());
        return roomRepository.save(room);
    }



}