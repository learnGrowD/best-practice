package org.willd.authserver.exceptionhandler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.willd.authserver.common.api.Api;
import org.willd.authserver.common.exception.ApiException;

@Slf4j
@RestControllerAdvice
@Order(value = Integer.MIN_VALUE)
public class ApiExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<Object> apiExceptionHandler(ApiException apiException) {
        log.error("", apiException);
        return ResponseEntity
                .status(apiException.getErrorCodeIfs().getHttpStatusCode())
                .body(Api.Error(apiException.getErrorCodeIfs()));
    }
}
