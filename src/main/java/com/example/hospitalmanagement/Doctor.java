package com.example.hospitalmanagement;

public class Doctor {

    private int docId;

    private String name;

    private int age;

    private String gender;

    private String specialization;

    public Doctor(int docId, String name, int age, String gender, String specialization) {
        this.docId = docId;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.specialization = specialization;
    }

    public Doctor(int docId, String name, int age) {
        this.docId = docId;
        this.name = name;
        this.age = age;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getDocId() {
        return docId;
    }

    public void setDocId(int docId) {
        this.docId = docId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
