package com.seat_booking_project.seat_booking_project.Services;

import com.seat_booking_project.seat_booking_project.Entities.Theater;
import com.seat_booking_project.seat_booking_project.Entities.TheaterId;
import com.seat_booking_project.seat_booking_project.Repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TheaterService {

    private final TheaterRepository theaterRepository;

    @Autowired
    public TheaterService(TheaterRepository theaterRepository) {
        this.theaterRepository = theaterRepository;
    }

    public List<Theater> getAllTheaters() {
        return theaterRepository.findAll();
    }

    public Optional<Theater> getTheaterById(TheaterId theaterId) {
        return theaterRepository.findById(theaterId);
    }

    public Theater saveTheater(Theater theater) {
        return theaterRepository.save(theater);
    }

    public void deleteTheater(TheaterId theaterId) {
        theaterRepository.deleteById(theaterId);
    }

    public Theater updateTheater(Theater theater) {
        return theaterRepository.save(theater);
    }
}
