package com.restapi.Model;

import com.aerospike.mapper.annotations.*;



@AerospikeRecord(namespace= "test",set="Employee")
public class Employee {
    @AerospikeKey

    @AerospikeBin

    private int id;
    @AerospikeBin
    private String name;
    @AerospikeBin
    private String email;
    @AerospikeBin
    private int sal;
    @AerospikeBin
    private String JoiningDate;
    @AerospikeEmbed
    @AerospikeBin
    private Department categories;

    public Employee(int id, String name, String email, int sal, String joiningDate, Department categories) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.sal = sal;
        JoiningDate = joiningDate;
        this.categories = categories;
    }

    public Employee() {
    }

    public Employee(String name, String email, int sal, String joiningDate, Department categories) {
    }



    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
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

    public int getSal() {
        return sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    public String getJoiningDate() {
        return JoiningDate;
    }

    public void setJoiningDate(String joiningDate) {
        JoiningDate = joiningDate;
    }

    public Department getCategories() {
        return categories;
    }

    public void setCategories(Department categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", sal=" + sal +
                ", JoiningDate='" + JoiningDate + '\'' +
                ", categories=" + categories +
                '}';
    }
}