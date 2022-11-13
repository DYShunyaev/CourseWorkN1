package com.DYShunyaev.CourseWorkN1.service;

import com.DYShunyaev.CourseWorkN1.entity.Employee;
import com.DYShunyaev.CourseWorkN1.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeService {
    private final EmployeeRepository repository;

    @Autowired
    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public List<Employee> showAllEmployees() {

        return (List<Employee>) repository.findAll();
    }

    public void saveEmployee(Employee employee) {
        repository.save(employee);
    }
}
