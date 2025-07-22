package com.gabil.deneme1.student.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.gabil.deneme1.student.entities.Student;

public interface StudentRepository extends JpaRepository<Student,Long>{

}
