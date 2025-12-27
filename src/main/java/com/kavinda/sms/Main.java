package com.kavinda.sms;

import com.kavinda.sms.service.StudentService;
import com.kavinda.sms.model.Student;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){


        //functioning console
        StudentService service = new StudentService();
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running){
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student Name");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit ");
            System.out.println("choose : ");
            System.out.println();


            int choice = sc.nextInt();
            sc.nextLine();

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


                    if(service.addStudent(new Student(id , name , email , age))){

                    System.out.println("add student successfully");
                }else{
                        System.out.println("adding failed");
                }


                    System.out.println();

                    break;
                case 2:
                    System.out.println("Student Detals");
                    System.out.println();

                    if(service.getAllStudents().isEmpty()){
                        System.out.println("No student found");
                    }else {

                        for (Student s : service.getAllStudents()) {
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

                    System.out.println("New email : ");
                    String newEmail = sc.nextLine();

                    System.out.println("Add age : ");
                    int newAge = sc.nextInt();
                    sc.nextLine();

                    if(service.searchID(id2)){
                        service.updateStudent(id2 , newName , newEmail , newAge);
                        System.out.println("succefully updated ! ");
                    }else{
                        System.out.println("id not found ");
                    }






                    break;
                case 4:

                    System.out.println("Student ID : ");
                    int id3 = sc.nextInt();
                    sc.nextLine();


                    if(service.searchID(id3)){
                        service.deleteStudent(id3);
                        System.out.println("Delete successfully");
                    }else{
                        System.out.println("delete unsuccessfull");
                    }



                    break;
                case 5:
                    System.out.println("Good Bye!");

                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice ! \n");


            }

            




        }




    }
}