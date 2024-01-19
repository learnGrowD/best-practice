package org.willd.authserver.common.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;


@Getter
@AllArgsConstructor
public enum ErrorCode implements ErrorCodeIfs {
    OK(200, 200, "Success"),
    BAD_REQUEST(HttpStatus.BAD_REQUEST.value(), 400, "Bad Request"),
    SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value(), 500, "Internal Error"),
    NULL_POINT(HttpStatus.BAD_REQUEST.value(), 512, "Null Point");

    private final Integer httpStatusCode;
    private final Integer errorCode;
    private final String description;
}
