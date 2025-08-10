package com.gabil.deneme1.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabil.deneme1.student.entities.Address;

public interface AddressRepository extends JpaRepository<Address,Long> {

}
