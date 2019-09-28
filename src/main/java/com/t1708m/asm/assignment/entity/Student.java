package com.t1708m.asm.assignment.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class Student {
    @Id
    @Email(message = "Email không đúng định dạng.")
    private String email;
    @NotNull(message = "Vui lòng nhập tên.")
    private String name;
    private String password;
    @Size(min = 7, message = "Tối thiểu 7 kí tự.")
    private String rollNumber;
    private long createdAt;
    private long updatedAt;
    private int status;

    public Student() {
        this.status = 1;
    }

    @ManyToMany(mappedBy = "studentSet",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.REFRESH}, fetch = FetchType.LAZY)
    private Set<Class> ClassSet;

    public Set<Class> getClassSet() {
        return ClassSet;
    }

    public void setClassSet(Set<Class> classSet) {
        ClassSet = classSet;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
