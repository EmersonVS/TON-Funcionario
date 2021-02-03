package com.stone.challenge_1.config.handler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.stone.challenge_1.config.handler.DTO.FormErrorDTO;

@RestControllerAdvice
public class MethodArgumentNotValidHandler {

	@Autowired
	private MessageSource messageSource;

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<FormErrorDTO> handleError(MethodArgumentNotValidException ex) {
		List<FormErrorDTO> ers = new ArrayList<FormErrorDTO>();
		List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
		fieldErrors.forEach(er -> {
			String message = messageSource.getMessage(er, LocaleContextHolder.getLocale());
			FormErrorDTO erDTO = new FormErrorDTO(er.getField(), message);
			ers.add(erDTO);
		});
		return ers;
	}

}
