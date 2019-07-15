package com.blacklth.template.config;

import com.blacklth.template.entity.pojo.ResultBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author : LiaoTianHong
 * @date : 2019/7/15 14:54
 * @description:全局异常处理
 */
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     *  捕获  RuntimeException 异常
     * @author     ：LiaoTianHong
     * @date       ：Created in 2019/7/15 15:00
     * @param       request
     * @param       e
     * @param       response
     * @return     : com.blacklth.template.entity.pojo.ResultBean<java.lang.Boolean>
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultBean<Boolean> runtimeExceptionHandler(HttpServletRequest request, final Exception e, HttpServletResponse response){
        RuntimeException exception = (RuntimeException)e;
        return new ResultBean(HttpStatus.INTERNAL_SERVER_ERROR.value(),exception.getMessage(),false);
    }
    
    /**
     *  通用的接口映射异常处理方
     * @author     ：LiaoTianHong
     * @date       ：Created in 2019/7/15 15:07
     * @param       ex
     * @param       body
     * @param       headers
     * @param       status
     * @param       request
     * @return     : org.springframework.http.ResponseEntity<java.lang.Object>
     */
    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        if (ex instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException exception = (MethodArgumentNotValidException) ex;
            return new ResponseEntity<>(new ResultBean<>(status.value(), exception.getBindingResult().getAllErrors().get(0).getDefaultMessage(),false), status);
        }
        if (ex instanceof MethodArgumentTypeMismatchException) {
            MethodArgumentTypeMismatchException exception = (MethodArgumentTypeMismatchException) ex;
            logger.error("参数转换失败，方法：" + exception.getParameter().getMethod().getName() + "，参数：" + exception.getName()
                    + ",信息：" + exception.getLocalizedMessage());
            return new ResponseEntity<>(new ResultBean<>(status.value(), "参数转换失败",false), status);
        }
        return new ResponseEntity<>(new ResultBean<>(status.value(), "参数转换失败",false), status);
    }
}
