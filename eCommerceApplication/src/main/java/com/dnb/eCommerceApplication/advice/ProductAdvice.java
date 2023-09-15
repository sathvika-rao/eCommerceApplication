package com.dnb.eCommerceApplication.advice;

import java.net.http.HttpHeaders;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

//public class ProductAdvice {
//	
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException e,
//			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
//		Map<Object, Object> responseBody = new LinkedHashMap<>();
//		responseBody.put("timestamp", LocalDateTime.now());
//		responseBody.put("status", status.value());
//		
//		List<Object> errors = e.getBindingResult().getFieldErrors()
//				.stream()
//				.map(x -> x.getDefaultMessage())
//				.collect(Collectors.toList());
//		
//		List<String> fields = e.getBindingResult().getFieldErrors()
//				.stream()
//				.map(x -> x.getField())
//				.collect(Collectors.toList());
//		
//		Map<String, Object> abc = new LinkedHashMap<>();
//		for(int i=0;i<errors.size();i++) {
//			abc.put(fields.get(i),errors.get(i));
//		}
//		
//		
//		responseBody.put("errors", abc);
//		
//		
//		
//		return new ResponseEntity<>(responseBody, HttpStatus.BAD_REQUEST);
//	}
//	
//}
