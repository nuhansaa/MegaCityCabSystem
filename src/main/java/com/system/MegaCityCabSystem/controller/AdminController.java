package com.system.MegaCityCabSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.system.MegaCityCabSystem.model.Admin;
import com.system.MegaCityCabSystem.service.AdminService;

@RestController
@RequestMapping("/admins")
@CrossOrigin(origins = "*")

public class AdminController {
    
    @Autowired
    private AdminService adminService;

    @GetMapping("/Admins")
    public ResponseEntity<List<Admin>> getAllAdmins() {
        List<Admin> admins = adminService.getAllAdmins();
        return new ResponseEntity<>(admins, HttpStatus.OK);
    }

    @GetMapping("/Admin/{id}")
    public ResponseEntity<Admin> getAdminById(@PathVariable String adminId) {
        Admin admin = adminService.getAdminById(adminId);
        return new ResponseEntity<>(admin, HttpStatus.OK);
    }

    @PostMapping("/CreateAdmin")
    public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin) {
        Admin createdAdmin = adminService.createAdmin(admin);
        return new ResponseEntity<>(createdAdmin, HttpStatus.CREATED);
    }

    @PutMapping("/Admin/{id}")
    public ResponseEntity<Admin> updateAdminEntity
            (@PathVariable String adminId, @RequestBody Admin admin) {
        Admin updatedAdmin = adminService.updateAdmin(adminId, admin);
        return new ResponseEntity<>(updatedAdmin, HttpStatus.OK);
    }
}
