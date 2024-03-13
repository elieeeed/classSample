package com.spring.practice.model;

import jakarta.persistence.*;

@Entity(name = "Enrollemnt")
@Table(name = "enrollment")
public class Enrollment {

    @EmbeddedId
    private EnrollmentId id;

    @ManyToOne(optional = false)
    @MapsId("studentId")
    @JoinColumn(
            name = "student_id", nullable = false, updatable = false,
            foreignKey = @ForeignKey(name = "enrollment_student_fk")
    )
    private Student student;
    @ManyToOne(optional = false)
    @MapsId("lessonId")
    @JoinColumn(
            name = "lesson_id", nullable = false, updatable = false,
            foreignKey = @ForeignKey(name = "enrollment_lesson_fk")
    )
    private Lesson lesson;

    public Enrollment() {
    }

    public Enrollment(Student student, Lesson lesson) {
        this.student = student;
        this.lesson = lesson;
    }

    public EnrollmentId getId() {
        return id;
    }

    public void setId(EnrollmentId id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }
}
