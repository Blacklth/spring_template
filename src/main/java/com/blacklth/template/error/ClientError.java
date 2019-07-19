package com.blacklth.template.error;

import org.springframework.http.HttpStatus;

import java.io.UnsupportedEncodingException;
import java.util.ResourceBundle;

/**
 * @author : LiaoTianHong
 * @date : 2019/7/19 20:02
 * @description:用来匹配异常的错误码和错误信息
 */
public class ClientError {

    private String code;
    private String msg;

    /**
     * 通过异常类名构建错误码和错误信息
     * 如果属性文件中不存在后面的msg信息，则填充为exception自带的message
     * @param e
     */
    ClientError(Exception e){
        String key = e.getClass().getSimpleName();
        ResourceBundle rb = ResourceBundle.getBundle("i18n");
        String errorMessage = rb.getString(key);
        String []  str = errorMessage.split(",");
        this.code = str[0];
        this.msg = e.getMessage();
        if(str[1] != null){
            this.msg = str[1];
        }
        System.out.println(msg);

    }

    /**
     *  判断异常类名是否在配置文件中
     * @author     ：TianHong Liao
     * @date       ：Created in 2019/7/19 22:36
     * @param       e
     * @return     : java.lang.Boolean
     */
    static public Boolean isClientError(Exception e){
        String key = e.getClass().getSimpleName();
        ResourceBundle rb = ResourceBundle.getBundle("i18n");
        if(rb.containsKey(key)){
            return true;
        }
        return false;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
