package com.sdk.async.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * PageInfoDto
 *
 * @author yyf
 */
@Getter
@Setter
@ToString
public class PageInfoDto<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 页码
     */
    private int pageNum;

    /**
     * 每页展示数量
     */
    private int pageSize;

    /**
     * 总记录数
     */
    private long total;

    /**
     * 数据
     */
    private List<T> list;

}
