package com.system.MegaCityCabSystem.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.system.MegaCityCabSystem.model.Booking;
import com.system.MegaCityCabSystem.model.Car;
import com.system.MegaCityCabSystem.model.Driver;

@Service
public interface DriverService {
    
    List<Driver> getAllDrivers();
    Driver getDriverById(String driverId);
    ResponseEntity<?> createDriver(Driver driver , Car car);
    Driver updateDriver(String driverId, Driver driver);
    void deleteDriver(String driverId);
    Driver updateAvailability(String driverId, boolean availability);
    List<Booking> getDriverBookings(String driverId);
}
