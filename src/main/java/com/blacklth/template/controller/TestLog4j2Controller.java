package com.blacklth.template.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestLog4j2Controller {

    public final Logger logger = LoggerFactory.getLogger(getClass());

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
