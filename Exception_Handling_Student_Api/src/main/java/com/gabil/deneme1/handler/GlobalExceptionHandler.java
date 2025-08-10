package com.gabil.deneme1.handler;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import javax.xml.crypto.Data;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.gabil.deneme1.Exception.BaseException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = {BaseException.class})
	public ResponseEntity<ApiError> handleBaseException(BaseException e,WebRequest request){
		return ResponseEntity.badRequest().body(createApiError(e.getMessage(),request));
		
	}
	
	
	public <E> ApiError<E> createApiError(E message, WebRequest request){
		ApiError apiError =  new ApiError<>();
		apiError.setStatus(HttpStatus.BAD_REQUEST.value());
		
		Exception exception = new Exception<>();
		exception.setCreateTime(new Date());
		exception.setHostName(request.getDescription(false));
		exception.setPath(request.getDescription(false));
		exception.setMessage(message);
		
		apiError.setException(exception);
		
		return apiError;
	}


	private String gethostname() throws IOException {
		return InetAddress.getLocalHost().getHostName();
	}
	
}
