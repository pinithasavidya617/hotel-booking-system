package com.hilton.hotel.repository;


import com.hilton.hotel.domain.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GuestRepository extends JpaRepository<Guest,Long> {

    Optional<Guest> findByKeycloakId(String keycloakId);

    Optional<Guest> findByEmail(String email);

    boolean existsByEmail(String email);

}