package com.system.MegaCityCabSystem.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.system.MegaCityCabSystem.model.Admin;
import com.system.MegaCityCabSystem.model.Customer;
import com.system.MegaCityCabSystem.model.Driver;
import com.system.MegaCityCabSystem.repository.AdminRepository;
import com.system.MegaCityCabSystem.repository.CustomerRepository;
import com.system.MegaCityCabSystem.repository.DriverRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private DriverRepository driverRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        
        Optional<Admin> admin = adminRepository.findByEmail(email);

        if (admin.isPresent()) {
            return User.withUsername(admin.get().getEmail())
            .password(admin.get().getPassword())
            .roles("ADMIN")
            .build();
            
        }

        Optional<Customer> customer =customerRepository.findByEmail(email);
        
        if (customer.isPresent()) {
            return User.withUsername(customer.get().getEmail())
            .password(customer.get().getPassword())
            .roles("CUSTOMER")
            .build();
            
        }

        Optional<Driver> driver = driverRepository.findByEmail(email);
        
        if (driver.isPresent()) {
            return User.withUsername(driver.get().getEmail())
            .password(driver.get().getPassword())
            .roles("DRIVER")
            .build();

        }

        throw new UsernameNotFoundException("user not found with " + email);
                

        
    }
    
}
