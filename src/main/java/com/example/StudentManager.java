package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentManager {
    private List<Student> students;

    public StudentManager(List<Student> students) {
        this.students = new ArrayList<>(students);
    }

    public void addStudent(Student s) {
        students.add(s);
        FileUtils.logOperation("Added student: " + s);
    }

    public boolean editStudent(String rollNumber, Student updated) {
        Optional<Student> studentOpt = students.stream()
            .filter(s -> s.getRollNumber().equals(rollNumber))
            .findFirst();
        if (studentOpt.isPresent()) {
            Student s = studentOpt.get();
            s.setName(updated.getName());
            s.setAge(updated.getAge());
            s.setGrade(updated.getGrade());
            FileUtils.logOperation("Edited student: " + s);
            return true;
        }
        return false;
    }

    public boolean deleteStudent(String rollNumber) {
        Optional<Student> studentOpt = students.stream()
            .filter(s -> s.getRollNumber().equals(rollNumber))
            .findFirst();
        if (studentOpt.isPresent()) {
            students.remove(studentOpt.get());
            FileUtils.logOperation("Deleted student: " + studentOpt.get());
            return true;
        }
        return false;
    }

    public List<Student> getStudents() {
        return students;
    }
}
