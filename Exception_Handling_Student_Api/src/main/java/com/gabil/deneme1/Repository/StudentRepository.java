package com.gabil.deneme1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gabil.deneme1.Entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long>{

}
