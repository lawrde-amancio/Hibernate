package com.spring.hibernate_demo.dao;

import com.spring.hibernate_demo.entity.Instructor;
import com.spring.hibernate_demo.entity.InstructorDetail;
import java.util.List;
import com.spring.hibernate_demo.entity.Course;;

public interface AppDao {

    //Instructor
    void save(Instructor theInstructor);
    Instructor findInstructorById(int theId);

    //Instructor Detail
    void deleteInstructorById(int theId);
    InstructorDetail findInstructorDetailById(int theId);
    void deleteInstructorDetail(int theId);
    List<Course> findCoursesByInstructorId(int theId);
    Instructor findInstructorByIdJoinFetch(int theId);
}
