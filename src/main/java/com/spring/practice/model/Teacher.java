package com.spring.practice.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity(name = "Person")
@Table(name = "person")
@SequenceGenerator(
        name = "id_generator",
        sequenceName = "teacher_id",
        allocationSize = 1
)
public class Teacher extends Person {

    @OneToMany(mappedBy = "teacher", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.EAGER)
    private final List<CourseTeacher> courseTeachers = new ArrayList<>();

    public List<Course> getCourses() {
        return this.courseTeachers.stream().map(CourseTeacher::getCourse).collect(Collectors.toList());
    }

    public void addCourse(CourseTeacher courseTeacher) {
        if (!this.courseTeachers.contains(courseTeacher)) {
            this.courseTeachers.add(courseTeacher);
        }
    }

    public void removeCourse(CourseTeacher courseTeacher) {
        this.courseTeachers.remove(courseTeacher);
    }
}
