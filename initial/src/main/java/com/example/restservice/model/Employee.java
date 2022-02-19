package com.example.restservice.model;

public class Employee{
    private String firstName;
    private String lastName;
    private  int Id;
     Address address;

    public Employee(String firstName, String lastName, int id, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        Id = id;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
