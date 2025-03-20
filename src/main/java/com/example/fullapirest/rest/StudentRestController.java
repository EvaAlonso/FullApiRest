package com.example.fullapirest.rest;

import com.example.fullapirest.dao.StudentDAO;
import com.example.fullapirest.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class StudentRestController {
    private StudentDAO studentDAO;

    @Autowired
    public StudentRestController(StudentDAO theStudentDAO){
        studentDAO = theStudentDAO;
    }
    @GetMapping("students")
    public List<Student>findAll(){
        return studentDAO.findAll();
    }
    @GetMapping("students/{id}")
    public Student getStudent(@PathVariable int id){
        Student student = this.studentDAO.findById(id);
        if(student == null){
            throw new RuntimeException("Student id not fount - " + id);
        }
        return student;
    }
    @PostMapping("/students")
    public Student addStudent(@RequestBody Student theStudent){
        this.studentDAO.save(theStudent);
        return theStudent;
    }
}
