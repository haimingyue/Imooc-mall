package com.tlpy8.shop.exception;

import com.tlpy8.shop.common.ApiRestResponse;

public enum ImoocMallExceptionEnum {
    NEED_USER_NAME(10001, "用户名不能为空"),
    NEED_PASSWORD(10002, "密码不能为空"),
    NEED_PASSWORD_TOO_SHORT(10003, "密码不能小于8位"),
    NAME_EXITS(10004, "用户名已存在"),
    INSERT_FAIL(10005, "插入失败请重试"),
    SYSTEM_ERROR(20000, "系统异常");
    /**异常**/
    Integer code;
    String msg;

    ImoocMallExceptionEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
