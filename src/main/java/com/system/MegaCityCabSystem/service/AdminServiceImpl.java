package com.system.MegaCityCabSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.system.MegaCityCabSystem.model.Admin;
import com.system.MegaCityCabSystem.repository.AdminRepository;
import com.system.MegaCityCabSystem.repository.DriverRepository;

@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean isEmailTaken(String email) {
        return adminRepository.existsByEmail(email) || 
               driverRepository.existsByEmail(email);
    }

    @Override
    public ResponseEntity<?> createAdmin(Admin admin) {
       
          if (isEmailTaken(admin.getEmail())) {
            return ResponseEntity.badRequest()
                .body("Email already exists: " + admin.getEmail());
        }
        String encodedPassword = passwordEncoder.encode(admin.getPassword());
        admin.setPassword(encodedPassword);
        return ResponseEntity.ok(adminRepository.save(admin));
    }

    

    @Override
    public List<Admin> getAllAdmins() {
        
            return adminRepository.findAll();
    
}

    @Override
    public Admin updateAdmin(String adminId, Admin admin) {
        
            if (adminRepository.existsById(adminId)) {
                admin.setAdminId(adminId);
                return adminRepository.save(admin);
            } else {
                throw new RuntimeException("User not found for id: " + adminId);
            }
        }



    @Override
    public Admin getAdminById(String adminId) {
        return adminRepository.findById(adminId)
        .orElseThrow(() -> new RuntimeException("Customer not found with ID:"+adminId));
    }
    
}
