package com.DYShunyaev.CourseWorkN1.controller;

import com.DYShunyaev.CourseWorkN1.entity.Employee;
import com.DYShunyaev.CourseWorkN1.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }
    @RequestMapping("/")
    public String showAll(Model model) {
        List<Employee> employeeList = service.showAllEmps();
        model.addAttribute("getAll", employeeList);

        return "showAll";
    }
}
