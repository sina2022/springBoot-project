package com.example.restservice.api;

import com.example.restservice.exception.*;
import com.example.restservice.model.*;
import com.example.restservice.service.*;
import org.springframework.http.*;
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
    public ResponseEntity<Employee> getById(@PathVariable int Id){

        try{
            return new ResponseEntity<>(employeeService.getEmployeeById(Id),HttpStatus.ACCEPTED);
        }
        catch (EmployeeNotFoundException employeeNotFoundException){
            return  new ResponseEntity(employeeNotFoundException.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/Employ/{name}")
    public Employee getEmployeeByName(@PathVariable String name){
        return employeeService.getByName(name);
    }
//
    @GetMapping("/Empl/{street}")
    public Employee getEmployeeByStreet(@PathVariable String street){
        return employeeService.getByStreet(street);
    }

    //POST
    @PostMapping("/Employee")
    public ResponseEntity<Employee>  saveEmployee(@RequestBody Employee employee) {
        try {employeeService.addEmployee(employee);
            return new ResponseEntity(employee, HttpStatus.CREATED);
        } catch (EmployeeExistExeption employeeExistExeption) {

            return new ResponseEntity(employeeExistExeption.getMessage(),HttpStatus.ALREADY_REPORTED);
        }
    }
}
