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
        } catch (EmployeeExistException employeeExistException) {

            return new ResponseEntity(employeeExistException.getMessage(),HttpStatus.ALREADY_REPORTED);
        }
    }

  @PutMapping("/Employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id,@RequestBody Employee employee){
        try {
            employeeService.updateEmployee(id,employee);
            return new ResponseEntity<>(employee, HttpStatus.ACCEPTED);
        }
        catch (EmployeeNotFoundException employeeNotFoundException){
            return  new ResponseEntity(employeeNotFoundException.getMessage(),HttpStatus.BAD_REQUEST);
        }
  }

    @DeleteMapping("/Employee/{id}")
    public ResponseEntity deleteEmployee(@PathVariable int id){
        try{
            employeeService.deleteEmployee(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch (EmployeeNotFoundException exception){
            return new ResponseEntity(exception.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
