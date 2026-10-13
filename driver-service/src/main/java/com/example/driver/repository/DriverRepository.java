package com.example.driver.repository;

import com.example.driver.model.Driver;
import org.springframework.stereotype.Repository;
import java.util.Arrays;
import java.util.List;

@Repository
public class DriverRepository {
    public List<Driver> findAll() {
        return Arrays.asList(new Driver(1, "Driver One"),
                             new Driver(2, "Driver Two"),
                             new Driver(3, "Driver Three"));
    }
}
