package com.example.hospitalmanagement;

public class Hospital {

    private int hospitalId;

    private String hospitalName;

    private String address;

    public Hospital(int hospitalId, String hospitalName, String address) {
        this.hospitalId = hospitalId;
        this.hospitalName = hospitalName;
        this.address = address;
    }

    public int getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(int hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
