package com.booking.booking.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "seats")
public class Seats {
    @Id
    @Column(name = "row_ID")
    private int rowID;

    @Column(name = "seat_numbers")
    private String seatNumbers;

    @Column(name = "reserved_seats")
    private String reservedSeats;

    @Column(name = "selected_seats")
    private String selectedSeats;

    @Column(name = "price_per_seat")
    private int pricePerSeat;

    @Column(name = "event_ID")
    private int eventID;

    @Column(name = "theater_ID")
    private int theaterID;

    @Column(name = "surrogate")
    private int surrogate;
}
