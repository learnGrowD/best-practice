package org.willd.authserver.common.api;

import org.willd.authserver.common.error.ErrorCodeIfs;

public class Api<T> {
    private Result result;
    private T body;

    public static<T> Api<T> OK(T body) {
        Api<T> api = new Api<>();
        api.result = Result.OK();
        api.body = body;
        return api;
    }

    public static Api<Object> Error(ErrorCodeIfs errorCodeIfs) {
        Api<Object> api = new Api<>();
        api.result = Result.Error(errorCodeIfs);
        api.body = new Object();
        return api;
    }

    public static Api<Object> Error(ErrorCodeIfs errorCodeIfs, String description) {
        Api<Object> api = new Api<>();
        api.result = Result.Error(errorCodeIfs, description);
        api.body = new Object();
        return api;
    }
}
