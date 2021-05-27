package com.algaworks.algalog.api.exceptionhandler;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.algaworks.algalog.domain.exception.BussinesException;
import com.algaworks.algalog.domain.exception.EntityNotMeetException;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
	
	private MessageSource messageSource;
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<Problems.Field> fields = new ArrayList<>();
		for(ObjectError error : ex.getBindingResult().getAllErrors()) {
			String nome = ((FieldError) error).getField();
			String mensagem = messageSource.getMessage(error, LocaleContextHolder.getLocale());
			fields.add(new Problems.Field(nome, mensagem));
		}
		Problems problems = new Problems();
		problems.setStatus(status.value());
		problems.setTime(OffsetDateTime.now());
		problems.setTitle("One or more fields are invalid");
		problems.setFields(fields);
		return handleExceptionInternal(ex, problems, headers, status, request);
	}
	@ExceptionHandler(BussinesException.class)
	public ResponseEntity<Object> handleBussines(BussinesException ex, WebRequest request){
		HttpStatus status = HttpStatus.BAD_REQUEST;
		
		Problems problems = new Problems();
		problems.setStatus(status.value());
		problems.setTime(OffsetDateTime.now());
		problems.setTitle(ex.getMessage());
		
		return handleExceptionInternal(ex, problems, new HttpHeaders(), status, request);
	}
	@ExceptionHandler(EntityNotMeetException.class)
	public ResponseEntity<Object> handleEntityNotMeetException(EntityNotMeetException ex, WebRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
		
		Problems problems = new Problems();
		problems.setStatus(status.value());
		problems.setTime(OffsetDateTime.now());
		problems.setTitle(ex.getMessage());
		
		return handleExceptionInternal(ex, problems, new HttpHeaders(), status, request);
	}
}
