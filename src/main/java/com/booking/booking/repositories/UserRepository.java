package com.booking.booking.repositories;

import com.booking.booking.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    // Method to find a user by email
    Optional<User> findByEmail(String email);
}
