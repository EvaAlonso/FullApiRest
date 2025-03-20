package com.example.fullapirest.dao;

import com.example.fullapirest.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {
    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Override
    @Transactional
    public void save(Student theStudent){
        this.entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        return this.entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> theQuery;
        theQuery =
                entityManager.createQuery("FROM Student", Student.class);
        return theQuery.getResultList();
    }
    @Override
    @Transactional
    public void update(Student theStudent){
        entityManager.merge(theStudent);
    }
    @Override
    @Transactional
    public void delete(Integer id){
        Student student = this.entityManager.find(Student.class, id);
        entityManager.remove(student);
    }
}
