package com.example.hospitalmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class Controller {
    @Autowired
    Service serviceObj;

    @PostMapping("/addDoctor/{doctorId}/{name}")
    public ResponseEntity<String> addDoctor(@PathVariable("doctorId") int doctorId, @PathVariable("name") String name, @RequestParam("age") int age) {
        try {
            serviceObj.addDoctor(doctorId, name, age);
            return new ResponseEntity<>("New doctor added successfully", HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<>("Error adding the doctor: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/busiest-doctor")
    public ResponseEntity<String> findMostBusyDoc() {
        try {
            int doctorId = serviceObj.findMostBusyDoctor();
            return new ResponseEntity<>(String.valueOf(doctorId), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>("Failed to find the busiest doctor: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/doctors-below-given-age")
    public List<Doctor> doctorsBelowGivenAge(@RequestParam("age") int age) {
        return serviceObj.doctorsBelowGivenAge(age);
    }

    @GetMapping("/most-famous-specialization")
    public int getMostFamousSpecialization() {
        return serviceObj.getMostFamousSpecialization();
    }
}