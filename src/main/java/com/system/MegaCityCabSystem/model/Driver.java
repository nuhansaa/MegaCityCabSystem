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

    private String driverVehicalLicense;

    private String driverPhone;

    private String email;

    private String password;

    private boolean available = true;

    private String role ="DRIVER";

    private String carId;

    private boolean hasOwnCar = false;

}
