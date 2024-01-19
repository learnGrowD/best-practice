package org.willd.authserver.exceptionhandler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.willd.authserver.common.api.Api;
import org.willd.authserver.common.error.ErrorCode;

@Slf4j
@RestControllerAdvice
@Order(value = Integer.MIN_VALUE)
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Api<Object>> globalException(Exception exception) {
        log.error("", exception);
        return ResponseEntity
                .status(500)
                .body(Api.Error(ErrorCode.SERVER_ERROR, exception.getLocalizedMessage()));
    }
}
