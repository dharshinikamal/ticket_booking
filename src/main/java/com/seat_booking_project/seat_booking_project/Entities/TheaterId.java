package com.seat_booking_project.seat_booking_project.Entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TheaterId implements Serializable {

    @Column(name = "theater_ID")
    private Integer theaterID;


    @Column(name = "surrogate", nullable = false)
    private Integer surrogate;


    public TheaterId() {}


    public TheaterId(Integer theaterID, Integer surrogate) {
        this.theaterID = theaterID;
        this.surrogate = surrogate;
    }


    public Integer getTheaterID() {
        return theaterID;
    }

    public void setTheaterID(Integer theaterID) {
        this.theaterID = theaterID;
    }

    public Integer getSurrogate() {
        return surrogate;
    }

    public void setSurrogate(Integer surrogate) {
        this.surrogate = surrogate;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TheaterId that = (TheaterId) o;
        return Objects.equals(theaterID, that.theaterID) &&
                Objects.equals(surrogate, that.surrogate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(theaterID, surrogate);
    }
}
