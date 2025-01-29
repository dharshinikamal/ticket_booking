package com.booking.booking.entities;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("review_id")
    private int review_ID;

    @JsonProperty("user_id")
    private int user_ID;

    @JsonProperty("movie_id")
    private int movie_ID; //int allows null values

    @JsonProperty("event_id")
    private int event_ID; //int allows null values

    private String review;

    // Getters and Setters
    public int getReview_ID() {
        return review_ID;
    }

    public void setReview_ID(int review_ID) {
        this.review_ID = review_ID;
    }

    public int getUser_ID() {
        return user_ID;
    }

    public void setUser_ID(int user_ID) {
        this.user_ID = user_ID;
    }

    public int getMovie_ID() {
        return movie_ID;
    }

    public void setMovie_ID(Integer movie_ID) {
        this.movie_ID = movie_ID;
    }

    public int getEvent_ID() {
        return event_ID;
    }

    public void setEvent_ID(Integer event_ID) {
        this.event_ID = event_ID;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
