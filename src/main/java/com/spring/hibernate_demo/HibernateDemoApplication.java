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
 * Spring Boot main application class for demonstrating Hibernate/JPA mapping configurations,
 * DAO operations, and entity relationships (One-to-One, One-to-Many, Many-to-Many).
 */
@SpringBootApplication
public class HibernateDemoApplication {

	/**
     * Main entry point of the Spring Boot application.
     *
     * @param args command-line arguments passed during execution
     */
	public static void main(String[] args) {
		SpringApplication.run(HibernateDemoApplication.class, args);
	}

	/**
     * Defines a {@link CommandLineRunner} bean executing operations via {@link StudentDao}.
     *
     * @param studentDao data access object for performing CRUD operations on {@link Student} entities
     * @return a runner executing initial startup operations
     */
	@Bean
	CommandLineRunner commandLineRunner(StudentDao studentDao) {
		return runner -> {
			// System.out.println("Hello World");
			// createStudent(studentDao);
			// readStudent(studentDao);
			// queryStudents(studentDao);
			// queryStudentsLastname(studentDao);
			// updateStudent(studentDao);
			// deleteStudent(studentDao);
			// deleteAllStudents(studentDao);
		};
	}

	/**
     * Creates and persists a new {@link Student} entity to the database.
     *
     * @param studentDao data access object used for persistence
     */
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

	/**
     * Retrieves and displays a {@link Student} entity by its unique ID.
     *
     * @param studentDao data access object used to fetch entity data
     */
	// private void readStudent(StudentDao studentDao) {
	// 	//retrieve student based on the id
	// 	System.out.println("Retrieving student id 3...");
	// 	Student student = studentDao.findById(3);

	// 	//display student 
	// 	System.out.println("Found the student: " + student);
	// }

	/**
     * Fetches and displays all {@link Student} entities present in the database.
     *
     * @param studentDao data access object used to query all records
     */
	// private  void queryStudents(StudentDao studentDao) {
	// 	//get list of students
	// 	List<Student> students = studentDao.findAll();

	// 	//display students
	// 	for(Student s:students) {
	// 		System.out.println(s);
	// 	}
	// }

	/**
     * Queries and displays {@link Student} entities matching a specific last name.
     *
     * @param studentDao data access object used to execute filtered query
     */
	// private void queryStudentsLastname(StudentDao studentDao) {
	// 	//get list of students by lastname
	// 	List<Student> students = studentDao.findByLastName("Amancio");

	// 	//display students
	// 	for(Student s:students) {
	// 		System.out.println(s);
	// 	}
	// }

	/**
     * Updates an existing {@link Student} record in the database.
     *
     * @param studentDao data access object used to apply entity updates
     */
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

	/**
     * Deletes a specific {@link Student} record from the database by ID.
     *
     * @param studentDao data access object used to remove record
     */
	// private void deleteStudent(StudentDao studentDao) {
	// 	//delete student based on the id
	// 	int id = 2;
	// 	System.out.println("Deleting ID: " + id);

	// 	//delete the student
	// 	studentDao.delete(id);
	// }

	/**
     * Deletes all {@link Student} records from the database.
     *
     * @param studentDao data access object used to execute bulk deletion
     */
	// private void deleteAllStudents(StudentDao studentDao) {
	// 	//delete all students
	// 	System.out.println("Deleting all student information...");
	// 	int rowsDeleted = studentDao.deleteAll();
	// 	System.out.println("Number of deleted rows: " + rowsDeleted);
	// }

	///CONTINUATION OF THE APPDAO IMPLEMENTATION

	/**
     * Defines a {@link CommandLineRunner} bean executing relationship management operations via {@link AppDao}.
     *
     * @param app data access object for handling complex entity mappings (Instructors, Courses, Reviews, Students)
     * @return a runner executing complex relationship queries and cascades
     */
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
			// findCoursesForInstructor(app);
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

	/**
     * Creates and persists an {@link Instructor} along with associated {@link InstructorDetail} via cascading.
     *
     * @param app data access object for persistence operations
     */
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

	/**
     * Retrieves an {@link Instructor} and its mapped {@link InstructorDetail} by ID.
     *
     * @param app data access object used for retrieval
     */
	// private void findInstructor(AppDao app) {
	// 	//find the instructor
	// 	int id = 1;
	// 	System.out.println("Find Id: " + id);

	// 	Instructor ins = app.findInstructorById(id);

	// 	System.out.println("Instructor: " + ins);
	// 	System.out.println("Details: " + ins.getInstructorDeets());
	// }

	/**
     * Deletes an {@link Instructor} and cascade-deletes associated details from the database.
     *
     * @param app data access object used for deletion
     */
	// private void deleteInstructor(AppDao app) {
	// 	//delete the instructor
	// 	int id = 8;
	// 	System.out.println("Deleting Id: " + id);

	// 	app.deleteInstructorById(id);
	// 	System.out.println("Deleted successfully!");
	// }

	/**
     * Retrieves {@link InstructorDetail} by ID and logs bidirectionally associated {@link Instructor}.
     *
     * @param app data access object used for lookup
     */
	// private void findInstructorDetail(AppDao app) {
	// 	//get the instructor detail object
	// 	int id = 9;
	// 	InstructorDetail inDeets = app.findInstructorDetailById(id);

	// 	//print the instructor detail
	// 	System.out.println("Details: " + inDeets);

	// 	System.out.println("Instructor: " + inDeets.getInstructor());
	// }

	/**
     * Deletes {@link InstructorDetail} record by deleting the underlying associated instructor.
     *
     * @param app data access object used for deletion
     */
	// private void deleteInstructorDetail(AppDao app) {
	// 	int id = 9;

	// 	System.out.println("Delete id: " + id);

	// 	app.deleteInstructorById(id);
	// 	System.out.println("Deleted Successfully!");
	// }

	/**
     * Creates an {@link Instructor}, associates multiple {@link Course} objects, and persists them using cascading.
     *
     * @param app data access object used for persisting parent and child entities
     */
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

	/**
     * Retrieves an {@link Instructor} by ID and lazily fetches assigned {@link Course} records.
     *
     * @param app data access object used for entity lookup
     */
	// private void findInstructorWithCourses(AppDao app) {
	// 	int id = 11;
	// 	System.out.println("Find Instructor id: " + id);

	// 	Instructor ins = app.findInstructorById(id);

	// 	System.out.println("Instructor: " + ins);
	// 	System.out.println("Courses: " + ins.getCourses());
	// }

	/**
 	 * Retrieves an {@link Instructor} by ID and fetches their associated {@link Course} list,
 	 * manually setting the courses onto the instructor object to handle lazy loading.
 	 *
 	 * @param app data access object used for querying instructor and course records
 	 */
	// private void findCoursesForInstructor(AppDao app) {
	// 	int id = 3;

	// 	//find the instructor
	// 	System.out.println("Find instructor id: " + id);
	// 	Instructor ins = app.findInstructorById(id);

	// 	System.out.println("Instructor: " + ins);

	// 	//find course for instructor
	// 	System.out.println("Courses from id: " + id);
	// 	List<Course> courses = app.findCoursesByInstructorId(id);

	// 	//associate the objects
	// 	ins.setCourses(courses);

	// 	//get courses
	// 	System.out.println(ins.getCourses());
	// }

	/**
     * Retrieves an {@link Instructor} and eager-loads assigned {@link Course} records in a single query using JOIN FETCH.
     *
     * @param app data access object executing the JOIN FETCH query
     */
	// private void findInstructorWithCoursesJoinFetch(AppDao app) {
	// 	int id = 11;
	// 	System.out.println("Find instructor id: " + id);
	// 	Instructor ins = app.findInstructorByIdJoinFetch(id);

	// 	System.out.println("Instructor: " + ins);
	// 	System.out.println("Courses: " + ins.getCourses());
	// }

	/**
     * Modifies properties of an existing {@link Instructor} and persists changes to the database.
     *
     * @param app data access object used for updating entity state
     */
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

	/**
     * Removes an {@link Instructor} record from the database without deleting associated standalone entities.
     *
     * @param app data access object used for deletion
     */
	// private void deleteInstructorOnly(AppDao app) {
	// 	int id = 11;
	// 	System.out.println("Delte instructor: " + id);

	// 	app.deleteInstructorById(id);
	// 	System.out.println("Deleted successfully!");
	// }

	/**
     * Creates a {@link Course} and adds associated {@link Review} objects before persisting to the database.
     *
     * @param app data access object handling course creation and review cascades
     */
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

	/**
     * Retrieves a {@link Course} entity along with associated {@link Review} records by course ID.
     *
     * @param app data access object used for fetching course and reviews
     */
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

	/**
     * Deletes a {@link Course} record along with all associated reviews.
     *
     * @param app data access object used for course and review deletion
     */
	// private void deleteCourseAndReviews(AppDao app) {
	// 	int id = 5;
	// 	System.out.println("Delete Course: " + id);

	// 	app.deleteCourseById(id);
	// 	System.out.println("Deleted successfully!");
	// }

	/**
     * Creates a new {@link Course}, links multiple {@link Student} entities to it, and saves them (Many-to-Many relationship).
     *
     * @param app data access object handling join table insertions
     */
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
	
	/**
     * Fetches a {@link Course} and its enrolled {@link Student} records using course ID.
     *
     * @param app data access object executing Many-to-Many query
     */
	// private void findCourseAndStudents(AppDao app) {
	// 	int id = 6;
	// 	Course course = app.findCourseAndStudentByCourseId(id);

	// 	System.out.println("Course: " + course);
	// 	System.out.println("Students: " + course.getStudents());
	// }

	/**
     * Fetches a {@link Student} and all enrolled {@link Course} records using student ID.
     *
     * @param app data access object executing Many-to-Many query
     */
	// private void findStudentAndCourses(AppDao app) {
	// 	int id = 4;
	// 	Student student = app.findStudentAndCoursesByStudentId(id);
		
	// 	System.out.println("Student: " + student);
	// 	System.out.println("Courses: " + student.getCourses());
	// }

	/**
     * Enrolls an existing {@link Student} into additional {@link Course} instances and updates the mapping.
     *
     * @param app data access object used to retrieve and update the student relationship
     */
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

	/**
     * Removes a specific {@link Course} from the database by ID.
     *
     * @param app data access object used for course deletion
     */
	// private void deleteCourseById(AppDao app) {
	// 	int id = 8;
	// 	System.out.println("Delete Course: " + id);

	// 	app.deleteCourseById(id);
	// 	System.out.println("Deleted successfully!");
	// }

	/**
     * Removes a specific {@link Student} record from the database using {@link AppDao}.
     *
     * @param app data access object used for student deletion by ID
     */
	private void deleteStudent(AppDao app) {
		int id = 1;
		System.out.println("Delete student: " + id);

		app.deleteStudentById(id);
		System.out.println("Deleted successfully!");
	}
}