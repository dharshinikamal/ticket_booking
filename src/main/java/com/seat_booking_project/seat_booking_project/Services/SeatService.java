package com.seat_booking_project.seat_booking_project.Services;

import com.seat_booking_project.seat_booking_project.dto.SeatDTO;
import com.seat_booking_project.seat_booking_project.Entities.Seats;
import com.seat_booking_project.seat_booking_project.Repository.SeatRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeatService {

    @Autowired
    private SeatRepository seatRepository;

    @Transactional
    public SeatDTO saveSeat(SeatDTO seatDTO) {
        // Ensure that seatDTO does not have a rowID set or it's a new entry
        Seats seat = convertDTOToEntity(seatDTO);
        Seats savedSeat = seatRepository.save(seat);
        return convertEntityToDTO(savedSeat);
    }

    public Optional<Seats> getSeatById(Integer rowID) {
        return seatRepository.findById(rowID);
    }

    public void deleteSeat(Integer rowID) {
        seatRepository.deleteById(rowID);
    }

    public List<Seats> getSeatsByTheaterAndSurrogate(Integer theaterID, Integer surrogate) {
        return seatRepository.findSeatsByTheaterAndSurrogate(theaterID, surrogate);
    }

    public SeatDTO updateSeat(Integer rowID, SeatDTO seatDTO) {
        Optional<Seats> existingSeatOpt = seatRepository.findById(rowID);
        if (existingSeatOpt.isPresent()) {
            Seats existingSeat = existingSeatOpt.get();
            // Update fields
            existingSeat.setSeatNumbers(seatDTO.getSeatNumbers());
            existingSeat.setReservedSeats(seatDTO.getReservedSeats());
            existingSeat.setSelectedSeats(seatDTO.getSelectedSeats());
            existingSeat.setPricePerSeat(seatDTO.getPricePerSeat());
            existingSeat.setEventID(seatDTO.getEventID());

            // Save and return updated DTO
            Seats updatedSeat = seatRepository.save(existingSeat);
            return convertEntityToDTO(updatedSeat);
        } else {
            return null; // Not found, so no update
        }
    }

    // Helper Methods for Conversion between DTO and Entity
    private Seats convertDTOToEntity(SeatDTO seatDTO) {
        Seats seat = new Seats();
        seat.setRowID(seatDTO.getRowID());
        seat.setSeatNumbers(seatDTO.getSeatNumbers());
        seat.setReservedSeats(seatDTO.getReservedSeats());
        seat.setSelectedSeats(seatDTO.getSelectedSeats());
        seat.setPricePerSeat(seatDTO.getPricePerSeat());
        seat.setEventID(seatDTO.getEventID());
        seat.setTheaterId(seatDTO.getTheaterId());
        return seat;
    }

    private SeatDTO convertEntityToDTO(Seats seat) {
        SeatDTO seatDTO = new SeatDTO();
        seatDTO.setRowID(seat.getRowID());
        seatDTO.setSeatNumbers(seat.getSeatNumbers());
        seatDTO.setReservedSeats(seat.getReservedSeats());
        seatDTO.setSelectedSeats(seat.getSelectedSeats());
        seatDTO.setPricePerSeat(seat.getPricePerSeat());
        seatDTO.setEventID(seat.getEventID());
        seatDTO.setTheaterId(seat.getTheaterId());

        return seatDTO;
    }
}
