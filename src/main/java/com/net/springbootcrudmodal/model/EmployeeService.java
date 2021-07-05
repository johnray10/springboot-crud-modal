package com.net.springbootcrudmodal.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    //Get All Employees
    public List<Employee> getEmployees() {
        return employeeDao.findAll();
    }

    //Get Employee By Id
    public Optional<Employee> findById(int id) {
        return employeeDao.findById(id);
    }

    //Delete Employee
    public void delete(int id) {
        employeeDao.deleteById(id);
    }

    //Update Employee
    public void save(Employee employee) {
        employeeDao.save(employee);
    }

}
