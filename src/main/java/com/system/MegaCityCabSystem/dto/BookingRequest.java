package com.system.MegaCityCabSystem.dto;

import lombok.Data;

@Data
public class BookingRequest {
    private String customerId;
    private String carId;
    private String bookingId;
    private String pickupLocation;
    private String destination;
    private String pickupDate;
    private String pickupTime;
    private boolean driverRequired;
}
