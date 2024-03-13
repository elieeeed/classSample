package com.spring.practice.model;


import jakarta.persistence.*;

@Entity(name = "CourseTeacher")
@Table(
        name = "course_teacher",
        uniqueConstraints = @UniqueConstraint(
                name = "course_teacher_uq", columnNames = {"teacher_id", "course_id"}
        )
)
@SequenceGenerator(
        name = "id_generator",
        sequenceName = "course_teacher_id"
)
public class CourseTeacher extends BaseEntity {

    @ManyToOne
    @JoinColumn(
            name = "teacher_id", nullable = false, updatable = false,
            foreignKey = @ForeignKey(name = "course_teacher_teacher_fk")
    )
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(
            name = "course_id", nullable = false, updatable = false,
            foreignKey = @ForeignKey(name = "course_teacher_course_fk")
    )
    private Course course;

    public CourseTeacher() {
    }

    public CourseTeacher(Teacher teacher, Course course) {
        this.teacher = teacher;
        this.course = course;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
