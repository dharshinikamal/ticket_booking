package com.seat_booking_project.seat_booking_project.Repository;

import com.seat_booking_project.seat_booking_project.Entities.TicketBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketBookingRepository extends JpaRepository<TicketBooking, Integer> {

}
