package com.kavinda.sms.model;

public class Student {

    private int id;
    private String name;
    private String email;
    private  int age;

// constructor to build object using class (blue print)

    public Student( String name , String email , int age){

        this.name = name;
        this.email = email;
        this.age = age;
    }

    public Student( int id , String name , String email , int age){

        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
    }

    // getters

    public int getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    // setter


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString(){
        return id + "|" + name + "|" + email + " | " + age;
    }
}