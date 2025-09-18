package com.example;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Student {
    private String name;
    private int age;
    private String rollNumber;
    private String grade;

    public Student() {} // default constructor

    public Student(String name, int age, String rollNumber, String grade) {
        this.name = name;
        this.age = age;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getRollNumber() { return rollNumber; }
    public void setRollNumber(String rollNumber) { this.rollNumber = rollNumber; }

    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }

    @Override
    public String toString() {
        return rollNumber + " | " + name + " | " + age + " | " + grade;
    }
}
