package com.system.MegaCityCabSystem.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "drivers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Driver {
    @Id
    private String driverId;

    private String driverName;

    private String email;

    private String driverVehicalLicense;

    private String driverPhone;

    private String password;

    private boolean hasOwnCar;

    private String carId; // Reference to the driver's car

    private boolean available = true; // For availability status (used in /availability endpoint)

    private String role = "DRIVER";
}