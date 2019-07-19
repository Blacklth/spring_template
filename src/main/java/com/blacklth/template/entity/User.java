package com.blacklth.template.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author : LiaoTianHong
 * @date : 2019/7/18 11:52
 * @description:用户类
 */
@Data
public class User {
    private Integer userId;

    private String userName;

    private String password;

    private String phone;

}
