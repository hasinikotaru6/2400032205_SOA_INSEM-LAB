package com.example.driver.service;

import com.example.driver.model.Driver;
import com.example.driver.repository.DriverRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DriverService {
    private final DriverRepository repository;
    public DriverService(DriverRepository repository) { this.repository = repository; }
    public List<Driver> getAllDrivers() { return repository.findAll(); }
}
