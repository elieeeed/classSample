package com.spring.practice.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@MappedSuperclass
public class Person extends BaseEntity {

    @Column(
            name = "first_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String firstName;

    @Column(
            name = "last_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String lastName;

    @Column(
            name = "dob",
            nullable = false
    )
    @Temporal(TemporalType.DATE)
    private LocalDate dob;

    @Column(
            name = "gender",
            nullable = false,
            length = 6
    )
    @Enumerated(EnumType.STRING)
    private Gender gender;

    public Person() {
    }

    public Person(String firstName, String lastName, LocalDate dob, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String fName) {
        this.firstName = fName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lName) {
        this.lastName = lName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public enum Gender {
        MALE, FEMALE
    }
}
