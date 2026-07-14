package com.hilton.hotel.controller;

import com.hilton.hotel.domain.RoomStatus;
import com.hilton.hotel.domain.RoomType;
import com.hilton.hotel.dto.RoomRequest;
import com.hilton.hotel.dto.RoomResponse;
import com.hilton.hotel.dto.RoomStatusUpdateRequest;
import com.hilton.hotel.service.RoomService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@RequestMapping("/api/rooms")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @GetMapping
    public ResponseEntity<Page<RoomResponse>> getAllRooms(
            Pageable pageable) {


        return ResponseEntity.ok(
                roomService.getAllRooms(pageable)
        );
    }

    @GetMapping("/{roomId}")
    public ResponseEntity<RoomResponse> getRoomById(
            @PathVariable Long roomId) {

        return ResponseEntity.ok(
                roomService.getRoomById(roomId)
        );
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<RoomResponse> createRoom(
            @Valid @RequestBody RoomRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(roomService.createRoom(request));
    }

    @PatchMapping("/{roomId}/status")
    public ResponseEntity<RoomResponse> updateRoomStatus(
            @PathVariable Long roomId,
            @Valid @RequestBody RoomStatusUpdateRequest request) {

        return ResponseEntity.ok(
                roomService.updateRoomStatus(roomId, request)
        );
    }

    @GetMapping("/search")
    public ResponseEntity<Page<RoomResponse>> searchRooms(

            @RequestParam(required = false) RoomType type,

            @RequestParam(required = false) Integer capacity,

            @RequestParam(required = false) RoomStatus status,

            Pageable pageable) {

        return ResponseEntity.ok(
                roomService.searchRooms(
                        type,
                        capacity,
                        status,
                        pageable
                )
        );
    }
}