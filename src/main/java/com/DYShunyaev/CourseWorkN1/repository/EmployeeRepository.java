package com.DYShunyaev.CourseWorkN1.repository;

import com.DYShunyaev.CourseWorkN1.entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
