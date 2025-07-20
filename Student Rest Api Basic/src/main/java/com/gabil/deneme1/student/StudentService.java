package com.gabil.deneme1.student;

import java.util.List;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

	public Student findById(long id) {
		 return studentRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Student not found"));
		
	}

	public void createUser(Student student) {
		  studentRepository.save(student);
		
	}

	public void deleteStudent(Long id) {
		studentRepository.deleteById(id);
	}

	public void updateUser(Long id, Student updatedStudent) {
		  Student existing = studentRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Student not found"));

	        existing.setName(updatedStudent.getName());
	        existing.setEmail(updatedStudent.getEmail());
	        existing.setDob(updatedStudent.getDob());
	        existing.setAge(updatedStudent.getAge());

	        studentRepository.save(existing);
	}
}
