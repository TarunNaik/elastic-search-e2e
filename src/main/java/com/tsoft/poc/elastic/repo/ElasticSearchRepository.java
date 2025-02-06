package com.tsoft.poc.elastic.repo;

import com.tsoft.poc.elastic.document.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.Optional;
import java.util.UUID;

public interface ElasticSearchRepository extends ElasticsearchRepository<Product, UUID> {

    Optional<Product> findByName(String name);
}
