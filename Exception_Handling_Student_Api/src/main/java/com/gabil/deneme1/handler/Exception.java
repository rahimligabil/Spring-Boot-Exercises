package com.gabil.deneme1.handler;

import java.util.Date;

import javax.xml.crypto.Data;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Exception<E>{

	private String hostName;
	
	private String path;
	
	private Date createTime;
	
	private E message;
	
}
