package com.student.demo.services;

import com.student.demo.entities.Student;
import com.student.demo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;


    public List<Student> getStudent(){return studentRepository.findAll();}

    public Student getStudent(Long id) {return studentRepository.findById(id).get();}

    public void createStudent(Student studente) {studentRepository.save(studente);}

    public void removeStudent(Long id) {studentRepository.deleteById(id);}


    public void updateStudent(Long id, Student studente) {
        Student tempStudente = getStudent(id);
        newStudent(studente, tempStudente);
        studentRepository.save(tempStudente);
    }


    private Student newStudent(Student studenteDaController, Student studenteDaDb){
        if(studenteDaController.getBirthDate() != null) {
            studenteDaDb.setBirthDate(studenteDaController.getBirthDate());
        }
        if(studenteDaController.getFirstName() != null) {
            studenteDaDb.setFirstName(studenteDaController.getFirstName());
        }
        if(studenteDaController.getLastName() != null) {
            studenteDaDb.setLastName(studenteDaDb.getLastName());
        }
        return studenteDaDb;
    }


}
