package com.t1708m.asm.assignment.service;

import com.t1708m.asm.assignment.entity.Student;
import org.springframework.data.domain.Page;

public interface StudentService {
    Page<Student> getList(int page, int limit);

    Student getDetail(String email);

    // Thực hiện xác thực người dùng.
    Student login(String email, String password);

    // Đăng ký tài khoản, mã hoá mật khẩu...
    Student register(Student student);

    // Update thông tin tài khoản theo email.
    Student update(String email, Student student);

    Student getById(String email);
}
