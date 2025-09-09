package org.example.springsecuritypractice.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.example.springsecuritypractice.entity.Student;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    private List<Student> students = new ArrayList<>(List.of(
            new Student(1, "Djordje", 60),
            new Student(2, "Milan", 65)
    ));

    @GetMapping("/students")
    public List<Student> getStudents() {
        System.out.println("1");
        return students;
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping("/add-student")
    public Student addStudent(@RequestBody Student student) {
        students.add(student);
        return student;
    }

}
