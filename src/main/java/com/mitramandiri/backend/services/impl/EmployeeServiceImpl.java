package com.mitramandiri.backend.services.impl;

import com.mitramandiri.backend.dao.EmployeeDao;
import com.mitramandiri.backend.entities.Employee;
import com.mitramandiri.backend.models.EmployeeRequest;
import com.mitramandiri.backend.models.PageList;
import com.mitramandiri.backend.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeDao employeeDao;

    @Override
    public PageList<Employee> findAllListForPagination(EmployeeRequest employeeRequest) {
        return employeeDao.getListForPagination(employeeRequest);
    }

    @Override
    public Employee getById(Integer id) {
        return employeeDao.getById(id);
    }

    @Override
    public Employee insert(Employee employee) {
        return employeeDao.insert(employee);
    }

    @Override
    public Employee update(Employee employee) {
        return employeeDao.update(employee);
    }

    @Override
    public Employee delete(Employee employee) {
        return employeeDao.delete(employee);
    }
}
