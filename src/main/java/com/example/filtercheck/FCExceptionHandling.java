package com.example.filtercheck;

import java.util.HashMap;
import java.util.Map;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.*;

@RestControllerAdvice
public class FCExceptionHandling {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleReqValidation(MethodArgumentNotValidException ex) {
		System.out.println("handleReqValidation----------");
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return errors;
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MissingRequestHeaderException.class)
	public ResponseEntity handleReqValidation(MissingRequestHeaderException ex) {
		System.out.println("handleReqValidation----------MissingRequestHeaderException");
		Map<String, String> errors = new HashMap<>();
		errors.put("key-err", "val-err");
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
//		return errors;
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(FCBadReqException.class)
	public Map<String, String> handleReqValidationq(FCBadReqException ex) {
		System.out.println("handleReqValidationq");
		Map<String, String> errors = new HashMap<>();

		errors.put("key1", "val1");
		return errors;
	}
}
