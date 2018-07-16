package com.cn.advice;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cn.vo.ApiError;
import com.cn.vo.Error;

@ControllerAdvice
public class ErrorAdvice extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleServletRequestBindingException(ServletRequestBindingException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String developerMessage = ExceptionUtils.getRootCauseMessage(ex);

		List<Error> errors = new ArrayList<>();

		ApiError apiError = new ApiError(status, developerMessage, errors);

		return handleExceptionInternal(ex, apiError, headers, status, request);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		String developerMessage = ExceptionUtils.getRootCauseMessage(ex);

		List<Error> errors = new ArrayList<>();
		for (FieldError error : ex.getBindingResult().getFieldErrors()) {
			errors.add(new Error(error.getField(), error.getDefaultMessage()));
		}

		ApiError apiError = new ApiError(status, developerMessage, errors);

		return handleExceptionInternal(ex, apiError, headers, status, request);
	}

}
