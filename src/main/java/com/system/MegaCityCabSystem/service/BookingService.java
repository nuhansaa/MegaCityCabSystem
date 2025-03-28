package com.system.MegaCityCabSystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.system.MegaCityCabSystem.dto.BookingRequest;
import com.system.MegaCityCabSystem.dto.CancellationRequest;
import com.system.MegaCityCabSystem.model.Booking;

@Service
public interface BookingService {
    List<Booking> getAllBookings();
    Booking getBookingById(String bookingId);
    Booking createBooking(BookingRequest request);
    Booking confirmBooking(String bookingId);
    List<Booking> getAvailableBookings();
    Booking cancelBooking(String customerId, CancellationRequest request);
    boolean hasBookingWithDriver(String customerEmail, String driverId);
    List<Booking> getCustomerBookings(String customerId);
    Booking getBookingDetails(String customerId, String bookingId);
    void deleteBooking(String customerId, String bookingId);
    
}