package com.student.demo.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "birthDate")
    private String birthDate;
    @Column(name = "grades")
    private String grades;

    public Student (){

    }

    public Student(String firstName, String lastName, String birthDate, String grades) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.grades = grades;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getGrades() {
        return grades;
    }

    public void setGrades(String grades) {
        this.grades = grades;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", grades='" + grades + '\'' +
                '}';
    }


    /** return student age **/
    public int age (String birthDate) {

        int age = 0;

        LocalDate date = LocalDate.parse(birthDate);
        LocalDate localDate = LocalDate.now();
        if(date != null && localDate != null){
            age = Period.between(date, localDate).getYears();
        }

        return age;
    }


    /** return student avgGrade **/
    public double avgGrade(ArrayList<Double> voti){

        double media = 0;

        for (Double voto : voti) {
            media += voto;
        }

        media = media/voti.size();
        return media;
    }

}
