package com.homework.services;


import com.homework.dao.EmployeeDao;
import com.homework.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeService {


    @Autowired
    EmployeeDao employeeDao;

    public List<Employee> listEmployees () {
        return employeeDao.listEmployees();
    }
    public void deleteEmployee (int employeeId) {
        employeeDao.deleteEmployee(employeeId);

    }
    public List<Employee> searchEmployees(String searchTerm) {
        return employeeDao.search(searchTerm);
    }

    public Employee getEmployee (int id) {
        return employeeDao.getEmployee(id);
    }

    public void editEmployee (Employee employee) {
        employeeDao.edit(employee);
    }



}
