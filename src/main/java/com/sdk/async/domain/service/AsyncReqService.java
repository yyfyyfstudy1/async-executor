package com.sdk.async.domain.service;

import java.util.List;

import com.sdk.async.domain.entity.AsyncReq;
import com.sdk.async.dto.PageInfoDto;

/**
 * 异步执行接口
 *
 * @author yyf
 */
public interface AsyncReqService {

    /**
     * 保存
     * 
     * @param asyncReq
     */
    void save(AsyncReq asyncReq);

    /**
     * 更新状态
     * 
     * @param id
     * @param execStatus
     */
    void updateStatus(Long id, Integer execStatus);

    /**
     * 删除
     *
     * @param id
     */
    void delete(Long id);

    /**
     * 根据ID查询
     * 
     * @param id
     * @return
     */
    AsyncReq getById(Long id);

    /**
     * 自动重试
     *
     * @return
     */
    List<AsyncReq> listRetry();

    /**
     * 自动补偿
     *
     * @return
     */
    List<AsyncReq> listComp();

    /**
     * 人工执行
     *
     * @param pageInfo
     */
    void listAsyncPage(PageInfoDto<AsyncReq> pageInfo);
}
