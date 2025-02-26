package com.system.MegaCityCabSystem.repository;


import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.system.MegaCityCabSystem.model.Driver;
import java.util.List;


@Repository
public interface DriverRepository extends MongoRepository<Driver,String>{
    Optional <Driver> findByEmail (String email);
    boolean existsByEmail(String email);
    List<Driver> findByAvailable(boolean available);
    Optional<Driver> findFirstByAvailableAndHasOwnCarFalse(boolean available);
    Optional<Driver> findByCarId(String carId);
}
