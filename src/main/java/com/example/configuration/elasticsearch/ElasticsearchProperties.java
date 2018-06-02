package com.example.configuration.elasticsearch;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author baidu
 * @date 2018/5/30 下午10:59
 * @description ${TODO}
 **/

@ConfigurationProperties(prefix = "spring.data.elasticsearch.properties")
public class ElasticsearchProperties {
    private String host;
    private Integer port;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }
}
