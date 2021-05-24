package com.mitramandiri.backend.dao.impl;

import com.mitramandiri.backend.dao.EmployeeDao;
import com.mitramandiri.backend.dao.PositionDao;
import com.mitramandiri.backend.entities.Employee;
import com.mitramandiri.backend.entities.Position;
import com.mitramandiri.backend.models.EmployeeRequest;
import com.mitramandiri.backend.models.PageList;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDao {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private PositionDaoImpl positionDao;

    @Override
    @Transactional
    public PageList<Employee> getListForPagination(EmployeeRequest employeeRequest) {
        Session currentSession = entityManager.unwrap(Session.class);


        Query<Employee> query = currentSession.createQuery("FROM Employee e where (e.isDeleted = false) AND " +
                "(:name is null OR e.name LIKE CONCAT('%',:name,'%')) AND " +
                "(:idNumber is null OR e.idNumber LIKE CONCAT('%',:idNumber,'%')) AND " +
                "(:gender is null OR e.gender LIKE CONCAT('%',:gender,'%')) AND " +
                "(:birthDate is null OR e.birthDate LIKE CONCAT('%',:birthDate,'%')) ", Employee.class);

        query.setParameter("name", employeeRequest.getName());
        query.setParameter("idNumber", employeeRequest.getIdNumber());
        query.setParameter("birthDate", employeeRequest.getBirthDate());
        query.setParameter("gender", employeeRequest.getGender());

        long total = query.getResultList().size();

        query.setFirstResult(employeeRequest.getPage());
        query.setMaxResults(employeeRequest.getSize());

        int size = query.getMaxResults();
        int page = query.getFirstResult();

        List<Employee> employees = query.getResultList();
        PageList<Employee> pageList = new PageList<Employee>(employees, page, size, total);

        return pageList;
    }

    @Override
    @Transactional
    public Employee getById(Integer id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Employee> query = currentSession.createQuery("FROM Employee e Where e.isDeleted = false and e.id = :id", Employee.class);
        query.setParameter("id", id);
        //execute query and get result list
        Employee employee = query.getSingleResult();

        return employee;
    }

    @Override
    @Transactional
    public Employee insert(Employee employee) {
        Session currentSession = entityManager.unwrap(Session.class);

        int id = (Integer) currentSession.save(employee);

        if (id == 0) {
            return null;
        }

        return employee;
    }

    @Override
    @Transactional
    @Modifying
    public Employee update(Employee employee) {

        Session currentSession = entityManager.unwrap(Session.class);

        Query<Employee> query = currentSession.createQuery("UPDATE FROM Employee e set e.idNumber = :idNumber," +
                "e.name = :name, e.birthDate = :birthDate, e.gender = :gender, e.positionId = :positionId WHERE e.id=:id");
        query.setParameter("id", employee.getId());
        query.setParameter("name", employee.getName());
        query.setParameter("idNumber", employee.getIdNumber());
        query.setParameter("birthDate", employee.getBirthDate());
        query.setParameter("gender", employee.getGender());
        query.setParameter("positionId", employee.getPositionId());

        query.executeUpdate();

        return employee;
    }

    @Override
    @Transactional
    @Modifying
    public Employee delete(Employee employee) {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Employee> query = currentSession.createQuery("UPDATE FROM Employee e set e.isDeleted = true WHERE e.id=:id");
        query.setParameter("id", employee.getId());

        query.executeUpdate();

        return employee;
    }
}
