package com.kavinda.sms.dao;

import com.kavinda.sms.model.Student;
import com.kavinda.sms.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO{

    //insert student
    public boolean addStudent(Student student){
        String sql = "INSERT INTO students (name , email , age ) VALUES ( ? , ? , ? )";

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){


            stmt.setString(1 , student.getName());
            stmt.setString(2 , student.getEmail());
            stmt.setInt(3 , student.getAge());

            int rows = stmt.executeUpdate();

            return rows>0;

        }catch(Exception e){

            e.printStackTrace();
            return false;

        }
    }

    // read all student

    public List<Student> getAllStudents(){

        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students";

        try (Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {

            while(rs.next()) {
                Student s = new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getInt("age")

                );
                students.add(s);
            }

        }catch(Exception e) {
            e.printStackTrace();
        }

        return students;
    }

    //update student

    public boolean updateStudent(String name , String email , int age , int id ){
        String sql = "UPDATE students SET name = ? , email = ? , age = ? WHERE id = ? ";

        try(Connection conn = DBConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)) {


            stmt.setString(1 , name);
            stmt.setString(2, email);
            stmt.setInt(3, age);
            stmt.setInt(4 , id);

            int rows = stmt.executeUpdate();

            return rows > 0 ;

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    //check by Id

    public boolean searchID(int id){

        String sql = "SELECT 1 FROM students WHERE id = ?";

        try(Connection conn = DBConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();

            return rs.next();

        }catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }

    // delete student

    public boolean deleteStudent(int id){

        String sql = "DELETE FROM students  WHERE  id = ? ";

        try(Connection conn = DBConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setInt(1 , id);

            int rows = stmt.executeUpdate();

            return rows > 0;


        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

}