package com.mitramandiri.backend.controllers;


import com.mitramandiri.backend.entities.Employee;
import com.mitramandiri.backend.entities.Position;
import com.mitramandiri.backend.models.EmployeeRequest;
import com.mitramandiri.backend.models.PageList;
import com.mitramandiri.backend.models.ResponseMessage;
import com.mitramandiri.backend.services.EmployeeService;
import com.mitramandiri.backend.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    PositionService positionService;

    @GetMapping("/employees")
    public ResponseMessage<?> findAllWithPagination(
            EmployeeRequest request
    ) {

        PageList <Employee> employees = employeeService.findAllListForPagination(request);

        return ResponseMessage.success(employees);
    }

    @GetMapping("/employee/{id}")
    public ResponseMessage<Employee> findById(
            @PathVariable Integer id
    ) {

        Employee employee = employeeService.getById(id);

        if (employee != null) {
            return ResponseMessage.success(employee);
        }
        return ResponseMessage.error(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/employee")
    public ResponseMessage<Employee> insert(
            @RequestBody @NotNull Employee employee
    ) {

        Position position = positionService.findById(employee.getPositionId().getId());

        if (position == null) {
            return ResponseMessage.error(HttpStatus.NOT_FOUND);
        }

        Employee entity = employeeService.insert(employee);

        if (employee != null) {
            return ResponseMessage.success(entity);
        }

        return ResponseMessage.error(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/employee")
    public ResponseMessage<?> update(
            @RequestBody @NotNull Employee employee
    ) {
        Employee entity = employeeService.getById(employee.getId());

        Position position = positionService.findById(employee.getPositionId().getId());

        if (position == null || entity == null) {
            return ResponseMessage.error(HttpStatus.NOT_FOUND);
        }

        entity.setBirthDate(employee.getBirthDate());
        entity.setGender(employee.getGender());
        entity.setIdNumber(employee.getIdNumber());
        entity.setName(employee.getName());
        entity.setPositionId(position);

        entity = employeeService.update(entity);

        if (employee != null) {
            return ResponseMessage.success(entity);
        }

        return ResponseMessage.error(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/employee")
    public ResponseMessage<?> delete(
            @RequestBody @NotNull Employee employee
    ) {
        Employee entity = employeeService.getById(employee.getId());

        Position position = positionService.findById(employee.getPositionId().getId());

        if (position == null || entity == null) {
            return ResponseMessage.error(HttpStatus.NOT_FOUND);
        }

        entity = employeeService.delete(entity);

        if (employee != null) {
            return ResponseMessage.success(entity);
        }

        return ResponseMessage.error(HttpStatus.NOT_FOUND);
    }
}
