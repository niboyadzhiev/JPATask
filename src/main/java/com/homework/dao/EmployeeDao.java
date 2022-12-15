package com.homework.dao;

import com.homework.model.Employee;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Primary
public class EmployeeDao extends AbstractDao<Employee> {


    public EmployeeDao(Class<Employee> entityClass) {
        super(entityClass);
    }
    @Transactional(Transactional.TxType.REQUIRED)
    public List<Employee> listEmployees () {
        return this.findAll();
    }
    @Transactional(Transactional.TxType.REQUIRED)
    public Employee getEmployee (int id) {
        return this.findOne(id);
    }
    @Transactional(Transactional.TxType.REQUIRED)
    public void deleteEmployee (int id) {
        this.deleteById(id);
    }
    @Transactional(Transactional.TxType.REQUIRED)
    public List<Employee> search (String searchParam) {
        return super.search(searchParam);
    }
    @Transactional(Transactional.TxType.REQUIRED)
    public void edit (Employee employee) {
        this.editByEmployee(employee);
    }



}
