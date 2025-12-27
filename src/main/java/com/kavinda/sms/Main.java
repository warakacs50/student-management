package com.kavinda.sms;

import com.kavinda.sms.service.StudentService;
import com.kavinda.sms.model.Student;
import com.kavinda.sms.ui.StudentCLI;


public class Main {
    public static void main(String[] args){

        StudentService service = new StudentService();
        StudentCLI cli = new StudentCLI(service);
        cli.start();





    }
}