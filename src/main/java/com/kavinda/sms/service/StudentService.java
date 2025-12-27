package com.kavinda.sms.service;

import com.kavinda.sms.model.Student;
import com.kavinda.sms.service.StudentService;
import com.kavinda.sms.dao.StudentDAO;

import java.util.ArrayList;
import java.util.List;

public class StudentService {

    private final StudentDAO studentDAO = new StudentDAO();

    public boolean addStudent(Student student){

        if(student.getAge() <= 0 || !student.getEmail().contains("@")){
            System.out.println("invalid student details");
            return false;
        }

        return studentDAO.addStudent(student);
    }

    public List<Student> getAllStudents(){
        return studentDAO.getAllStudents();
    }

    public boolean searchID(int id){
        return  studentDAO.searchID(id);
    }

    public boolean updateStudent(int id , String name , String email , int age){

        if(age <= 0 || !email.contains("@")){
            System.out.println("Invalid input!");
            return false;
        }

        return studentDAO.updateStudent(id, name, email, age);
    }

    public boolean deleteStudent(int id){
         return  studentDAO.deleteStudent(id);
    }
}