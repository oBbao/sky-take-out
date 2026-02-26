package com.sky.handler;

import com.sky.exception.AccountLockedException;
import com.sky.exception.BaseException;
import com.sky.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器，处理项目中抛出的业务异常
 */
//给所有 @RestController 控制器添加一个 “全局异常处理的增强功能”。
    //标注这个注解后，这个类就成了「全局异常处理器」
@RestControllerAdvice
@Slf4j
//GlobalExceptionHandler 类的作用是：捕获项目中抛出的所有指定异常（
// 比如你自定义的 BaseException、AccountLockedException），并统一返回格式（Result 对象）
// 给前端，避免异常直接抛给用户，也不用在每个接口里写重复的 try-catch。
//逐个解析注解
public class GlobalExceptionHandler {

    /**
     * 捕获业务异常
     * @param ex
     * @return
     */
    @ExceptionHandler
    public Result<?> exceptionHandler(BaseException ex){
        log.error("异常信息：{}", ex.getMessage());
        return Result.error(ex.getMessage());
    }


}
