package com.student.demo.contoller;

import com.student.demo.entities.Student;
import com.student.demo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    StudentService studentService;

    @GetMapping("/studenti")
    public List<Student> getStudenti() {return studentService.getStudent();}

    @GetMapping("/studente/{id}")
    public Student getStudente(@PathVariable Long id) {return studentService.getStudent(id);}

    @PostMapping("/studenti")
    public void createStudente(@RequestBody Student studente) throws Exception {studentService.createStudent(studente);}

    @DeleteMapping("/studenti/{id}")
    public void deleteStudente(@PathVariable Long id){studentService.removeStudent(id);}

    @PutMapping("/studenti/{id}")
    public void update(@PathVariable("id") long id, @RequestBody Student studente) {studentService.updateStudent(id, studente);}



}
