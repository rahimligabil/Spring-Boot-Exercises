 package com.gabil.deneme1.student.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequestDTO {
	private String name;
	private String email;
	private LocalDate dob;
	private Integer age;
	
}
