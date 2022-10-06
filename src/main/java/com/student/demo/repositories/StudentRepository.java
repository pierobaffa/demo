package com.student.demo.repositories;

import com.student.demo.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByNameAndLastName(String firstName, String lastName);
}
