package com.booking.booking.Service;

import com.booking.booking.entities.Review;
import com.booking.booking.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    // Get all reviews
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    // Get a review by ID
    public Review getReviewById(int id) {
        Optional<Review> review = reviewRepository.findById(id);
        return review.orElse(null); // Return null if review not found
    }

    // Add a new review
    public void addReview(Review review) {
        reviewRepository.save(review); // Save the review to the database
    }

    // Update an existing review
    public void updateReview(Review review) {
        reviewRepository.save(review); // Update the review in the database
    }

    // Delete a review by ID
    public void deleteReviewById(int id) {
        reviewRepository.deleteById(id); // Delete the review from the database
    }

    // Delete all reviews
    public void deleteAllReviews() {
        reviewRepository.deleteAll(); // Delete all reviews from the database
    }
}
