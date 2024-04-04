package com.tlpy8.shop.exception;

import com.tlpy8.shop.common.ApiRestResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Object handleException (Exception e) {
        return ApiRestResponse.error(ImoocMallExceptionEnum.SYSTEM_ERROR)
    }
}
