package com.booking.booking.Controller;

import com.booking.booking.entities.Review;
import com.booking.booking.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    // Add a new review
    @PostMapping
    public ResponseEntity<String> addReview(@RequestBody Review review) {
        // Check if user_id is provided and valid
        if (review.getUser_ID() == 0) {
            return ResponseEntity.badRequest().body("user_id must be non-zero.");
        }

        // If event_id is provided, ensure movie_id is null, and vice versa
        if (review.getMovie_ID() != 0 && review.getEvent_ID() != 0) {
            return ResponseEntity.badRequest().body("Either movie_id or event_id must be provided, not both.");
        }

        if (review.getMovie_ID() == 0 && review.getEvent_ID() == 0) {
            return ResponseEntity.badRequest().body("Either movie_id or event_id must be provided.");
        }

        // Proceed to add the review
        reviewService.addReview(review);
        return ResponseEntity.ok("Review Added Successfully");
    }

    // Update an existing review
    @PutMapping("/{review_ID}")
    public ResponseEntity<String> updateReview(@PathVariable("review_ID") int id, @RequestBody Review updatedReview) {
        // Check if user_id is provided and valid
        if (updatedReview.getUser_ID() == 0) {
            return ResponseEntity.badRequest().body("user_id must be non-zero.");
        }

        // If movie_id is provided, ensure event_id is null, and vice versa
        if (updatedReview.getMovie_ID() != 0 && updatedReview.getEvent_ID() != 0) {
            return ResponseEntity.badRequest().body("Either movie_id or event_id must be provided, not both.");
        }

        if (updatedReview.getMovie_ID() == 0 && updatedReview.getEvent_ID() == 0) {
            return ResponseEntity.badRequest().body("Either movie_id or event_id must be provided.");
        }

        // Retrieve the existing review
        Review existingReview = reviewService.getReviewById(id);
        if (existingReview == null) {
            return ResponseEntity.badRequest().body("Review not found with ID: " + id);
        }

        // Update the review fields only if they are not null
        if (updatedReview.getUser_ID() != 0) {
            existingReview.setUser_ID(updatedReview.getUser_ID());
        }

        if (updatedReview.getMovie_ID() != 0) {
            existingReview.setMovie_ID(updatedReview.getMovie_ID());
        }

        if (updatedReview.getEvent_ID() != 0) {
            existingReview.setEvent_ID(updatedReview.getEvent_ID());
        }

        if (updatedReview.getReview() != null) {
            existingReview.setReview(updatedReview.getReview());
        }

        // Save the updated review
        reviewService.updateReview(existingReview);
        return ResponseEntity.ok("Review updated successfully");
    }
    // Add this code to your existing ReviewController class

    // Get a review by ID
    @GetMapping("/{review_ID}")
    public ResponseEntity<?> getReviewById(@PathVariable("review_ID") int id) {
        Review review = reviewService.getReviewById(id);
        if (review == null) {
            return ResponseEntity.badRequest().body("Review not found with ID: " + id);
        }
        return ResponseEntity.ok(review);
    }

    // Get all reviews
    @GetMapping
    public ResponseEntity<?> getAllReviews() {
        return ResponseEntity.ok(reviewService.getAllReviews());
    }

    // Delete a review by ID
    @DeleteMapping("/{review_ID}")
    public ResponseEntity<String> deleteReviewById(@PathVariable("review_ID") int id) {
        Review review = reviewService.getReviewById(id);
        if (review == null) {
            return ResponseEntity.badRequest().body("Review not found with ID: " + id);
        }
        reviewService.deleteReviewById(id);
        return ResponseEntity.ok("Review deleted successfully");
    }

}
