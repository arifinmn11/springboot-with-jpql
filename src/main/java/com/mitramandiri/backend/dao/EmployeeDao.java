package com.mitramandiri.backend.dao;

import com.mitramandiri.backend.entities.Employee;
import com.mitramandiri.backend.models.EmployeeRequest;
import com.mitramandiri.backend.models.PageList;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface EmployeeDao {
    PageList<Employee> getListForPagination(EmployeeRequest employeeRequest);

    Employee getById(Integer id);

    Employee insert(Employee employee);

    Employee update(Employee employee);

    Employee delete(Employee employee);
}
