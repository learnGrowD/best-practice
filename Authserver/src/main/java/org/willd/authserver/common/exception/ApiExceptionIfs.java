package org.willd.authserver.common.exception;

import org.willd.authserver.common.error.ErrorCodeIfs;

public interface ApiExceptionIfs {
    ErrorCodeIfs getErrorCodeIfs();

    String getErrorDescription();

}
