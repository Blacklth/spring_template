package com.blacklth.template.error;

import org.springframework.http.HttpStatus;

/**
 * @author : LiaoTianHong
 * @date : 2019/7/19 20:12
 * @description:
 */
public enum ClientError  {

    MissingServletRequestParameter(HttpStatus.BAD_REQUEST,"缺少请求参数"),
    MessageNotReadable(HttpStatus.BAD_REQUEST,"参数解析失败"),
    MethodArgumentNotValid(HttpStatus.BAD_REQUEST,"参数验证失败"),
    NotFound(HttpStatus.NOT_FOUND,"未找到资源"),
    MethodNotSupported(HttpStatus.METHOD_NOT_ALLOWED,"不支持当前请求方法"),
    MediaTypeNotSupported(HttpStatus.UNSUPPORTED_MEDIA_TYPE,"不支持当前媒体类型");

    private String msg;
    private String code;

    private ClientError(HttpStatus httpStatus,String msg){
        this.code = httpStatus.toString();
        this.msg = msg;
    }
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
