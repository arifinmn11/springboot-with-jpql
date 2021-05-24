package com.mitramandiri.backend.services;

import com.mitramandiri.backend.entities.Employee;
import com.mitramandiri.backend.models.EmployeeRequest;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAllListForPagination(EmployeeRequest employeeRequest);

    Employee getById(Integer id);

    Employee insert(Employee employee);

    Employee update(Employee employee);

    Employee delete(Employee employee);

}
