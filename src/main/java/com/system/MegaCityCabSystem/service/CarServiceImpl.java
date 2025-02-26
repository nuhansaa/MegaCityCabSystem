package com.system.MegaCityCabSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.MegaCityCabSystem.model.Car;
import com.system.MegaCityCabSystem.repository.CarRepository;

@Service
public class CarServiceImpl implements CarService{
    
    @Autowired
    private CarRepository carRepository;

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Car getCarById(String carId) {
        return carRepository.findById(carId)
                .orElseThrow(() -> new RuntimeException("Car not found with ID: " + carId));
    }

    @Override
    public Car createCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Car updateCar(String carId, Car car) {
        Car existingCar = getCarById(carId);
        
        existingCar.setCarBrand(car.getCarBrand());
        existingCar.setCarModel(car.getCarModel());
        existingCar.setCarLicensePlate(car.getCarLicensePlate());
        existingCar.setCapacity(car.getCapacity());
        existingCar.setAssignedDriverId(car.getAssignedDriverId());
        existingCar.setCarImgUrl(car.getCarImgUrl());
        existingCar.setBaseRate(car.getBaseRate());
        existingCar.setDriverRate(car.getDriverRate());
        
        return carRepository.save(existingCar);
    }

    @Override
    public void deleteCar(String carId) {
        carRepository.deleteById(carId);
    }

    
}
