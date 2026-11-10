package com.spring.hibernate_demo.dao;

import jakarta.transaction.Transactional;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import com.spring.hibernate_demo.entity.Instructor;
import com.spring.hibernate_demo.entity.InstructorDetail;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.spring.hibernate_demo.entity.Course;
import com.spring.hibernate_demo.entity.Student;;

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
    public void deleteInstructorId(int theId) {
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

    @Override 
    @Transactional
    public void update(Instructor in) {
        em.merge(in);
    }

    @Override 
    @Transactional 
    public void deleteInstructorById(int theId) {
        //retrive instructor
        Instructor in = em.find(Instructor.class, theId);

        //break the associations of courses for instructor
        List<Course> courses = in.getCourses();
        for(Course c: courses) {
            //remove the instructor from the courses
            c.setInstructor(null);
        }

        //delete only the instructor
        //does not include courses associated
        em.remove(in);
    }

    @Override 
    @Transactional 
    public void save(Course theCourse) {
        em.persist(theCourse);
    }

    @Override 
    public Course findCourseAndReviewsByCourseId(int theId) {
        //crete query
        TypedQuery<Course> query = em.createQuery(
            "SELECT c FROM Course c "
            + "JOIN FETCH c.review "
            + "WHERE c.id=:data", Course.class);
        query.setParameter("data", theId);

        //execute query
        Course course = query.getSingleResult();

        return course;
    }

    @Override 
    @Transactional 
    public void deleteCourseById(int theId) {
        //retrieve the course
        Course course = em.find(Course.class, theId);

        //delete the course
        em.remove(course);
    }

    @Override 
    public Course findCourseAndStudentByCourseId(int theId) {
         //create query
        TypedQuery<Course> query = em.createQuery(
            "SELECT c FROM Course c "
            + "JOIN FETCH c.students "
            + "WHERE c.id=:data", Course.class);
        query.setParameter("data", theId);

        //execite query
        Course course = query.getSingleResult();

        return course;
    }

    @Override 
    public Student findStudentAndCoursesByStudentId(int theId) {
        //create query
        TypedQuery<Student> query = em.createQuery(
            "SELECT s FROM Student s "
            + "JOIN FETCH s.courses "
            + "WHERE s.id=:data", Student.class);
        query.setParameter("data", theId);

        //execute query
        Student student = query.getSingleResult();

        return student;
    }

    @Override 
    @Transactional
    public  void update(Student student) {
        em.merge(student);
    }

    @Override 
    @Transactional 
    public void deleteStudentById(int theId) {
        //retrive student
        Student student = em.find(Student.class, theId);

        if (student != null ) {
            //get the courses
            List<Course> courses = student.getCourses();

            //break the associations of courses for student
            for (Course c: courses) {
                c.getStudents().remove(student);
            }
        }

        //delete only the student
        //does not include courses associated
        em.remove(student);
    }

}
