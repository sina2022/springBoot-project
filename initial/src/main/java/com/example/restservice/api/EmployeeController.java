package com.example.restservice.api;

import com.example.restservice.model.*;
import com.example.restservice.service.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class EmployeeController {
    EmployeeService employeeService = new EmployeeService();
    //GET
    @GetMapping("/Employee")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    //I want to use the same route => (/pet) but I want to send an id to filter the data
    //PathVariable
    @GetMapping("/Employee/{Id}")
    public Employee getById(@PathVariable int Id){
        return employeeService.getEmployeeById(Id);
    }

    @GetMapping("/Employee/name/{name}")
    public Employee getEmployeeByName(@PathVariable String name){
        return employeeService.getByName(name);
    }
//
    @GetMapping("/Employee/street/{street}")
    public Employee getEmployeeByStreet(@PathVariable String street){
        return employeeService.getByStreet(street);
    }

    //POST
    @PostMapping("/Employee")
    public Employee saveEmployee(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
        return employee;
    }
}
