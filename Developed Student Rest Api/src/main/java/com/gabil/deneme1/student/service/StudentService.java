package com.gabil.deneme1.student.service;
import com.gabil.deneme1.student.dto.StudentRequestDTO;
import com.gabil.deneme1.student.dto.StudentResponseDTO;
import com.gabil.deneme1.student.entities.Student;
import com.gabil.deneme1.student.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public List<StudentResponseDTO> getAllStudents() {
        List<Student> studentList = studentRepository.findAll();
        List<StudentResponseDTO> result = new ArrayList<StudentResponseDTO>();
        for(Student s : studentList) {
        	StudentResponseDTO response = new StudentResponseDTO();
        	BeanUtils.copyProperties(s, response);
        	result.add(response);
        	}
        
        return result; 
    }

	public StudentResponseDTO findById(long id) {
		Student student = new Student();
		student = studentRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Student not found"));
		
		StudentResponseDTO response = new StudentResponseDTO();
		BeanUtils.copyProperties(student, response);
		return response;
		
	}

	public StudentResponseDTO createUser(StudentRequestDTO student1) {
		  Student student =  new Student();
		  StudentResponseDTO response = new StudentResponseDTO();
		  BeanUtils.copyProperties(student1, student);
		  
		  Student studentdb = studentRepository.save(student);
		  BeanUtils.copyProperties(studentdb,response);
		  return response;
		
	}

	public void deleteStudent(Long id) {
		studentRepository.deleteById(id);
	}

	public StudentResponseDTO updateUser(Long id, StudentRequestDTO   updatedStudent) {
			Optional<Student> existing = studentRepository.findById(id);
			StudentResponseDTO response = new StudentResponseDTO();
			
		  	if(existing.isPresent()) {
		  	Student student = existing.get();
	        student.setName(updatedStudent.getName());
	        student.setEmail(updatedStudent.getEmail());
	        student.setDob(updatedStudent.getDob());
	        student.setAge(updatedStudent.getAge());
	        
	        Student dbstudent = studentRepository.save(student);
	    	BeanUtils.copyProperties(dbstudent, response);
	    	return response;
		  	}
		  	return null;
		  
		  	
		  	

	        
	}
}
