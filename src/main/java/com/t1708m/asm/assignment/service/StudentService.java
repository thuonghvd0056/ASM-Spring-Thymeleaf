package com.t1708m.asm.assignment.service;

import com.t1708m.asm.assignment.entity.Student;
import org.springframework.data.domain.Page;

public interface StudentService {
    Page<Student> getList(int page, int limit);

    Student findByEmail(String email);

    Student login(String email, String password);

    Student register(Student student);

    Student update(String email, Student student);

    Student findById(int studentId);
}
