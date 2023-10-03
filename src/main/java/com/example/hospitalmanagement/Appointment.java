package com.example.hospitalmanagement;

import java.time.LocalDateTime;

public class Appointment {

    private int docId;

    private int userId;

    private LocalDateTime appointmentTime;

    public Appointment(int docId, int userId, LocalDateTime appointmentTime) {
        this.docId = docId;
        this.userId = userId;
        this.appointmentTime = appointmentTime;
    }

    public int getDocId() {
        return docId;
    }

    public void setDocId(int docId) {
        this.docId = docId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public LocalDateTime getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(LocalDateTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }
}