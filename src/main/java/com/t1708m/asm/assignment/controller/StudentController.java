package com.t1708m.asm.assignment.controller;

import com.t1708m.asm.assignment.entity.Student;
import com.t1708m.asm.assignment.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/students")
public class StudentController {
    @Autowired
    StudentService studentService;

    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public String showLoginPage() {
        return "login";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public String showListStudent(Model model) {
        model.addAttribute("list", studentService.getList(1, 10));
        return "list";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/create")
    public String createAccount(Model model) {
        model.addAttribute("student", new Student());
        return "form";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public String storeAccount(@Valid Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "form";
        }
        studentService.register(student);
        return "success";
    }
}