package com.seat_booking_project.seat_booking_project.Entities;

import jakarta.persistence.*;
import lombok.Getter;



@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_ID")
    private int movieId;

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

    // Getters and Setters

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setAgeRating(String ageRating) {
        this.ageRating = ageRating;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setRatings(double ratings) {
        this.ratings = ratings;
    }
}
