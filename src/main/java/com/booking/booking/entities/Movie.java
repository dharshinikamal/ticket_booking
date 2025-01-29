package com.booking.booking.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "movie")
public class Movie {
    @Id
    @Column(name = "movie_ID")
    private int movieID;

    @Column(name = "movie_name")
    private String movieName;

    @Column(name = "cast")
    private String cast;

    @Column(name = "genre")
    private String genre;

    @Column(name = "age_rating")
    private String ageRating;

    @Column(name = "language")
    private String language;

    @Column(name = "duration")
    private String duration;

    @Column(name = "ratings")
    private double ratings;
}
