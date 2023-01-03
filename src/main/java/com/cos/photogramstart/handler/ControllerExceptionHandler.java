package com.cos.photogramstart.handler;

import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.cos.photogramstart.handler.ex.CustomValidationException;
import com.cos.photogramstart.util.Script;
import com.cos.photogramstart.web.dto.CMRespDto;

@RestController
@ControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(CustomValidationException.class)
	public String vaildationException(CustomValidationException e) {
		//클라이언트 친화적
		return Script.back(e.getErrorMap().toString()); 
		// ajax 통신, android 통신시 좋음 (개발자 친화적)
		//return new CMRespDto<>(-1, e.getMessage(), e.getErrorMap()); 
	}

}
