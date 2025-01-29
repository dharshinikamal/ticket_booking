package com.booking.booking.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "ticket_booking")
public class TicketBooking {
    @Id
    @Column(name = "booking_ID")
    private int bookingID;

    @Column(name = "date")
    private String date;

    @Column(name = "no_of_tickets")
    private int noOfTickets;

    @Column(name = "status")
    private String status;

    @Column(name = "column_name")
    private int columnName;

    @Column(name = "event_ID")
    private int eventID;

    @Column(name = "row_ID")
    private int rowID;

    @Column(name = "user_ID")
    private int userID;
}
