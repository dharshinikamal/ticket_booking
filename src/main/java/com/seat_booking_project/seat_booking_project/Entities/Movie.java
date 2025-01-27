package com.seat_booking_project.seat_booking_project.Entities;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;


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
    private LocalDateTime duration;

    @Column(name = "ratings")
    private double ratings;

    // Getters and Setters

    public int getMovieId() {
        return movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getCast() {
        return cast;
    }

    public String getGenre() {
        return genre;
    }

    public String getAgeRating() {
        return ageRating;
    }

    public String getLanguage() {
        return language;
    }

    public LocalDateTime getDuration() {
        return duration;
    }

    public double getRatings() {
        return ratings;
    }

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

    public void setDuration(LocalDateTime duration) {
        this.duration = duration;
    }

    public void setRatings(double ratings) {
        this.ratings = ratings;
    }
}
