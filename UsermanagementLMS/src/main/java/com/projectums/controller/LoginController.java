package com.projectums.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectums.entity.Professor;
import com.projectums.entity.Student;
import com.projectums.service.ProfessorService;
import com.projectums.service.StudentService;

@RestController
@RequestMapping("/user")
public class LoginController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private ProfessorService professorService;

    @GetMapping("/")
    public String welcomeMessage() {
        return "Welcome to Elearning Management system !!!";
    }

    @PostMapping("/loginstudent")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Map<String, String>> loginStudent(@RequestBody Student student) {
        Map<String, String> response = new HashMap<>();
        System.out.println(student);
        
        // Here we validate credentials without using JWT
        if (studentService.authenticate(student.getUsername(), student.getPassword())) {
            response.put("message", "Login successful");
            response.put("studentName", student.getUsername()); // You can customize the response as needed
            return ResponseEntity.ok(response);
        } else {
            response.put("error", "Invalid credentials");
            return ResponseEntity.status(401).body(response);
        }
    }

    @PostMapping("/loginprofessor")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Map<String, String>> loginProfessor(@RequestBody Professor professor) {
        Map<String, String> response = new HashMap<>();
        System.out.println(professor);
        
        // Here we validate credentials without using JWT
        if (professorService.authenticate(professor.getUsername(), professor.getPassword())) {
            response.put("message", "Login successful");
            response.put("professorName", professor.getUsername()); // You can customize the response as needed
            return ResponseEntity.ok(response);
        } else {
            response.put("error", "Invalid credentials");
            return ResponseEntity.status(401).body(response);
        }
    }
}
