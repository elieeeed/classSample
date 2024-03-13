package com.spring.practice.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Student")
@Table(name = "student")
@SequenceGenerator(
        name = "id_generator",
        sequenceName = "student_id",
        allocationSize = 1
)
public class Student extends Person {

    @OneToMany(mappedBy = "student", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
    private final List<Enrollment> enrollments = new ArrayList<>();

    @Temporal(TemporalType.DATE)
    @Column(
            name = "entry_date",
            nullable = false,
            updatable = false
    )
    private LocalDate entryDate;

    public Student() {
    }

    public Student(String firstName, String lastName, LocalDate dob, Gender gender, LocalDate entryDate) {
        super(firstName, lastName, dob, gender);
        this.entryDate = entryDate;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }

    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void addEnrollment(Enrollment enrollment) {
        if(!this.enrollments.contains(enrollment)) {
            this.enrollments.add(enrollment);
        }
    }

    public void removeEnrollment(Enrollment enrollment) {
        this.enrollments.remove(enrollment);
    }
}
