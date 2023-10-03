package com.example.hospitalmanagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@org.springframework.stereotype.Service
public class Service {
    private static final Logger logger = LoggerFactory.getLogger(Service.class);

    @Autowired
    Repository repositoryObj;

    public void addDoctor(int doctorId, String name, int age) throws Exception {
        if (doctorId <= 0)
            throw new Exception("Doctor Id must be non-negative");

        repositoryObj.addDoctor(new Doctor(doctorId, name, age));
        logger.info("Doctor added");
    }

    public int findMostBusyDoctor() throws Exception {
        List<Doctor> listOfDoctors = repositoryObj.getAllDoctors();
        List<Appointment> listOfAppointments = repositoryObj.getAllAppointments();

        int doctorIdWithMaxAppointments = getDoctorIdWithMaxAppointments(listOfDoctors, listOfAppointments);

        if (doctorIdWithMaxAppointments == -1)
            throw new Exception("No appointments");

        logger.info("Busiest doctor found and returned");

        return doctorIdWithMaxAppointments;
    }

    private static int getDoctorIdWithMaxAppointments(List<Doctor> listOfDoctors, List<Appointment> listOfAppointments) {
        int maxAppointments = 0;
        int doctorIdWithMaxAppointments = -1;

        for (Doctor doctor: listOfDoctors) {
            int doctorId = doctor.getDocId();
            int appointments = 0;

            for (Appointment appointment : listOfAppointments)
                if (appointment.getDocId() == doctorId)
                    ++appointments;

            if (appointments > maxAppointments) {
                maxAppointments = appointments;
                doctorIdWithMaxAppointments = doctorId;
            }
        }

        return doctorIdWithMaxAppointments;
    }

    public List<Doctor> doctorsBelowGivenAge(int age) {
        List<Doctor> listOfAllDoctors = repositoryObj.getAllDoctors();

        List<Doctor> res = new ArrayList<>();
        for (Doctor doctor : listOfAllDoctors)
            if (doctor.getAge() < age)
                res.add(doctor);

        logger.info("List of doctors below given age returned");

        return res;
    }

    public int getMostFamousSpecialization() {
        List<Doctor> listOfAllDoctors = repositoryObj.getAllDoctors();
        int maxDoctors = 0;

        HashMap<String, Integer> specializations = new HashMap<>();

        for (Doctor doctor : listOfAllDoctors) {
            String spec = doctor.getSpecialization();
            specializations.put(spec, specializations.getOrDefault(spec, 0) + 1);
        }

        for (int number : specializations.values())
            maxDoctors = Math.max(maxDoctors, number);

        logger.info("returning number of doctors in the most popular specialization");

        return maxDoctors;
    }
}