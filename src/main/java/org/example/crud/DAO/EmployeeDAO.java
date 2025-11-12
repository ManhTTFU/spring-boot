package org.example.crud.DAO;

import org.example.crud.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
}
