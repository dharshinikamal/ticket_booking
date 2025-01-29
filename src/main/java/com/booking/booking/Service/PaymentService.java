package com.booking.booking.Service;

import com.booking.booking.entities.Payment;
import com.booking.booking.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    // Fetch all payments
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    // Fetch a payment by ID
    public Payment getPaymentById(int id) {
        return paymentRepository.findById(id).orElse(null);
    }

    // Save a payment
    public Payment savePayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    // Update a payment
    public Payment updatePayment(int id, Payment paymentDetails) {
        Optional<Payment> optionalPayment = paymentRepository.findById(id);
        if (optionalPayment.isPresent()) {
            Payment payment = optionalPayment.get();
            payment.setPaymentAmount(paymentDetails.getPaymentAmount());
            payment.setPaymentType(paymentDetails.getPaymentType());
            payment.setPaymentStatus(paymentDetails.isPaymentStatus());
            payment.setBookingId(paymentDetails.getBookingId());
            payment.setDate(paymentDetails.getDate());
            return paymentRepository.save(payment);
        }
        return null; // Or throw an exception if payment not found
    }

    // Delete a payment by ID
    public void deletePayment(int id) {
        paymentRepository.deleteById(id);
    }
}
