package com.ecom.groceryportal.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ecom.groceryportal.exception.InvalidItemException;
import com.ecom.groceryportal.exception.ItemAlreadyExistsException;
import com.ecom.groceryportal.exception.ItemNotFoundException;

@ControllerAdvice
public class ItemExceptionHandler {
	
	@ExceptionHandler(value=ItemNotFoundException.class)
	public ResponseEntity<Object> notFoundException(ItemNotFoundException exception){
		return new ResponseEntity<Object>("Item Not Found !",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=InvalidItemException.class)
		public ResponseEntity<Object> invalidException(InvalidItemException exception){
		return new ResponseEntity<Object>("Invalid Item!",HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value=ItemAlreadyExistsException.class)
	public ResponseEntity<Object> invalidException(ItemAlreadyExistsException exception){
		return new ResponseEntity<Object>("Item Already Exists!",HttpStatus.BAD_REQUEST);
	}
}
