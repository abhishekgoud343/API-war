package com.example.hospitalmanagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@org.springframework.stereotype.Repository
public class Repository {
    private HashMap<Integer, Doctor> doctorDb = new HashMap<>();
    private List<Appointment> appointmentTable = new ArrayList<>();

    public void addDoctor(Doctor doctor) throws Exception {
        int doctorId = doctor.getDocId();
        if (doctorDb.containsKey(doctorId))
            throw new Exception("A doctor with this doctor Id already exists in the database");

        doctorDb.put(doctorId, doctor);
    }

    public List<Doctor> getAllDoctors() {
        return new ArrayList<>(doctorDb.values());
    }

    public void addAppointment(Appointment appointment) throws Exception {
        if (appointmentTable.contains(appointment))
            throw new Exception("Appointment already exists");

        appointmentTable.add(appointment);
    }

    public List<Appointment> getAllAppointments() {
        return appointmentTable;
    }
}