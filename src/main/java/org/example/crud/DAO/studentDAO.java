package org.example.crud.DAO;

import org.example.crud.entity.Student;

import java.util.List;

public interface studentDAO {

    void save(Student student);

    Student findById(int id);

    List<Student> findAll();

    List<Student> findByLastName(String lastName);

    void update(Student student);

    void delete(int id);

    int deleteAll();
}
