package com.sdk.async.dto;

import java.io.Serializable;
import java.lang.reflect.Method;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 代理方法
 *
 * @author yyf
 */
@Getter
@Setter
@ToString
public class ProxyMethodDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 类实例
     */
    private Object bean;

    /**
     * 方法
     */
    private Method method;

}