package com.gabil.deneme1.student;
import lombok.RequiredArgsConstructor;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/student/api")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService service;

    @GetMapping
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }
    
    @GetMapping("/{id}")
	public Student getStudentById(@PathVariable Long id) {
		return service.findById(id);
	}
	
    @PostMapping
	public void addStudent(@RequestBody Student student) {
		service.createUser(student);
	}
	
    @PutMapping
	public void updateStudent(Long id, Student student) {
		service.updateUser(id,student);
	}
	
	@DeleteMapping("/{id}")
	public void deleteStudent(@PathVariable Long id) {
	    service.deleteStudent(id);
	}
}
