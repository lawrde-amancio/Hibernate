package com.spring.hibernate_demo.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import com.spring.hibernate_demo.entity.Student;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;

/**
 * Data Access Object (DAO) implementation for performing CRUD operations 
 * on {@link Student} entities using JPA {@link EntityManager}.
 */
@Repository 
public class StudentDaoImplement implements StudentDao{
    
    //define field for entity manager
    private EntityManager em;

    /**
     * Constructs a new {@link StudentDaoImplement} with constructor injection.
     *
     * @param em the JPA entity manager used to interact with the database context
     */
    public StudentDaoImplement(EntityManager em) {
        this.em = em;
    }

    /**
     * Persists a new {@link Student} entity into the database context.
     *
     * @param theStudent the student entity to save
     */
    @Override 
    @Transactional
    public void save(Student theStudent) {
        //save student to database
        em.persist(theStudent);
    }
    
    /**
     * Retrieves a {@link Student} entity by its primary key ID.
     *
     * @param id the unique identifier of the student
     * @return the matching {@link Student} instance, or null if not found
     */
    @Override 
    public Student findById(Integer id) {
        //find student by id
        return em.find(Student.class, id);
    }

    /**
     * Retrieves all {@link Student} entities from the database, ordered by last name.
     *
     * @return a list containing all stored {@link Student} records
     */
    @Override
    public List<Student> findAll() {
        //create query
        TypedQuery<Student> query = 
        em.createQuery("FROM Student order by lastName", Student.class);
        
        //return query results
        return query.getResultList();
    }

    /**
     * Searches for {@link Student} entities by their last name.
     *
     * @param lastName the last name to filter students by
     * @return a list of matching {@link Student} entities
     */
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

    /**
     * Merges and updates the state of an existing {@link Student} entity in the database.
     *
     * @param theStudent the student entity with updated values
     */
    @Override 
    @Transactional
    public void update(Student theStudent) {
        //update student in database
        em.merge(theStudent);
    }

    /**
     * Removes a specific {@link Student} record from the database by ID.
     *
     * @param id the primary key ID of the student to remove
     */
    @Override 
    @Transactional 
    public void delete(Integer id) {
        //retrieve the student
        Student student = em.find(Student.class, id);

        //remove the student
        em.remove(student);
    }

    /**
     * Deletes all {@link Student} records from the database in a single query.
     *
     * @return the number of student rows deleted from the database
     */
    @Override 
    @Transactional 
    public int deleteAll() {
        int numRows = em.createQuery("DELETE FROM Student").executeUpdate();
        return numRows;
    }
}
