package com.gabil.deneme1.Service.Impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.gabil.deneme1.Dto.StudentResponseDto;
import com.gabil.deneme1.Entity.Student;
import com.gabil.deneme1.Exception.BaseException;
import com.gabil.deneme1.Exception.ErrorMessage;
import com.gabil.deneme1.Exception.MessageType;
import com.gabil.deneme1.Repository.StudentRepository;
import com.gabil.deneme1.Service.IStudentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements IStudentService{

	private final StudentRepository studentRepository;

	@Override
	public StudentResponseDto findById(Long id) {
		Optional<Student> optional = studentRepository.findById(id);
		
		if(optional.isPresent()) {
			Student student = optional.get();
			StudentResponseDto studentResponse = new StudentResponseDto();
			BeanUtils.copyProperties(student, studentResponse);
			return studentResponse;
		}
		
		throw new BaseException(new ErrorMessage(MessageType.STUDENT_NOT_FOUND,id.toString()));
	}
	
}
