package com.example.fullapirest.dao;

import com.example.fullapirest.entity.Student;

import java.util.List;

public interface StudentDAO {
    List<Student>findAll();
    void save(Student theStudent);
    Student findById(Integer id);
    void update(Student theStudent);
    void delete(Integer id);
}
