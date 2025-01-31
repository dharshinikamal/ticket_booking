package com.seat_booking_project.seat_booking_project.Repository;

import com.seat_booking_project.seat_booking_project.Entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
