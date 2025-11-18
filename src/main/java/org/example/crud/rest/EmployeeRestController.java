package org.example.crud.rest;

import org.example.crud.entity.Employee;
import org.example.crud.service.EmployeeService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    // quick and dirty: inject employee dao ( use constructor injection )
    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // expose "/employees" and return a list of employeess
    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        Employee employee = employeeService.findById(id);
        if(employee == null) {
            throw new RuntimeException("Employee not found");
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee) {
        Employee employee1 = employeeService.save(employee);
        return employee1;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        Employee employee1 = employeeService.save(employee);
        return employee1;
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable int id) {
      Employee tempEmp = employeeService.findById(id);
      if (tempEmp == null) {
          throw new RuntimeException("Employee not found");
      }
      employeeService.deleteById(id);
    }

}
