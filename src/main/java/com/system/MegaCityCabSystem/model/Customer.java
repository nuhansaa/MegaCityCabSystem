package com.system.MegaCityCabSystem.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "customers")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Customer {

    @Id

    private String customerId;

    private String customerNic;

    private String customerName;

    private String customerAddress;
    
    private String email;

    private String customerPhone;

    private String password;

    private String role ="Customer";

    
    
}
