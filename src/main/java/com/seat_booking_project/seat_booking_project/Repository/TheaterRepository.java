package com.seat_booking_project.seat_booking_project.Repository;


import com.seat_booking_project.seat_booking_project.Entities.Theater;
import com.seat_booking_project.seat_booking_project.Entities.TheaterId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterRepository extends JpaRepository<Theater, TheaterId> {
    // You can add custom query methods if needed
}

