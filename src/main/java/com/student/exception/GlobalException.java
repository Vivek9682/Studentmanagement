package com.student.exception;

import java.rmi.StubNotFoundException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.student.exception.CustomException.StudentNotExist;

@RestControllerAdvice
public class GlobalException {
	@ExceptionHandler(MethodArgumentNotValidException .class)
	public Map<String,String>handlerException(MethodArgumentNotValidException ex){
		Map<String,String> errorMap = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error ->{
			errorMap.put(error.getField(),error.getDefaultMessage());
			
		});
		return errorMap;
		
		
	}
	@ExceptionHandler(StudentNotExist.class)
	public ResponseEntity<?> studentnotExistCustomException(StudentNotExist ex,WebRequest request){
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}

}
