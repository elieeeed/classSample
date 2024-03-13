package com.spring.practice.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity(name = "Course")
@Table(name = "course")
@SequenceGenerator(
        name = "id_generator",
        sequenceName = "course_id",
        allocationSize = 1
)
public class Course extends BaseEntity {

    @OneToMany(
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            mappedBy = "course",
            fetch = FetchType.EAGER
    )
    private final List<CourseTeacher> courseTeachers = new ArrayList<>();
    @Column(
            name = "name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String name;
    @Column(
            name = "unit",
            nullable = false
    )
    private Integer unit;

    public Course() {
    }

    public Course(String name, Integer unit) {
        this.name = name;
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    public List<Teacher> getTeachers() {
        return this.courseTeachers.stream().map(CourseTeacher::getTeacher).collect(Collectors.toList());
    }

    public void addTeacher(CourseTeacher courseTeacher) {
        if (!this.courseTeachers.contains(courseTeacher)) {
            this.courseTeachers.add(courseTeacher);
        }
    }

    public void removeTeacher(CourseTeacher courseTeacher) {
        this.courseTeachers.remove(courseTeacher);
    }
}
