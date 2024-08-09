package com.sdk.async.strategy;

import java.util.List;

import com.sdk.async.strategy.context.StrategyContext;

/**
 * 策略基础接口类 每个策略业务接口类必须继承此类
 * 
 * @author yyf
 */
public interface StrategyService<T extends StrategyContext> {

    /**
     * 策略类型列表
     * 
     * @return
     */
    List<String> listType();

    /**
     * 处理策略
     *
     * @param t
     * @return
     */
    boolean handle(T t);
}
