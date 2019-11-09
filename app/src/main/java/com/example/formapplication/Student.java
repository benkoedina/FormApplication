package com.example.formapplication;

import android.graphics.Bitmap;

import java.util.Date;

public class Student {

    public String name;
    public String location;
   // public Bitmap image;
    public String birthDate;
    public String gender;
    public String hobbies;
    public String department;
    public String yearOfStudy;
    public String expectations;



    public Student(String name, String location, String birthDate, String gender, String hobbies, String department, String yearOfStudy, String expectations) {
        this.name = name;
        this.location = location;
        this.birthDate = birthDate;
        this.gender = gender;
        this.hobbies = hobbies;
        this.department = department;
        this.yearOfStudy = yearOfStudy;
        this.expectations = expectations;
    }
    public Student (){}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(String yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public String getExpectations() {
        return expectations;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", birthDate=" + birthDate +
                ", gender='" + gender + '\'' +
                ", hobbies=" + hobbies +
                ", department='" + department + '\'' +
                ", yearOfStudy=" + yearOfStudy +
                ", expectations='" + expectations + '\'' +
                '}';
    }

    public void setExpectations(String expectations) {
        this.expectations = expectations;
    }
}
