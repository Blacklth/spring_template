package com.blacklth.template.entity.pojo;

import java.io.Serializable;

/**
 * @author : LiaoTianHong
 * @date : 2019/7/15 14:54
 * @description:
 */
public class ResultBean<T> implements Serializable {
    private static final long serialVersionUID = -6248238306422472597L;
    /**
     * 表示接口调用成功
     */
    public static final int SUCCESS = 0;
    /**
     * 表示接口调用失败
     */
    public static final int FAIL = 1;

    public static final String SUCC_MSG = "成功";
    public static final String FAIL_MSG = "失败";

    private int code = 200;

    private int state = SUCCESS;

    private String msg = SUCC_MSG;

    private T data;

    public ResultBean() {
        super();
    }

    public ResultBean(T data) {
        super();
        this.data = data;
    }

    public ResultBean(int code, Throwable e) {
        super();
        this.code = code;
        this.state = FAIL;
        this.msg = e.getMessage();
    }

    public ResultBean(int code, String msg) {
        super();
        this.code = code;
        this.state = FAIL;
        this.msg = msg;
    }

    public ResultBean(int code, int state, String msg,T data) {
        super();
        this.code = code;
        this.state = FAIL;
        this.msg = msg;
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "{" +
                "code=" + code +
                ", state=" + state +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
