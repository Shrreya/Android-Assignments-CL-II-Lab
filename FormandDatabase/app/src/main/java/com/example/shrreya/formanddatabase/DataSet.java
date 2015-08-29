package com.example.shrreya.formanddatabase;

//class defining one set of data
public class DataSet {
    //data set must contain id, name, email and phone number
    private int id;
    private String name,email,number;

    //getter and setter functions for each data member
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
}
