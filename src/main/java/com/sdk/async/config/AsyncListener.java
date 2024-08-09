package com.sdk.async.config;

import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;
import org.springframework.util.Assert;

import com.sdk.async.handler.HandlerService;
import com.sdk.async.handler.context.AsyncContext;
import com.sdk.async.strategy.StrategyFactory;

import lombok.extern.slf4j.Slf4j;

/**
 * 事件监听
 *
 * @author yyf
 */
@Slf4j
@Component
public class AsyncListener {

    /**
     * 处理事件 <br>
     * fallbackExecution=true 没有事务正在运行，依然处理事件 <br>
     * TransactionPhase.AFTER_COMPLETION 事务提交，事务回滚都处理事件
     * 
     * @param context
     */
    @TransactionalEventListener(fallbackExecution = true, phase = TransactionPhase.AFTER_COMPLETION)
    public void asyncHandler(AsyncContext context) {
        HandlerService handlerService = StrategyFactory.doStrategy(context.getAsyncExec().type().name(), HandlerService.class);
        Assert.notNull(handlerService, "异步执行策略不存在");
        handlerService.handle(context);
    }

}
