package com.spring.hibernate_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import com.spring.hibernate_demo.dao.StudentDao;
import com.spring.hibernate_demo.entity.Student;
import java.util.List;
import com.spring.hibernate_demo.dao.AppDao;
import com.spring.hibernate_demo.entity.Instructor;
import com.spring.hibernate_demo.entity.InstructorDetail;
import com.spring.hibernate_demo.entity.Course;
import com.spring.hibernate_demo.entity.Review;

/**
 * HibernateDemoApplication.
 */
@SpringBootApplication
public class HibernateDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateDemoApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(StudentDao studentDao) {
		return runner -> {
			System.out.println("Hello World");
			// createStudent(studentDao);
			// readStudent(studentDao);
			// queryStudents(studentDao);
			// queryStudentsLastname(studentDao);
			// updateStudent(studentDao);
			// deleteStudent(studentDao);
			// deleteAllStudents(studentDao);
		};
	}

	// private void createStudent(StudentDao studentDao) {
	// 	//create student object
	// 	System.out.println("Creating student information...");
	// 	Student student = new Student("Lawrde Darryle", 
	// 									"Amancio", 
	// 									"lawde.amancio@example.com");
		
	// 	//save student object
	// 	System.out.println("Saving student information...");
	// 	studentDao.save(student);

	// 	//display id of the saved student
	// 	System.out.println("Saved! Generated id: " + student.getId());
	// }

	// private void readStudent(StudentDao studentDao) {
	// 	//retrieve student based on the id
	// 	System.out.println("Retrieving student id 3...");
	// 	Student student = studentDao.findById(3);

	// 	//display student 
	// 	System.out.println("Found the student: " + student);
	// }

	// private  void queryStudents(StudentDao studentDao) {
	// 	//get list of students
	// 	List<Student> students = studentDao.findAll();

	// 	//display students
	// 	for(Student s:students) {
	// 		System.out.println(s);
	// 	}
	// }

	// private void queryStudentsLastname(StudentDao studentDao) {
	// 	//get list of students by lastname
	// 	List<Student> students = studentDao.findByLastName("Amancio");

	// 	//display students
	// 	for(Student s:students) {
	// 		System.out.println(s);
	// 	}
	// }

	// private void updateStudent(StudentDao studentDao) {
	// 	//retrieve student based on the id
	// 	int id = 3;
	// 	System.out.println("Student ID: " + id);
	// 	Student student = studentDao.findById(id);

	// 	//update last name of the student
	// 	System.out.println("Updating student name...");
	// 	student.setLastName("Osorno");

	// 	//update student lastname
	// 	studentDao.update(student);

	// 	//display updated student 
	// 	System.out.println("Updated student information: " + student);
	// }

	// private void deleteStudent(StudentDao studentDao) {
	// 	//delete student based on the id
	// 	int id = 2;
	// 	System.out.println("Deleting ID: " + id);

	// 	//delete the student
	// 	studentDao.delete(id);
	// }

	// private void deleteAllStudents(StudentDao studentDao) {
	// 	//delete all students
	// 	System.out.println("Deleting all student information...");
	// 	int rowsDeleted = studentDao.deleteAll();
	// 	System.out.println("Number of deleted rows: " + rowsDeleted);
	// }

	///CONTINUATION OF THE APPDAO IMPLEMENTATION

	@Bean 
	CommandLineRunner commandLineRunner2(AppDao app) {
		return runner -> {
			// createInstructor(app);
			// findInstructor(app);
			// deleteInstructor(app);
			// findInstructorDetail(app);
			// deleteInstructorDetail(app);
			// createInstructorWithCourses(app);
			// findInstructorWithCourses(app);
			// findInstructorWithCoursesJoinFetch(app);
			// updateInstructor(app);
			// deleteInstructorOnly(app);
			// createCourseAndReview(app);
			// retrieveCourseAndReviews(app);
			// deleteCourseAndReviews(app);
			// createCourseAndStundents(app);
			// findCourseAndStudents(app);
			// findStudentAndCourses(app);
			// addMoreCoursesForStudent(app);
			// deleteCourseById(app);
			deleteStudent(app);
		};
	}

	// private void createInstructor(AppDao app) {
	// 	//create the instructor
	// 	Instructor ins = new Instructor("Lawrde Darryle",
	// 									"Amancio", 
	// 									"lawrde.amancio@example.com");
	// 	//create the instructor detail
	// 	InstructorDetail deets = new InstructorDetail("Math", 
	// 													"Solving Problems");

	// 	// associate the objects
	// 	ins.setInstructorDeets(deets);

	// 	//save the instructor
	// 	//this will also save the details object
	// 	System.out.println("Information saved!");
	// 	app.save(ins);

	// }

	// private void findInstructor(AppDao app) {
	// 	//find the instructor
	// 	int id = 1;
	// 	System.out.println("Find Id: " + id);

	// 	Instructor ins = app.findInstructorById(id);

	// 	System.out.println("Instructor: " + ins);
	// 	System.out.println("Details: " + ins.getInstructorDeets());
	// }

	// private void deleteInstructor(AppDao app) {
	// 	//delete the instructor
	// 	int id = 8;
	// 	System.out.println("Deleting Id: " + id);

	// 	app.deleteInstructorById(id);
	// 	System.out.println("Deleted successfully!");
	// }

	// private void findInstructorDetail(AppDao app) {
	// 	//get the instructor detail object
	// 	int id = 9;
	// 	InstructorDetail inDeets = app.findInstructorDetailById(id);

	// 	//print the instructor detail
	// 	System.out.println("Details: " + inDeets);

	// 	System.out.println("Instructor: " + inDeets.getInstructor());
	// }

	// private void deleteInstructorDetail(AppDao app) {
	// 	int id = 9;

	// 	System.out.println("Delete id: " + id);

	// 	app.deleteInstructorById(id);
	// 	System.out.println("Deleted Successfully!");
	// }
	// private void createInstructorWithCourses(AppDao app) {
	// 	//create the instructor and details
	// 	Instructor ins = new Instructor("Chie",
	// 									"San",
	// 									"chie.san@example.com");
	// 	InstructorDetail deets = new InstructorDetail("Panatanag Makabayan", 
	// 													"Panatang Makabuang");

	// 	//associate the objects
	// 	ins.setInstructorDeets(deets);

	// 	//create courses
	// 	Course course1 = new Course("Physics");
	// 	Course course2 = new Course("Biology");

	// 	//add course to instructor
	// 	ins.add(course1);
	// 	ins.add(course2);

	// 	//save the instructor
	// 	System.out.println("Courses saved: " + ins.getCourses());
	// 	app.save(ins);
	// }

	// private void findInstructorWithCourses(AppDao app) {
	// 	int id = 11;
	// 	System.out.println("Find Instructor id: " + id);

	// 	Instructor ins = app.findInstructorById(id);

	// 	System.out.println("Instructor: " + ins);
	// 	System.out.println("Courses: " + ins.getCourses());
	// }
	// private void findInstructorWithCoursesJoinFetch(AppDao app) {
	// 	int id = 11;
	// 	System.out.println("Find instructor id: " + id);
	// 	Instructor ins = app.findInstructorByIdJoinFetch(id);

	// 	System.out.println("Instructor: " + ins);
	// 	System.out.println("Courses: " + ins.getCourses());
	// }

	// private void updateInstructor(AppDao app) {
	// 	int id = 12;
	// 	System.out.println("Find instructor id: " + id);

	// 	Instructor ins = app.findInstructorById(id);

	// 	//change instructor's data
	// 	ins.setFirstName("Ritchie");

	// 	//update the data
	// 	System.out.println("Updated!");
	// 	app.update(ins);
	// }

	// private void deleteInstructorOnly(AppDao app) {
	// 	int id = 11;
	// 	System.out.println("Delte instructor: " + id);

	// 	app.deleteInstructorById(id);
	// 	System.out.println("Deleted successfully!");
	// }

	// private void createCourseAndReview(AppDao app){
	// //create a course
	// 	Course course = new Course("How to Speed Run in 1 Day");
	// 	course.addReview(new Review("Great speed 2x...loved it!!!"));
	// 	course.addReview(new Review("I wanted the speed 0.75x :(("));
	// 	course.addReview(new Review(
	// 						"Hoping to do a speed of 3x :D. Anyways, nice!"));

	// 	//save the course
	// 	System.out.println("Course saved!");
	// 	app.save(course);
	// }

	// private void retrieveCourseAndReviews(AppDao app) {
	// 	int id = 5;
	// 	System.out.println("Get course and reviews from id: " + id);
	// 	//get the course and reviews
	// 	Course course = app.findCourseAndReviewsByCourseId(id);

	// 	//print the course
	// 	System.out.println(course);

	// 	//print the reviews
	// 	System.out.println(course.getReview());
		
	// }

	// private void deleteCourseAndReviews(AppDao app) {
	// 	int id = 5;
	// 	System.out.println("Delete Course: " + id);

	// 	app.deleteCourseById(id);
	// 	System.out.println("Deleted successfully!");
	// }

	// private void createCourseAndStundents(AppDao app) {
	// 	//creat a course
	// 	Course course = new Course("How to Be A FullStack Dev in Half A Day");

	// 	//create the students
	// 	Student student1 = new Student("Light", 
	// 									"Yagami", 
	// 									"light.yagami@example.com");
	// 	Student student2 = new Student("Bal", "Mond", "bal.mond@example.com");

	// 	//add student to the course
	// 	course.addStudent(student1);
	// 	course.addStudent(student2);

	// 	//save the course and associated students
	// 	app.save(course);
	// 	System.out.println("Succesfully enrolled!");
	// }
	
	// private void findCourseAndStudents(AppDao app) {
	// 	int id = 6;
	// 	Course course = app.findCourseAndStudentByCourseId(id);

	// 	System.out.println("Course: " + course);
	// 	System.out.println("Students: " + course.getStudents());
	// }

	// private void findStudentAndCourses(AppDao app) {
	// 	int id = 4;
	// 	Student student = app.findStudentAndCoursesByStudentId(id);
		
	// 	System.out.println("Student: " + student);
	// 	System.out.println("Courses: " + student.getCourses());
	// }

	// private void addMoreCoursesForStudent(AppDao app) {
	// 	int id = 3;
	// 	Student student = app.findStudentAndCoursesByStudentId(id);

	// 	Course course1 = new Course("How to Test without Running Application");
	// 	Course course2 = new Course("How to Develop without Computer");
	// 	Course course3 = new Course("How to Be a Light Developer");

	// 	student.addCourse(course1);
	// 	student.addCourse(course2);
	// 	student.addCourse(course3);

	// 	System.out.println("Successfully enrolled to new courses!");

	// 	app.update(student);
	// }

	// private void deleteCourseById(AppDao app) {
	// 	int id = 8;
	// 	System.out.println("Delete Course: " + id);

	// 	app.deleteCourseById(id);
	// 	System.out.println("Deleted successfully!");
	// }

	private void deleteStudent(AppDao app) {
		int id = 1;
		System.out.println("Delete student: " + id);

		app.deleteStudentById(id);
		System.out.println("Deleted successfully!");
	}
}