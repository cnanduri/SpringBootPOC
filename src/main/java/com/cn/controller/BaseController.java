package com.cn.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cn.vo.Header;

public abstract class BaseController {

	@ModelAttribute("responseEntity")
	public ResponseEntity<Object> processRequestHeaders(
			@RequestHeader(name = "content-type", required = true) String contentType,
			@RequestHeader(name = "transactionId", required = true) String transactionId) {

		@SuppressWarnings("unused")
		Header header = new Header.HeaderBuilder().setContentType(contentType).setTransactionId(transactionId).build();

		// TODO validate headers

		return null;
	}

}
