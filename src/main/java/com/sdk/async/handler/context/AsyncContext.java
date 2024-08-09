package com.sdk.async.handler.context;

import com.sdk.async.dto.AsyncExecDto;
import org.aspectj.lang.ProceedingJoinPoint;

import com.sdk.async.annotation.AsyncExec;
import com.sdk.async.strategy.context.StrategyContext;

import lombok.Data;

/**
 * AsyncContext
 *
 * @author yyf
 */
@Data
public class AsyncContext extends StrategyContext {

    private static final long serialVersionUID = 1L;

    /**
     * 切面方法
     */
    private ProceedingJoinPoint joinPoint;

    /**
     * 异步执行策略
     */
    private AsyncExec asyncExec;

    /**
     * 异步执行数据
     */
    private AsyncExecDto asyncExecDto;

}
