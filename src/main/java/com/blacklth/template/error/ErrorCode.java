package com.blacklth.template.error;

import org.springframework.http.HttpStatus;

import java.util.ResourceBundle;

/**
 * @author : LiaoTianHong
 * @date : 2019/7/19 20:02
 * @description:
 */
public class ErrorCode {

    private String code;
    private String msg;

    ErrorCode(Object e){
        String key = e.getClass().getSimpleName();
        ResourceBundle rb = ResourceBundle.getBundle("i18n");
        this.code = key;
        this.msg = rb.containsKey(key) ? rb.getString(key) : key;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
