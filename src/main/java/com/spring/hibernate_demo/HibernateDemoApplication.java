package com.spring.hibernate_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import com.spring.hibernate_demo.dao.StudentDao;
import com.spring.hibernate_demo.entity.Student;
// import java.util.List;

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
			// System.out.println("Hello World");
			createStudent(studentDao);
			// readStudent(studentDao);
			// queryStudents(studentDao);
			// queryStudentsLastname(studentDao);
			// updateStudent(studentDao);
			//deleteStudent(studentDao);
			// deleteAllStudents(studentDao);
		};
	}

	private void createStudent(StudentDao studentDao) {
		//create student object
		System.out.println("Creating student information...");
		Student student = new Student("Laurde", 
										"Amancio", 
										"laurde.amancio@example.com");
		
		//save student object
		System.out.println("Saving student information...");
		studentDao.save(student);

		//display id of the saved student
		System.out.println("Saved! Generated id: " + student.getId());
	}

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
	// 	int id = 3;
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

}