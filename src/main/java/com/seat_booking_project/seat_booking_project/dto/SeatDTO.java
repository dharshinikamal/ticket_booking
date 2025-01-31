package com.seat_booking_project.seat_booking_project.dto;

import com.seat_booking_project.seat_booking_project.Entities.TheaterId;

public class SeatDTO {

    private Integer rowID;
    private String seatNumbers;
    private String reservedSeats;
    private String selectedSeats;
    private Integer pricePerSeat;
    private Integer eventID;
    private TheaterId theaterId;  // Add this line for the theaterId field

    // Getters and Setters
    public Integer getRowID() {
        return rowID;
    }

    public void setRowID(Integer rowID) {
        this.rowID = rowID;
    }

    public String getSeatNumbers() {
        return seatNumbers;
    }

    public void setSeatNumbers(String seatNumbers) {
        this.seatNumbers = seatNumbers;
    }

    public String getReservedSeats() {
        return reservedSeats;
    }

    public void setReservedSeats(String reservedSeats) {
        this.reservedSeats = reservedSeats;
    }

    public String getSelectedSeats() {
        return selectedSeats;
    }

    public void setSelectedSeats(String selectedSeats) {
        this.selectedSeats = selectedSeats;
    }

    public Integer getPricePerSeat() {
        return pricePerSeat;
    }

    public void setPricePerSeat(Integer pricePerSeat) {
        this.pricePerSeat = pricePerSeat;
    }

    public Integer getEventID() {
        return eventID;
    }

    public void setEventID(Integer eventID) {
        this.eventID = eventID;
    }

    public TheaterId getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(TheaterId theaterId) {
        this.theaterId = theaterId;
    }
}
