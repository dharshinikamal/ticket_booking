package com.seat_booking_project.seat_booking_project.Controller;

import com.seat_booking_project.seat_booking_project.dto.TicketBookingDTO;
import com.seat_booking_project.seat_booking_project.Entities.TicketBooking;
import com.seat_booking_project.seat_booking_project.Services.TicketBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ticket-bookings")
public class TicketBookingController {

    private final TicketBookingService ticketBookingService;

    @Autowired
    public TicketBookingController(TicketBookingService ticketBookingService) {
        this.ticketBookingService = ticketBookingService;
    }

    // Create or Save a Ticket Booking
    @PostMapping
    public ResponseEntity<TicketBookingDTO> createTicketBooking(@RequestBody TicketBookingDTO ticketBookingDTO) {
        TicketBooking savedTicketBooking = ticketBookingService.saveTicketBooking(ticketBookingDTO);
        return new ResponseEntity<>(ticketBookingService.toDTO(savedTicketBooking), HttpStatus.CREATED);
    }

    // Get All Ticket Bookings
    @GetMapping
    public ResponseEntity<List<TicketBookingDTO>> getAllTicketBookings() {
        List<TicketBookingDTO> ticketBookings = ticketBookingService.getAllTicketBookings();
        return new ResponseEntity<>(ticketBookings, HttpStatus.OK);
    }

    // Get Ticket Booking by ID
    @GetMapping("/{bookingId}")
    public ResponseEntity<TicketBookingDTO> getTicketBookingById(@PathVariable Integer bookingId) {
        Optional<TicketBookingDTO> ticketBookingDTO = ticketBookingService.getTicketBookingById(bookingId);
        return ticketBookingDTO.map(response -> new ResponseEntity<>(response, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Update Ticket Booking
    @PutMapping("/{bookingId}")
    public ResponseEntity<TicketBookingDTO> updateTicketBooking(@PathVariable Integer bookingId, @RequestBody TicketBookingDTO ticketBookingDTO) {
        try {
            TicketBookingDTO updatedTicketBookingDTO = ticketBookingService.updateTicketBooking(bookingId, ticketBookingDTO);
            return new ResponseEntity<>(updatedTicketBookingDTO, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete Ticket Booking
    @DeleteMapping("/{bookingId}")
    public ResponseEntity<Void> deleteTicketBooking(@PathVariable Integer bookingId) {
        try {
            ticketBookingService.deleteTicketBooking(bookingId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
