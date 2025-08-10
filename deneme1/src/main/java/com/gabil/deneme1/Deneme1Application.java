package com.gabil.deneme1;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.gabil.deneme1.student.configuration.GlobalProperties;

@SpringBootApplication
@EnableConfigurationProperties(value = GlobalProperties.class)
public class Deneme1Application {

	public static void main(String[] args) {
		SpringApplication.run(Deneme1Application.class, args);
	}

}
