package com.sdk.async.biz;

import com.sdk.async.domain.entity.AsyncReq;
import com.sdk.async.dto.AsyncExecDto;

/**
 * 异步执行接口
 *
 * @author yyf
 */
public interface AsyncBizService {

    /**
     * 执行方法
     *
     * @param asyncReq
     * @return
     */
    boolean invoke(AsyncReq asyncReq);

    /**
     * 执行方法
     *
     * @param asyncExecDto
     * @return
     */
    boolean invoke(AsyncExecDto asyncExecDto);

}
