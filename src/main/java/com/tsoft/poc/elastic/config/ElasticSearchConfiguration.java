package com.tsoft.poc.elastic.config;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import org.springframework.beans.factory.annotation.Value;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticSearchConfiguration {

    @Value("${elastic-search.host}")
    private String elastic_host;
    @Value("${elastic-search.port}")
    private int elastic_port;
    @Bean
    public RestClient restClient() {
        return RestClient.builder(new HttpHost(elastic_host, elastic_port)).build();
    }

    @Bean
    public ElasticsearchTransport elasticSearchTransport() {
        return new RestClientTransport(restClient(), new JacksonJsonpMapper());
    }

    @Bean
    public ElasticsearchClient elasticSearchClient() {
        return new ElasticsearchClient(elasticSearchTransport());
    }
}
