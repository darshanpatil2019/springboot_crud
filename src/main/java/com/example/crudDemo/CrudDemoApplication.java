package com.example.crudDemo;

import com.example.crudDemo.dao.StudentDAO;
import com.example.crudDemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			//createStudent(studentDAO);
			createMultipleStudent(studentDAO);
		};
	}

	private void createMultipleStudent(StudentDAO studentDAO) {

		//create multiple students

		System.out.println("Creating 3 student object ...");
		Student tempStudent1 = new Student("dimpal", "patil", "def@gmail.com");
		Student tempStudent2 = new Student("sanjay", "patil", "ghi@gmail.com");
		Student tempStudent3 = new Student("nilima", "patil", "lmn@gmail.com");

		//saving the student object
		System.out.println("Saving the students...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {

		//create the student object
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("darshan", "patil", "abc@gmail.com");

		//save the student object
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		//display id of save student
		System.out.println("Saved student. Generate id : " + tempStudent.getId());

	}

}
