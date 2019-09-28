package com.t1708m.asm.assignment.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String className;

    @ManyToMany(fetch = FetchType.LAZY, cascade =
            {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name = "class_student",
            joinColumns = @JoinColumn(name = "class_id"),
                    inverseJoinColumns = @JoinColumn(name = "student_id"))
                    private Set<Student> studentSet;

    public Set<Student> getStudentSet() {
        return studentSet;
    }

    public void setStudentSet(Set<Student> studentSet) {
        this.studentSet = studentSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
