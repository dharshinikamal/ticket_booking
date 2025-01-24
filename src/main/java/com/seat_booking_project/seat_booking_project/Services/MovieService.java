package com.seat_booking_project.seat_booking_project.Services;

import com.seat_booking_project.seat_booking_project.Entities.Movie;
import com.seat_booking_project.seat_booking_project.Repository.MovieRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    // Save a movie
    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    // Get all movies
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    // Get movie by ID
    public Optional<Movie> getMovieById(int movie_ID) {
        return movieRepository.findById(movie_ID);
    }

    // Delete movie by ID
    @Transactional
    public void deleteMovie(int movie_ID) {
        movieRepository.deleteById(movie_ID);
    }

    // Update movie
    public Movie updateMovie(int movie_ID, Movie movieDetails) {
        if (movieRepository.existsById(movie_ID)) {
            movieDetails.setMovieId(movie_ID);
            return movieRepository.save(movieDetails);
        } else {
            throw new RuntimeException("Movie not found with id " + movie_ID);
        }
    }
}
