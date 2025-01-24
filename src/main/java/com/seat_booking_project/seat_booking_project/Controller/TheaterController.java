package com.seat_booking_project.seat_booking_project.Controller;


import com.seat_booking_project.seat_booking_project.Entities.Theater;
import com.seat_booking_project.seat_booking_project.Entities.TheaterId;
import com.seat_booking_project.seat_booking_project.Services.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/theaters")
public class TheaterController {

    private final TheaterService theaterService;

    @Autowired
    public TheaterController(TheaterService theaterService) {
        this.theaterService = theaterService;
    }

    // Get all theaters
    @GetMapping
    public List<Theater> getAllTheaters() {
        return theaterService.getAllTheaters();
    }

    // Get a theater by ID
    @GetMapping("/{theaterId}/{surrogate}")
    public ResponseEntity<Theater> getTheaterById(@PathVariable Integer theaterId, @PathVariable Integer surrogate) {
        TheaterId id = new TheaterId(theaterId, surrogate);
        Optional<Theater> theater = theaterService.getTheaterById(id);
        return theater.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Add a new theater
    @PostMapping
    public Theater createTheater(@RequestBody Theater theater) {
        return theaterService.saveTheater(theater);
    }

    // Update a theater
    @PutMapping("/{theaterId}/{surrogate}")
    public ResponseEntity<Theater> updateTheater(
            @PathVariable Integer theaterId,
            @PathVariable Integer surrogate,
            @RequestBody Theater theaterDetails) {
        TheaterId id = new TheaterId(theaterId, surrogate);
        Optional<Theater> theaterOptional = theaterService.getTheaterById(id);

        if (theaterOptional.isPresent()) {
            Theater theater = theaterOptional.get();
            // Update fields as necessary
            theater.setTheaterName(theaterDetails.getTheaterName());
            theater.setLocation(theaterDetails.getLocation());
            theater.setShowTimings(theaterDetails.getShowTimings());
            theater.setMovieID(theaterDetails.getMovieID());
            theater.setScreenID(theaterDetails.getScreenID());
            theater.setTotalSeats(theaterDetails.getTotalSeats());
            theater.setAvailableSeats(theaterDetails.getAvailableSeats());
            theater.setReservedSeats(theaterDetails.getReservedSeats());
            theater.setDisabilityFeatures(theaterDetails.getDisabilityFeatures());
            return ResponseEntity.ok(theaterService.updateTheater(theater));
        }

        return ResponseEntity.notFound().build();
    }

    // Delete a theater
    @DeleteMapping("/{theaterId}/{surrogate}")
    public ResponseEntity<Void> deleteTheater(@PathVariable Integer theaterId, @PathVariable Integer surrogate) {
        TheaterId id = new TheaterId(theaterId, surrogate);
        Optional<Theater> theater = theaterService.getTheaterById(id);

        if (theater.isPresent()) {
            theaterService.deleteTheater(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}

