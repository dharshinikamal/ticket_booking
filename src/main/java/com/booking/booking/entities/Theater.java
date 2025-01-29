package com.booking.booking.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "theater")
public class Theater {
    @Id
    @Column(name = "theater_ID")
    private int theaterID;

    @Column(name = "theater_name")
    private String theaterName;

    @Column(name = "location")
    private String location;

    @Column(name = "show_timings")
    private String showTimings;

    @Column(name = "movie_ID")
    private int movieID;

    @Column(name = "screen_ID")
    private int screenID;

    @Column(name = "total_seats")
    private int totalSeats;

    @Column(name = "available_seats")
    private int availableSeats;

    @Column(name = "surrogate")
    private int surrogate;

    @Column(name = "reserved_seats")
    private int reservedSeats;

    @Column(name = "disability_features")
    private String disabilityFeatures;
}
