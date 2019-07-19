package com.blacklth.template.error;

import com.blacklth.template.entity.pojo.ResultBean;
import com.blacklth.template.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author : LiaoTianHong
 * @date : 2019/7/15 14:54
 * @description:全局异常处理
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());


    /**
     * 处理业务异常
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
        //TODO 包装异常堆栈信息输出到控制台
        //logger.error();
        return ResultUtil.makeFail(exception.getCode(),exception.getMsg());

    }

    /**
     *  处理http异常和系统异常
     * @author     ：TianHong Liao
     * @date       ：Created in 2019/7/19 22:37
     * @param       request
     * @param       e
     * @return     : com.blacklth.template.entity.pojo.ResultBean<java.lang.Object>
     */
    @ExceptionHandler(Exception.class)
    public ResultBean<Object> systemeExceptionHandler(HttpServletRequest request,Exception e){

        if(ClientError.isClientError(e)){
            ClientError clientError = new ClientError(e);
            logger.error(e.getMessage());
            return ResultUtil.makeFail(clientError.getCode(),clientError.getMsg());
        }
        RuntimeException exception = (RuntimeException) e;
        e.printStackTrace();
        //TODO 包装异常堆栈信息输出到控制台
        //logger.error();
        return ResultUtil.makeFail(exception.getClass().getSimpleName(),exception.getMessage());
    }



}
