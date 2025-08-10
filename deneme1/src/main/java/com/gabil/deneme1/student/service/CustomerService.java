package com.gabil.deneme1.student.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.gabil.deneme1.student.dto.AddressDTO;
import com.gabil.deneme1.student.dto.CustomerDTO;
import com.gabil.deneme1.student.entities.Address;
import com.gabil.deneme1.student.entities.Customer;
import com.gabil.deneme1.student.repository.CustomerRepository;
import com.gabil.deneme1.student.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class CustomerService {

	private final CustomerRepository customerrepository;

	public CustomerDTO findById(Long id) {
		Optional<Customer> customerO = customerrepository.findById(id);
		CustomerDTO customerdto = new CustomerDTO();
		AddressDTO addressdto = new AddressDTO();
		Customer customer = customerO.get();
		if(customerO.isPresent()) {
			BeanUtils.copyProperties(customer, customerdto);
			Address address  = customerO.get().getAddress();
			BeanUtils.copyProperties(address, addressdto);
			customerdto.setAddressdto(addressdto);
			return customerdto;
		}
		return null;
	}
	
	
}
