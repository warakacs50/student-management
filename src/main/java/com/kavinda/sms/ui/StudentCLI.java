package  com.kavinda.sms.ui;

import com.kavinda.sms.model.Student;
import com.kavinda.sms.service.StudentService;

import java.util.List;
import java.util.Scanner;

public class StudentCLI{

    private final StudentService service; //service is an object of StudentService
    private final Scanner sc = new Scanner(System.in);

    public StudentCLI(StudentService service){
        this.service = service;
    }

    public void start(){

        boolean running = true;

        while (running){

            printMenu();
            int choice = readInt("choose : ");


            switch (choice){
                case 1 -> addStudent();
                case 2 -> viewStudent();
                case 3 -> updateStudent();
                case 4 -> deleteStudent();
                case 5 -> {System.out.println("Good Bye ");
                            running = false;
                }
                default -> System.out.println("Invalid choice\n");

            }


        }
    }


    private void addStudent(){

        System.out.println("Name : ");
        String name = sc.nextLine();

        System.out.println("Email : ");
        String email = sc.nextLine();

        int age = readInt("Age : ");

        boolean success = service.addStudent(new Student(name , email , age));

        System.out.println(success ? "Student added successfully" : "Failed to add detail");

    }

    private void viewStudent(){
        List<Student> students = service.getAllStudents();

        if(students.isEmpty()){
            System.out.println("no student found ");
            return; // what this does is its not returning anything
                    // its suddenly stop the method running
        }

        for (Student s : students){
            System.out.println(s);
        }
    }

    private void updateStudent(){

        int id = readInt("Student ID : ");

        if(!service.searchID(id)){
            System.out.println("ID not found ");
            return;
        }

        System.out.print("New Name: ");
        String name = sc.nextLine();

        System.out.print("New Email: ");
        String email = sc.nextLine();

        int age = readInt("New Age: ");

        boolean success = service.updateStudent(name , email , age , id);

        System.out.println(success ? "student updated" : "update failed");
    }

    private void deleteStudent(){

        int id = readInt("Student ID : ");

        if(!service.searchID(id)){
            System.out.println("ID not found ");
            return;
        }

        boolean success = service.deleteStudent(id);
        System.out.println(success ? "Delete successfully " : "Delete failed ");
    }

    private int readInt(String message){
        System.out.print(message);

        while(!sc.hasNextInt()){
            System.out.println("Enter a valid number : ");
            sc.next();
        }

        int value = sc.nextInt();
        sc.nextLine();
        return value;
    }

    private void printMenu() {
        System.out.println("\n--- Student Management System ---");
        System.out.println("1. Add Student");
        System.out.println("2. View Students");
        System.out.println("3. Update Student");
        System.out.println("4. Delete Student");
        System.out.println("5. Exit");
    }











}

