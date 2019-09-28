package com.t1708m.asm.assignment.config;

import com.t1708m.asm.assignment.entity.Student;
import com.t1708m.asm.assignment.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserDetailService implements UserDetailsService {

    @Autowired
    StudentService studentService;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Student student = studentService.findByEmail(email);
        if (student == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return User.builder()
                .username(student.getEmail())
                .password(student.getPassword())
                .roles("User")
                .build();
    }
}
