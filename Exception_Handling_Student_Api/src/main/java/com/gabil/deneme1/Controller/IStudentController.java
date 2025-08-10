package com.gabil.deneme1.Controller;

import com.gabil.deneme1.Dto.StudentResponseDto;

public interface IStudentController {

	public StudentResponseDto findById(Long id);
}
