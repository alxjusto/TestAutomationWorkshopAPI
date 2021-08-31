package com.workshop.api.dto;

public class User {
    String name;
    String job;
    String dni;
    int age;

    public User() {
    }

    public User(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public User(String name, String job, String dni, int age) {
        this.name = name;
        this.job = job;
        this.dni = dni;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
