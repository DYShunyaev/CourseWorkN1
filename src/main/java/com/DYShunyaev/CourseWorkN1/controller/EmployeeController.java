package com.DYShunyaev.CourseWorkN1.controller;

import com.DYShunyaev.CourseWorkN1.entity.Employee;
import com.DYShunyaev.CourseWorkN1.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
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
        List<Employee> employeeList = service.showAllEmployees();
        model.addAttribute("getAll", employeeList);

        return "showAll";
    }

    @GetMapping("/addNewEmployee")
    public String addNewEmployee(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);

        return "addNewEmployee";
    }

    @PostMapping("/addNewEmployee")
    public String saveEmployee(@RequestParam(name = "name", required = false, defaultValue = "null") String name,
                               @RequestParam(name = "surname", required = false, defaultValue = "null") String surname,
                               @RequestParam(name = "birthday", required = false, defaultValue = "2000-01-01") Date birthday,
                               @RequestParam(name = "department", required = false, defaultValue = "null") String department,
                               @RequestParam(name = "dateGetJob", required = false, defaultValue = "2000-01-01") Date dateGetJob,
                               @RequestParam(name = "salary", required = false, defaultValue = "0") Long salary) {
        Employee employee = new Employee(name, surname, birthday, department, dateGetJob, salary);
        service.saveEmployee(employee);

        return "redirect:/";
    }

    @RequestMapping("/{id}/editEmployee")
    public String editEmployee(@PathVariable(value = "id") long id, Model model) {
        if(!service.existById(id)) {
            return "redirect:/";
        }
        Employee employee = service.showById(id).orElseThrow();
        model.addAttribute("editEmpl", employee);

        return "editEmployee";
    }

    @PostMapping("/{id}/editEmployee")
    public String saveEdit(@PathVariable(value = "id") long id,
                           @RequestParam(name = "name", required = false) String name,
                           @RequestParam(name = "surname", required = false) String surname,
                           @RequestParam(name = "birthday", required = false) Date birthday,
                           @RequestParam(name = "department", required = false) String department,
                           @RequestParam(name = "dateGetJob", required = false) Date dateGetJob,
                           @RequestParam(name = "salary", required = false) Long salary) {
        Employee employee = service.showById(id).orElseThrow();

        employee.setName(name);
        employee.setSurname(surname);
        employee.setBirthday(birthday);
        employee.setDepartment(department);
        employee.setDateGetJob(dateGetJob);
        employee.setSalary(salary);

        service.saveEmployee(employee);

        return "redirect:/";
    }

    @RequestMapping("/{id}/deleteEmployee")
    public String deleteEmployeeById(@PathVariable(value = "id") long id) {
        service.deleteEmployee(id);

        return "redirect:/";
    }
}
