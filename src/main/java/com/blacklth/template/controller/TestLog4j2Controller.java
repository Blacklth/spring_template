package com.blacklth.template.controller;

import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : LiaoTianHong
 * @date : 2019/7/15 14:54
 * @description:
 */

@RestController
public class TestLog4j2Controller {

    public final Logger logger = LoggerFactory.getLogger(getClass());

    @ApiOperation(value = "测试Log4j2的功能",notes = "在控制台输出测试内容")
    @GetMapping("/testLog4j2")
    public String testLog4j2(){
        logger.trace("trace");
        logger.debug("debug");
        logger.warn("warn");
        logger.info("info");
        logger.error("error");

        return "测试成功！";
    }
}
