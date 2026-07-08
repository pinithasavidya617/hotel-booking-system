package com.hilton.hotel.repository;

import com.hilton.hotel.domain.Room;
import com.hilton.hotel.domain.RoomStatus;
import com.hilton.hotel.domain.RoomType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Long> {

    Optional<Room> findByRoomNumber(String roomNumber);

    boolean existsByRoomNumber(String roomNumber);

    Page<Room> findByStatus(RoomStatus status, Pageable pageable);

    Page<Room> findByType(RoomType type, Pageable pageable);

    Page<Room> findByStatusAndType(
            RoomStatus status,
            RoomType type,
            Pageable pageable
    );

    @Query("""
        SELECT r
        FROM Room r
        WHERE (:type IS NULL OR r.type = :type)
        AND (:capacity IS NULL OR r.capacity >= :capacity)
        AND (:status IS NULL OR r.status = :status)
        """)
    Page<Room> searchRooms(
            @Param("type") RoomType type,
            @Param("capacity") Integer capacity,
            @Param("status") RoomStatus status,
            Pageable pageable
    );
}