package com.kavinda.sms.service;

import com.kavinda.sms.model.Student;
import com.kavinda.sms.service.StudentService;
import java.util.ArrayList;
import java.util.List;

public class StudentService {

    // declaring a ArrayList
    private List<Student> students = new ArrayList<>();

    // add student
    public void addStudent(Student student){
        students.add(student);
    }

    // view all student
    public List<Student> getAllStudents(){
        return students;
    }

    // update student name by ID
    public void updateStudentName(int id , String newName){

        for(Student s : students){
            if(s.getId() == id){
                s.setName(newName);
                break;
            }
        }
    }

    // delete student by ID
    public void deleteStudent(int id){
        students.removeIf(s -> s.getId() == id);
    }
}