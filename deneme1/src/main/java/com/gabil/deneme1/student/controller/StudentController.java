package com.gabil.deneme1.student.controller;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabil.deneme1.student.dto.StudentRequestDTO;
import com.gabil.deneme1.student.dto.StudentResponseDTO;
import com.gabil.deneme1.student.entities.Student;
import com.gabil.deneme1.student.service.StudentService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
@RestController
@RequestMapping("/student/api")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService service;

    @GetMapping
    public List<StudentResponseDTO> getAllStudents() {
        return service.getAllStudents();
    }
    
    @GetMapping("/{id}")
	public StudentResponseDTO getStudentById(@PathVariable Long id) {
		return service.findById(id);
	}
	
    @PostMapping
	public StudentResponseDTO addStudent(@RequestBody @Valid StudentRequestDTO student) {
		return service.createUser(student);
	}
	
    @PutMapping("/{id}")
	public StudentResponseDTO updateStudent(@PathVariable Long id,@RequestBody StudentRequestDTO student) {
		return service.updateUser(id,student);
	}
    
	@DeleteMapping("/{id}")
	public void deleteStudent(@PathVariable Long id) {
	    service.deleteStudent(id);
	}
}
