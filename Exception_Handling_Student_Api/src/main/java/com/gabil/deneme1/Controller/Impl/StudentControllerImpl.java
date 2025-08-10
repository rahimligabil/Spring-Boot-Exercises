package com.gabil.deneme1.Controller.Impl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabil.deneme1.Controller.IStudentController;
import com.gabil.deneme1.Dto.StudentResponseDto;
import com.gabil.deneme1.Entity.Student;
import com.gabil.deneme1.Service.IStudentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/student/api")
@RequiredArgsConstructor
public class StudentControllerImpl implements IStudentController {
	
	private final IStudentService studentService;
	
	@GetMapping("/find/{id}")
	public StudentResponseDto findById(@PathVariable(name =  "id") Long id) {
		return studentService.findById(id);
	}
}
