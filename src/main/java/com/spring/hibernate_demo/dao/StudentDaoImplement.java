package com.spring.hibernate_demo.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import com.spring.hibernate_demo.entity.Student;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;

/**
 * StudentDaoImplement.
 */
@Repository 
public class StudentDaoImplement implements StudentDao{
    
    //define field for entity manager
    private EntityManager em;

    //inject entity manager using constructor injection
    public StudentDaoImplement(EntityManager em) {
        this.em = em;
    }

    //implement save method
    @Override 
    @Transactional
    public void save(Student theStudent) {
        //save student to database
        em.persist(theStudent);
    }
    
    @Override 
    public Student findById(Integer id) {
        //find student by id
        return em.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        //create query
        TypedQuery<Student> query = 
        em.createQuery("FROM Student order by lastName", Student.class);
        
        //return query results
        return query.getResultList();
    }

    @Override 
    public List<Student> findByLastName(String lastName) {
        //create query
        TypedQuery<Student> query = 
        em.createQuery("FROM Student WHERE lastName=:data", Student.class);
        
        //set query parameter
        query.setParameter("data", lastName);
        //return query results
        return query.getResultList();
    }

    @Override 
    @Transactional
    public void update(Student theStudent) {
        //update student in database
        em.merge(theStudent);
    }

    @Override 
    @Transactional 
    public void delete(Integer id) {
        //retrieve the student
        Student student = em.find(Student.class, id);

        //remove the student
        em.remove(student);
    }

    @Override 
    @Transactional 
    public int deleteAll() {
        int numRows = em.createQuery("DELETE FROM Student").executeUpdate();
        return numRows;
    }
}
