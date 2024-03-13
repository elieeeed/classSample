package com.spring.practice.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Lesson")
@Table(name = "lesson")
@SequenceGenerator(
        name = "id_generator",
        sequenceName = "lesson_id",
        allocationSize = 1
)
public class Lesson extends BaseEntity {

    @OneToMany(mappedBy = "lesson", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
    private final List<Enrollment> enrollments = new ArrayList<>();

    @ManyToOne
    @JoinColumn(
            name = "lesson_course_teacher_id", nullable = false, updatable = false,
            foreignKey = @ForeignKey(name = "course_teacher_fk")
    )
    private CourseTeacher courseTeacher;

    public CourseTeacher getCourseTeacher() {
        return courseTeacher;
    }

    public void setCourseTeacher(CourseTeacher courseTeacher) {
        this.courseTeacher = courseTeacher;
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
