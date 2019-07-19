package com.blacklth.template.controller;

import com.blacklth.template.error.ServiceException;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : LiaoTianHong
 * @date : 2019/7/19 17:10
 * @description:用来测试全局统一异常处理的类
 */
@RestController
public class TestExceptionController {

    /**
     *  用来测试业务异常
     * @author     ：TianHong Liao
     * @date       ：Created in 2019/7/19 22:33
     * @param
     * @return     : java.lang.String
     */
    @ApiOperation(value = "测试业务异常",notes = "在控制台输出测试内容")
    @GetMapping("/testException1")
    public String testException1(){
        if(1 == 1){
            throw new ServiceException(null,"ClientError 000","来自测试异常接口的信息");
        }
        return "测试失败！";
    }

    /**
     *  用来测试系统异常
     * @author     ：TianHong Liao
     * @date       ：Created in 2019/7/19 22:38
     * @param
     * @return     : java.lang.String
     */
    @ApiOperation(value = "测试系统异常",notes = "在控制台输出测试内容")
    @GetMapping("/testException2")
    public String testException2(){
        int a = 1;
        int zero = 0;
        int c = a / zero;
        return "测试失败！";
    }

    /**
     *  用来测试http异常
     * @author     ：TianHong Liao
     * @date       ：Created in 2019/7/19 22:38
     * @param
     * @return     : java.lang.String
     */
    @ApiOperation(value = "测试http异常",notes = "在控制台输出测试内容")
    @GetMapping("/testException3/{id}")
    public String testException3(@PathVariable Integer id){
        return "测试失败！";
    }
}
