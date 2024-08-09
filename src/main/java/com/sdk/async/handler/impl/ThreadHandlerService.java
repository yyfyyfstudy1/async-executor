package com.sdk.async.handler.impl;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sdk.async.biz.AsyncBizService;
import com.sdk.async.enums.AsyncTypeEnum;
import com.sdk.async.handler.context.AsyncContext;

import lombok.extern.slf4j.Slf4j;

/**
 * 异步线程处理
 *
 * @author yyf
 */
@Slf4j
@Component
public class ThreadHandlerService extends AbstractHandlerService {

    @Autowired(required = false)
    private Executor asyncExecute;

    @Autowired
    private AsyncBizService asyncBizService;

    @Override
    public List<String> listType() {
        return Collections.singletonList(AsyncTypeEnum.THREAD.name());
    }

    @Override
    public boolean execute(AsyncContext context) {
        asyncExecute.execute(() -> asyncBizService.invoke(context.getAsyncExecDto()));
        return true;
    }
}
