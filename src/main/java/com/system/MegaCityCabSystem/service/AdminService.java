package com.system.MegaCityCabSystem.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.system.MegaCityCabSystem.model.Admin;

@Service
public interface AdminService {
    
    List<Admin>getAllAdmins();

    Admin getAdminById(String adminId);

    ResponseEntity<?> createAdmin(Admin admin);

    Admin updateAdmin(String adminId,Admin admin);
    
}
