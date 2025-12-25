package com.kavinda.sms;

import com.kavinda.sms.service.StudentService;
import com.kavinda.sms.model.Student;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        StudentService studentService = new StudentService();

       /*

       // add students

        studentService.addStudent(new Student(1, "Kavinda", "kavinda@gmail.com", 21));
        studentService.addStudent(new Student(2, "Mihira", "mihira@gmail.com", 23));
        studentService.addStudent(new Student(3, "Nimali", "nimali@gmail.com", 22));

        // to view

        System.out.println("all students : ");
        System.out.println(studentService.getAllStudents());

        // update student

        studentService.updateStudentName(2, "mihira pamodana");
        System.out.println("\nAfter updating student with ID 2:");
        System.out.println(studentService.getAllStudents());

        // delete student

        studentService.deleteStudent(1);
        System.out.println("\nAfter deleting student with ID 1:");
        System.out.println(studentService.getAllStudents());


        */

        //functioning console

        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running){
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student Name");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit ");
            System.out.println();


            int choice = sc.nextInt();

            switch(choice){
                case 1:

                    System.out.println("student id : ");
                    int id = sc.nextInt();
                    sc.nextLine();


                    System.out.println("student name : ");
                    String name = sc.nextLine();


                    System.out.println("email address : ");
                    String email = sc.nextLine();


                    System.out.println("student age : ");
                    int age = sc.nextInt();
                    sc.nextLine();


                    studentService.addStudent(new Student(id , name , email , age));

                    System.out.println("add student successfully");
                    System.out.println();

                    break;
                case 2:
                    System.out.println("Student Detals");
                    System.out.println();

                    if(studentService.getAllStudents().isEmpty()){
                        System.out.println("No student found");
                    }else {

                        for (Student s : studentService.getAllStudents()) {
                            System.out.println(
                                    "ID : " + s.getId() +
                                            " Name : " + s.getName() +
                                            " Email : " + s.getEmail() +
                                            " Age : " + s.getAge()
                            );
                        }
                        System.out.println();
                    }



                    break;
                case 3:

                    System.out.println("Student id : ");
                    int id2 = sc.nextInt();
                    sc.nextLine();


                    System.out.println("New name : ");
                    String newName = sc.nextLine();


                    studentService.updateStudentName(id2 , newName);

                    System.out.println("succefully updated ! ");

                    break;
                case 4:

                    System.out.println("Student ID : ");
                    int id3 = sc.nextInt();
                    sc.nextLine();


                    studentService.deleteStudent(id3);

                    System.out.println("Delete successfully");

                    break;
                case 5:
                    System.out.println("Good Bye!");

                    running = false;
                    break;

                default:
                    System.out.println("Invalid choine ! \n");


            }




        }


    }
}