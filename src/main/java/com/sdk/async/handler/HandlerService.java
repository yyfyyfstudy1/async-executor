package com.sdk.async.handler;

import com.sdk.async.handler.context.AsyncContext;
import com.sdk.async.strategy.StrategyService;

/**
 * 异步执行接口
 *
 * @author yyf
 */
public interface HandlerService extends StrategyService<AsyncContext> {

    /**
     * 执行异步策略
     * 
     * @param context
     * @return
     */
    boolean execute(AsyncContext context);
}
