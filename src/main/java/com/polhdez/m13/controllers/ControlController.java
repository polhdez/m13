package com.polhdez.m13.controllers;

import com.polhdez.m13.enums.Jobs;
import com.polhdez.m13.models.Employee;
import com.polhdez.m13.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class ControlController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/control")
    public String getControl(Model model) {
        model.addAttribute("employees", employeeRepository.findAll());
        return "control";
    }

    @PostMapping("/control")
    public String postEmployee(Model model, @RequestParam String button, @RequestParam String id, @RequestParam String firstName, @RequestParam String lastName, @RequestParam String job, @RequestParam String salary) {

        Employee employee;

        switch (button) {
            case "create":
                employee = new Employee(firstName, lastName, Jobs.valueOf(job));
                employeeRepository.save(employee);
                break;
            case "delete":
                employeeRepository.deleteById(Long.parseLong(id));
                break;
            case "modify":
                try {
                    employee = employeeRepository.getOne(Long.parseLong(id));
                    Long employeeId = employee.getId();
                    employee = new Employee(firstName, lastName, Jobs.valueOf(job));
                    employee.setId(employeeId);
                    employee.setSalary(Double.parseDouble(salary));
                    employeeRepository.save(employee);
                } catch (Exception e) {
                    model.addAttribute("message", "Something is wrong with your input!");

                }
        }

        model.addAttribute("employees", employeeRepository.findAll());
        return "control";
    }
}
