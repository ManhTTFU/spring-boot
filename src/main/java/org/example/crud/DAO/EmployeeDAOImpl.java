package org.example.crud.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.crud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    // define field for entitymanager
    private EntityManager entityManager;

    // setup contructor injection

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    public List<Employee> findAll() {
        // create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("SELECT e FROM Employee e", Employee.class);

        // execute query and get result list
        List<Employee> employees = theQuery.getResultList();

        // return the result
        return employees;
    }
}
