package com.gabil.security1.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabil.security1.User.User;

public interface UserRepository extends JpaRepository<User,Long> {
	
	Optional<User> findByEmail(String email);
	
}
