package com.spring.hibernate_demo.dao;

import jakarta.transaction.Transactional;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import com.spring.hibernate_demo.entity.Instructor;
import com.spring.hibernate_demo.entity.InstructorDetail;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.spring.hibernate_demo.entity.Course;

@Repository 
public class AppDaoImplement implements AppDao{

    private EntityManager em;

    public AppDaoImplement(EntityManager em) {
        this.em = em;
    }

    @Override 
    @Transactional
    public void save(Instructor theInstructor) {
        em.persist(theInstructor);
    }

    @Override
    public Instructor findInstructorById(int theId) {
        return em.find(Instructor.class, theId);
    }

    @Override 
    @Transactional
    public void deleteInstructorById(int theId) {
        Instructor in = em.find(Instructor.class, theId);
        em.remove(in);
    }

    @Override 
    public InstructorDetail findInstructorDetailById(int theId) {
        return em.find(InstructorDetail.class, theId);
    }

    @Override
    @Transactional 
    public void deleteInstructorDetail(int theId) {
        //retrieve instructor details
        InstructorDetail deets = em.find(InstructorDetail.class, theId);

        //remove the associated object referencs
        deets.getInstructor().setInstructorDeets(null);

        //delete instructor details
        em.remove(deets);
    }

    @Override 
    public List<Course> findCoursesByInstructorId(int theId) {
        //create query
        TypedQuery<Course> query = em.createQuery(
            "From Course Where instructor.id=:data", Course.class);
        query.setParameter("data", theId);

        List<Course> courses = query.getResultList();
        return courses;
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int theId) {
        //create query
        TypedQuery<Instructor> query = em.createQuery(
            "SELECT i from Instructor i " + 
            "JOIN FETCH i.courses " + 
            "JOIN FETCH i.instructorDeets " + 
            "Where i.id=:data", Instructor.class);
        query.setParameter("data", theId);

        Instructor in = query.getSingleResult();
        return in;
    }

}
