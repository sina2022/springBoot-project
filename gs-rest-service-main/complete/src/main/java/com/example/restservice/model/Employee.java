package com.example.restservice.model;

public class Employee extends Person {
    private  int Id;
     Address address;

    public Employee(String firstName, String lastName, int id, Address address) {
        super(firstName, lastName);
        Id = id;
        this.address = address;
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
