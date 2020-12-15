package com.example.workflow.dto;

import java.io.Serializable;

public class EmployeeDTO implements Serializable {

    private int age;

    private String name;

    public EmployeeDTO() {
    }

    public EmployeeDTO(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}