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


/**
 * Data Access Object (DAO) implementation providing persistence and query operations
 * for entities using JPA {@link EntityManager}.
 */
@Repository 
public class AppDaoImplement implements AppDao{

    private EntityManager em;

    /**
     * Constructs an instance of {@link AppDaoImplement} with dependency injection.
     *
     * @param em the JPA entity manager used to interact with the persistence context
     */
    public AppDaoImplement(EntityManager em) {
        this.em = em;
    }

    /**
     * Persists a new {@link Instructor} entity into the database.
     *
     * @param theInstructor the instructor entity to save
     */
    @Override 
    @Transactional
    public void save(Instructor theInstructor) {
        em.persist(theInstructor);
    }

    /**
     * Retrieves an {@link Instructor} entity by its primary key ID.
     *
     * @param theId the unique identifier of the instructor
     * @return the found {@link Instructor} instance, or null if not found
     */
    @Override
    public Instructor findInstructorById(int theId) {
        return em.find(Instructor.class, theId);
    }

    /**
     * Deletes an {@link Instructor} from the database by ID along with cascade dependencies.
     *
     * @param theId the primary key ID of the instructor to delete
     */
    @Override 
    @Transactional
    public void deleteInstructorId(int theId) {
        Instructor in = em.find(Instructor.class, theId);
        em.remove(in);
    }

    /**
     * Retrieves an {@link InstructorDetail} entity by its primary key ID.
     *
     * @param theId the unique identifier of the instructor details
     * @return the found {@link InstructorDetail} instance, or null if not found
     */
    @Override 
    public InstructorDetail findInstructorDetailById(int theId) {
        return em.find(InstructorDetail.class, theId);
    }

    /**
     * Deletes an {@link InstructorDetail} record while preserving the associated {@link Instructor} entity
     * by severing the bidirectional relationship first.
     *
     * @param theId the primary key ID of the instructor detail record to remove
     */
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

    /**
     * Finds all {@link Course} entities associated with a given instructor ID using JPQL query.
     *
     * @param theId the instructor ID to search courses for
     * @return a list of {@link Course} objects taught by the specified instructor
     */
    @Override 
    public List<Course> findCoursesByInstructorId(int theId) {
        //create query
        TypedQuery<Course> query = em.createQuery(
            "From Course Where instructor.id=:data", Course.class);
        query.setParameter("data", theId);

        List<Course> courses = query.getResultList();
        return courses;
    }

    /**
     * Retrieves an {@link Instructor} along with eagerly fetched {@link Course} list and {@link InstructorDetail}
     * in a single query using JOIN FETCH.
     *
     * @param theId the instructor primary key ID
     * @return the populated {@link Instructor} entity
     */
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

    /**
     * Merges and updates the state of an existing {@link Instructor} entity in the persistence context.
     *
     * @param in the updated instructor entity instance
     */
    @Override 
    @Transactional
    public void update(Instructor in) {
        em.merge(in);
    }

    /**
     * Deletes an {@link Instructor} without deleting assigned courses by unlinking foreign key relations first.
     *
     * @param theId the primary key ID of the instructor to delete
     */
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

    /**
     * Persists a new {@link Course} entity into the database.
     *
     * @param theCourse the course entity to save
     */
    @Override 
    @Transactional 
    public void save(Course theCourse) {
        em.persist(theCourse);
    }

    /**
     * Retrieves a {@link Course} entity along with its associated {@link com.spring.hibernate_demo.entity.Review} list
     * eagerly loaded via JOIN FETCH.
     *
     * @param theId the course primary key ID
     * @return the {@link Course} object containing loaded reviews
     */
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

    /**
     * Deletes a {@link Course} entity by ID from the database.
     *
     * @param theId the primary key ID of the course to remove
     */
    @Override 
    @Transactional 
    public void deleteCourseById(int theId) {
        //retrieve the course
        Course course = em.find(Course.class, theId);

        //delete the course
        em.remove(course);
    }

    /**
     * Fetches a {@link Course} entity and eagerly loads all enrolled {@link Student} entities via JOIN FETCH.
     *
     * @param theId the primary key ID of the course
     * @return the {@link Course} entity with fetched students
     */
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

    /**
     * Fetches a {@link Student} entity and eagerly loads all enrolled {@link Course} entities via JOIN FETCH.
     *
     * @param theId the primary key ID of the student
     * @return the {@link Student} entity with fetched courses
     */
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

    /**
     * Merges and updates the state of an existing {@link Student} entity in the persistence context.
     *
     * @param student the updated student entity instance
     */
    @Override 
    @Transactional
    public  void update(Student student) {
        em.merge(student);
    }

    /**
     * Deletes a {@link Student} entity by ID without deleting associated courses by unlinking Many-to-Many associations first.
     *
     * @param theId the primary key ID of the student to remove
     */
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
