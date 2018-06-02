//package com.example.configuration.elasticsearch;
//
//import org.elasticsearch.client.Client;
//import org.elasticsearch.client.transport.TransportClient;
//import org.elasticsearch.common.settings.Settings;
//import org.elasticsearch.common.transport.InetSocketTransportAddress;
//import org.elasticsearch.transport.client.PreBuiltTransportClient;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
//import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
//
//import java.net.InetAddress;
//
///**
// * @author baidu
// * @date 2018/5/30 下午10:29
// * @description ${TODO}
// **/
//
//@Configuration
//@EnableConfigurationProperties(ElasticsearchProperties.class)
//public class ElasticsearchConfiguration {
//
//    @Autowired
//    private ElasticsearchProperties properties;
//
//    @Bean
//    public Client client() throws Exception{
//        TransportClient client = new PreBuiltTransportClient(Settings.EMPTY)
//                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(properties.getHost()), properties.getPort()));
//        return client;
//    }
//
//    @Bean
//    public ElasticsearchOperations elasticsearchTemplate() throws Exception {
//        return new ElasticsearchTemplate(client());
//    }
//
//}
