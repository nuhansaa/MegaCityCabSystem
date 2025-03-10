package com.system.MegaCityCabSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.system.MegaCityCabSystem.model.Admin;
import com.system.MegaCityCabSystem.service.AdminService;

@RestController
@RequestMapping("/auth/admins")
@CrossOrigin(origins = "*")

public class AdminController {
    
    @Autowired
    private AdminService adminService;

    @GetMapping("/viewAdmins")
   public ResponseEntity<List<Admin>> getAllAdmins() {
       List<Admin> admins = adminService.getAllAdmins();
       return new ResponseEntity<>(admins, HttpStatus.OK);
   }

   @GetMapping("/{adminId}")
   public ResponseEntity<Admin> getAdminById(@PathVariable String adminId) {
       Admin admin = adminService.getAdminById(adminId);
       return new ResponseEntity<>(admin, HttpStatus.OK);
   }

   @PostMapping("/createAdmin")
   public ResponseEntity<?> createAdmin(@RequestBody Admin admin) {
    return adminService.createAdmin(admin);
   }

   @PutMapping("/updateAdmin/{adminId}")
   public ResponseEntity<Admin> updateAdmin(
           @PathVariable String adminId,
           @RequestBody Admin admin) {
       Admin updatedAdmin = adminService.updateAdmin(adminId, admin);
       return new ResponseEntity<>(updatedAdmin, HttpStatus.OK);
   }
}
