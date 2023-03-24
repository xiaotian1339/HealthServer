package me.tcgg.enums;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public enum StatusCodeEnum {

    STATUS_OK(200,"OK"),STATUS_FAIL(500,"FAIL"),STATUS_ERROR(400,"ERROR");

    private Integer code;
    private String msg;

    public Integer getCode(){
        return this.code;
    }
    public String  getMsg(){
        return this.msg;
    }

}
