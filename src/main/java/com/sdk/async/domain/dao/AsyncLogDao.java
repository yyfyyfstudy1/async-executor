package com.sdk.async.domain.dao;

import com.sdk.async.domain.entity.AsyncLog;

/**
 * 异步执行日志DAO
 *
 * @author yyf
 */
public interface AsyncLogDao {

    /**
     * 保存
     *
     * @param asyncLog
     */
    void save(AsyncLog asyncLog);

    /**
     * 删除
     * 
     * @param asyncId
     */
    void delete(Long asyncId);

    /**
     * 获取最后一次失败信息
     *
     * @param asyncId
     * @return
     */
    String getErrorData(Long asyncId);
}
