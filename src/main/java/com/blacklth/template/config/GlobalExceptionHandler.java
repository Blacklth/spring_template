package com.blacklth.template.config;

import com.blacklth.template.entity.pojo.ResultBean;
import com.blacklth.template.error.ErrorCode;
import com.blacklth.template.error.ServiceException;
import com.blacklth.template.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author : LiaoTianHong
 * @date : 2019/7/15 14:54
 * @description:全局异常处理
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());


    /**
     *
     * @author     ：LiaoTianHong
     * @date       ：Created in 2019/7/19 19:24
     * @param       request
     * @param       e
     * @return     : com.blacklth.template.entity.pojo.ResultBean<java.lang.Boolean>
     */
    @ExceptionHandler(ServiceException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultBean<Object> serviceExceptionHandler(HttpServletRequest request, Exception e){
        ServiceException exception = (ServiceException) e;
        e.printStackTrace();
        return ResultUtil.makeFail(exception.getCode(),exception.getMsg());

    }

    @ExceptionHandler(Exception.class)
    public ResultBean<Object> systemeExceptionHandler(HttpServletRequest request,Exception e){

        if(e instanceof org.springframework.web.servlet.NoHandlerFoundException){
            logger.error("未找到资源");
            return ResultUtil.makeFail(HttpStatus.NOT_FOUND.toString(),"未找到相应资源");
        }
        RuntimeException exception = (RuntimeException) e;
        e.printStackTrace();
        return ResultUtil.makeFail(exception.getClass().getSimpleName(),exception.getMessage());
    }



}
