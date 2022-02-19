package com.example.restservice.service;

import com.example.restservice.model.*;

import java.util.*;

public class EmployeeService {

   static List<Employee> employees= new ArrayList<>();

    public List<Employee> getAllEmployees(){

       Employee employee1=new Employee("john",
               "luck", 1,
               new Address(123,"saint catherin",new City("montreal","QC"))
               ) ;
        Employee employee2=new Employee("sina",
                "kooshesh", 2,
                new Address(345,"ridge wood",new City("montreal","QC"))
        ) ;
        Employee employee3=new Employee("reza",
                "shalchi", 3,
                new Address(567,"saint catherin",new City("montreal","QC"))
        ) ;
        Employee employee4=new Employee("masoud",
                "bozorgi", 4,
                new Address(891,"ridge wood",new City("montreal","QC"))
        ) ;


        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        System.out.println(employees);
        return employees;
    }

    public Employee getEmployeeById(int Id){
        for(Employee E : employees){
            if (E.getId() == Id){
                return E;
            }
        }
        return null;
    }
    public  Employee getByName(String name){
        for(Employee E : employees){
            if (Objects.equals(E.getFirstName(), name)){
                return E;
            }
        }
        return null;
    }
    public  Employee getByStreet(String street){
        for(Employee E : employees){
            if (Objects.equals(E.getAddress().getStreetName(), street)){
                return E;
            }
        }
        return null;
    }


    public  void addEmployee(Employee employee){
        employees.add(employee);
    }
}

