package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(CruddemoApplication.class, args);
  }

  @Bean
  public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
    return runner -> {
      // createStudent(studentDAO);

      // createMultipleStudents(studentDAO);

      readStudent(studentDAO);
    };
  }

  private void readStudent(StudentDAO studentDAO) {

    // create a student object
    System.out.println("Creating a new student object ...");
    Student tempStudent = new Student("Daffy", "Duck", "daffy@luv2code.com");

    // save the student
    System.out.println("Saving the student ...");
    studentDAO.save(tempStudent);

    // display id of the saved student
    int theId = tempStudent.getId();
    System.out.println("Saved Student. Generated Id: " + theId);

    // retrieve student based on the id: primary key
    System.out.println("Retrieving the Student with id: " + theId);
    Student myStudent = studentDAO.findById(theId);

    // display student
    System.out.println(myStudent);
  }

  private void createMultipleStudents(StudentDAO studentDAO) {

    // create multiple students
    System.out.println("Creating new student object ...");
    Student tempStudent1 = new Student("Joao", "de Tal", "joao@luv2code.com");
    Student tempStudent2 = new Student("Maria", "Publica", "maria@luv2code.com");
    Student tempStudent3 = new Student("Bonita", "Applebum", "bonita@luv2code.com");

    // save the student objects
    System.out.println("Saving the students ...");
    studentDAO.save(tempStudent1);
    studentDAO.save(tempStudent2);
    studentDAO.save(tempStudent3);
  }

  private void createStudent(StudentDAO studentDAO) {
    // create the student object
    System.out.println("Creating new student object ...");
    Student tempStudent = new Student("Paulo", "de Tal", "paulo@luv2code.com");

    // save the student object
    System.out.println("Saving the student ...");
    studentDAO.save(tempStudent);

    // display id of the saved student
    System.out.println("Saved student. Generated id: " + tempStudent.getId());
  }
}
