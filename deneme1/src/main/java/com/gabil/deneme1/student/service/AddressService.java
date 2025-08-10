package com.gabil.deneme1.student.service;

import org.springframework.stereotype.Service;

import com.gabil.deneme1.student.repository.AddressRepository;
import com.gabil.deneme1.student.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class AddressService {
	
	private final AddressRepository addressrepository;
	
	
	
}
