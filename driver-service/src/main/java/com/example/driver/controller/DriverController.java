package com.example.driver.controller;

import com.example.driver.model.Driver;
import com.example.driver.service.DriverService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/drivers")
public class DriverController {
    private final DriverService service;
    @Value("${server.port:8081}")
    private String port;

    public DriverController(DriverService service) { this.service = service; }

    @GetMapping
    public List<Driver> getDrivers() { return service.getAllDrivers(); }

    @GetMapping("/instance")
    public String getInstance() {
        return "Request served by Driver Service instance on port: " + port;
    }
}
