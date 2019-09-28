package com.t1708m.asm.assignment.service;

import com.t1708m.asm.assignment.entity.Student;
import com.t1708m.asm.assignment.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Optional;

@Service
public class StudentServiceImplement implements StudentService{
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public Page<Student> getList(int page, int limit){
        return studentRepository.findAll(PageRequest.of(page -1, limit));
    }

    @Override
    public Student findByEmail(String email){
        Optional<Student> optionalStudent = studentRepository.findByEmail(email);
        return optionalStudent.orElse(null);
    }


    @Override
    public Student login(String email, String password) {
        Optional<Student> optionalStudent = studentRepository.findByEmail(email);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            if (student.getPassword().equals(passwordEncoder.encode(password))) {
                return student;
            }
        }
        return null;
    }

    @Override
    public Student register(Student student) {
        student.setPassword(passwordEncoder.encode(student.getPassword()));
        student.setCreatedAt(Calendar.getInstance().getTimeInMillis());
        student.setUpdatedAt(Calendar.getInstance().getTimeInMillis());
        student.setStatus(1);
        return studentRepository.save(student);
    }

    @Override
    public Student update(String email, Student updateStudent) {
        Optional<Student> optionalStudent = studentRepository.findByEmail(email);
        if (optionalStudent.isPresent()) {
            Student existstudent = optionalStudent.get();
            existstudent.setName(updateStudent.getName());
            existstudent.setRollNumber(updateStudent.getRollNumber());
            existstudent.setEmail(updateStudent.getEmail());
            existstudent.setUpdatedAt(Calendar.getInstance().getTimeInMillis());
            return studentRepository.save(existstudent);
        }
        return null;
    }

    @Override
    public Student findById(int studentId) {
        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        return optionalStudent.orElse(null);
    }

}
