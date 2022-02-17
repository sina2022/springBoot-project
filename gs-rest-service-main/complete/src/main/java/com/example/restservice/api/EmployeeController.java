package com.example.restservice.api;

import com.example.restservice.model.*;
import com.example.restservice.service.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

public class EmployeeController {
    EmployeeService employeeService = new EmployeeService();
    //GET
    @GetMapping("/Employee")
    public List<Employee> getAllEmployees(){
        return EmployeeService.getAllEmployees();
    }


    @GetMapping("/Employee/{Id}")
    public Employee getById(@PathVariable int Id){
        return EmployeeService.getEmployeeById(Id);
    }

    //POST
    @PostMapping("/Employee")
    public Employee saveEmployee(@RequestBody Employee employee){
        EmployeeService.addEmployee(employee);
        return employee;
    }
}
