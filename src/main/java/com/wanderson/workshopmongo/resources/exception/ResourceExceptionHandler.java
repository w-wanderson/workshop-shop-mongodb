package com.wanderson.workshopmongo.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.wanderson.workshopmongo.services.exception.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandarErro> objNotFound(ObjectNotFoundException e,HttpServletRequest request){
	
	HttpStatus	status = HttpStatus.NOT_FOUND;
	StandarErro err = new StandarErro(System.currentTimeMillis(),status.value(), "Não Encontrado",e.getMessage(),request.getRequestURI());
	return ResponseEntity.status(status).body(err);	
	}
}
