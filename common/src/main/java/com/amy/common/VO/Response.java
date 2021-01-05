package com.amy.common.VO;

import com.amy.common.constant.ResponseConstant;
import com.amy.common.enums.ResponseStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Response {

    private String status;

    private int code;

    private Object data;

    public static Response success(Object data) {
        return Response.builder().status(ResponseConstant.SUCCESS).code(ResponseStatus.SUCCESS.getCode())
                .data(data).build();
    }

    public static Response create(Object data) {
        return Response.builder().status(ResponseConstant.SUCCESS).code(ResponseStatus.CREATE.getCode())
                .data(data).build();
    }

    public static Response update(Object data) {
        return Response.builder().status(ResponseConstant.SUCCESS).code(ResponseStatus.UPDATE.getCode())
                .data(data).build();
    }

    public static Response delete(Object data) {
        return Response.builder().status(ResponseConstant.SUCCESS).code(ResponseStatus.DELETE.getCode())
                .data(data).build();
    }

    public static Response authError(Object data) {
        return Response.builder().status(ResponseConstant.ERROR).code(ResponseStatus.AUTH_ERROR.getCode())
                .data(data).build();
    }

    public static Response serverError(Object data) {
        return Response.builder().status(ResponseConstant.ERROR).code(ResponseStatus.ERROR.getCode())
                .data(data).build();
    }
}
