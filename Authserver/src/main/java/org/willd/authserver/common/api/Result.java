package org.willd.authserver.common.api;

import lombok.*;
import org.willd.authserver.common.error.ErrorCode;
import org.willd.authserver.common.error.ErrorCodeIfs;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Result {
    private Integer resultCode;
    private String resultMessage;

    public static Result OK() {
        return Result.builder()
                .resultCode(ErrorCode.OK.getErrorCode())
                .resultMessage(ErrorCode.OK.getDescription())
                .build();
    }

    public static Result Error(ErrorCodeIfs errorCodeIfs) {
        return Result.builder()
                .resultCode(errorCodeIfs.getErrorCode())
                .resultMessage(errorCodeIfs.getDescription())
                .build();
    }

    public static Result Error(ErrorCodeIfs errorCodeIfs, String errorDescription) {
        return Result.builder()
                .resultCode(errorCodeIfs.getErrorCode())
                .resultMessage(errorDescription)
                .build();
    }
}
