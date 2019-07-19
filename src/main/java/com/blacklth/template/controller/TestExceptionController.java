package com.blacklth.template.controller;

import com.blacklth.template.error.ServiceException;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : LiaoTianHong
 * @date : 2019/7/19 17:10
 * @description:
 */
@RestController
public class TestExceptionController {

    @ApiOperation(value = "测试全局统一异常处理的功能",notes = "在控制台输出测试内容")
    @GetMapping("/testException")
    public String testException(){
        if(1 == 1){
            throw new ServiceException(null,"ErrorCode","测试信息");
        }
        return "测试成功！";
    }

}
