package org.willd.authserver.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.willd.authserver.common.api.Api;
import org.willd.authserver.common.error.ErrorCodeIfs;

@Getter
public class ApiException extends RuntimeException implements ApiExceptionIfs {
    private final ErrorCodeIfs errorCodeIfs;
    private final String errorDescription;

    public ApiException(ErrorCodeIfs errorCodeIfs) {
        super(errorCodeIfs.getDescription());
        this.errorCodeIfs = errorCodeIfs;
        this.errorDescription = errorCodeIfs.getDescription();
    }

    public ApiException(ErrorCodeIfs errorCodeIfs, String description) {
        super(description);
        this.errorCodeIfs = errorCodeIfs;
        this.errorDescription = description;
    }

    public ApiException(ErrorCodeIfs errorCodeIfs, Throwable tx) {
        super(tx);
        this.errorCodeIfs = errorCodeIfs;
        this.errorDescription = tx.getLocalizedMessage();
    }
}
