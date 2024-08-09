package com.sdk.async.handler.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sdk.async.enums.AsyncTypeEnum;
import com.sdk.async.handler.context.AsyncContext;

/**
 * 仅异步消息处理
 *
 * @author yyf
 */
@Component
public class AsyncHandlerService extends AbstractHandlerService {

    @Override
    public List<String> listType() {
        return Collections.singletonList(AsyncTypeEnum.ASYNC.name());
    }

    @Override
    public boolean execute(AsyncContext context) {
        // 放入消息队列
        return asyncProducer.send(context.getAsyncExecDto());
    }
}
