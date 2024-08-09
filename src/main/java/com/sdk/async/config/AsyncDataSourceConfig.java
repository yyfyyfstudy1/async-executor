package com.sdk.async.config;

import java.util.LinkedHashMap;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * AsyncDataSourceConfig
 *
 * @author yyf
 */
@ConfigurationProperties(prefix = "async.datasource")
public class AsyncDataSourceConfig extends LinkedHashMap<String, Object> {

}
