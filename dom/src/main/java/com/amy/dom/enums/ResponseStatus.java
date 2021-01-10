package com.amy.dom.enums;

import lombok.Getter;

@Getter
public enum ResponseStatus {
    SUCCESS(200, "成功"),
    CREATE(201, "创建成功"),
    UPDATE(202, "修改成功"),
    DELETE(204, "删除成功"),
    AUTH_ERROR(401, "权限错误"),
    ERROR(500, "服务器异常");

    private int code;
    private String name;


    ResponseStatus(int code, String name) {
        this.code = code;
        this.name = name;
    }
}
