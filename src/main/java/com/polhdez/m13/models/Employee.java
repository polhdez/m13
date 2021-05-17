package com.polhdez.m13.models;

import com.polhdez.m13.enums.Jobs;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

    private String firstName, lastName;
    private Jobs job;
    private double salary;
    private Long id;

    public Employee() {

    }

    public Employee(String firstName, String lastName, Jobs job) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.job = job;
        switch (job) {
            case CLEANER:
                this.salary = 600;
                break;
            case WORKER:
                this.salary = 1200;
                break;
            case MANAGER:
                this.salary = 2000;
                break;
            case BOSS:
                this.salary = 3000;
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Jobs getJob() {
        return this.job;
    }

    public void setJob(Jobs job) {
        this.job = job;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


}