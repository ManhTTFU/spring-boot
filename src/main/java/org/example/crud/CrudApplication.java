package org.example.crud;

import org.example.crud.DAO.studentDAO;
import org.example.crud.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

    @Bean
    public CommandLineRunner commandLineRunner(studentDAO studentDAO) {
        return args -> {
//            createStudent(studentDAO);
//            readStudent(studentDAO);
//            queryStudent(studentDAO);
//            queryStudentByLastName(studentDAO);
//            updateStudent(studentDAO);
//            deleteStudent(studentDAO);
//            deleteAllStudent(studentDAO);
        };
    }

    private void deleteAllStudent(studentDAO studentDAO) {
        System.out.println("Deleting all students");
        int num = studentDAO.deleteAll();
        System.out.println("Deleted all students: " + num);

    }

    private void deleteStudent(studentDAO studentDAO) {
        int studentId = 3;
        System.out.println("Deleting student " + studentId);
        studentDAO.delete(studentId);
    }

    private void updateStudent(studentDAO studentDAO) {
        int studentId = 1;
        System.out.println("Get student with id " + studentId);
        Student student = studentDAO.findById(studentId);

        System.out.println(student);

        System.out.println("Updating student with id " + studentId);

        student.setFirstName("Phuong");
        studentDAO.update(student);

        System.out.println("Updated student with id " + student);

    }

    private void queryStudentByLastName(studentDAO studentDAO) {
        List<Student> students = studentDAO.findByLastName("Manh");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private void readStudent(studentDAO studentDAO) {

        System.out.println("Create Student...");
        Student tempStudent = new Student("Phuong", "Hoang", "phuonghoang@gmail.com");
        System.out.println("Save Student...");

        studentDAO.save(tempStudent);

        int theId = tempStudent.getId();

        System.out.println("Retrieve Student with id " + theId);
        Student myStudent = studentDAO.findById(theId);

        System.out.println("Found Student with id " + myStudent);

    }

    private void createStudent(studentDAO studentDAO) {
        System.out.println("Creating Student ...");
        Student student = new Student("Paul", "Manh", "manh@gmail.com");

        System.out.println("Created Student ...");

        studentDAO.save(student);

        System.out.println("Saved Student ...");
    }

    private void queryStudent(studentDAO studentDAO) {
        // get list student

        List<Student> students = studentDAO.findAll();

        // display student

        for (Student student : students) {
            System.out.println(student);
        }
    }



}
