package com.gabil.deneme1.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabil.deneme1.student.configuration.GlobalProperties;
import com.gabil.deneme1.student.configuration.Server;

@RestController
@RequestMapping("/api")
public class PropertyClassController {
	
	@Autowired
	private GlobalProperties global;
	

	@GetMapping("/source")
	public List<Server> getAllservers(){
		return global.getServers();
	}
}
