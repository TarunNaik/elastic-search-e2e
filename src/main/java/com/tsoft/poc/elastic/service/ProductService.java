package com.tsoft.poc.elastic.service;

import com.tsoft.poc.elastic.document.Product;
import com.tsoft.poc.elastic.dto.ProductRequest;
import com.tsoft.poc.elastic.dto.ProductResponse;
import com.tsoft.poc.elastic.repo.ElasticSearchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ElasticSearchRepository elasticSearchRepository;

    public ProductResponse save(ProductRequest productRequest) {
        Product product = new Product(UUID.randomUUID(), productRequest.name(),
                productRequest.description(), productRequest.category(), productRequest.price());
        Product savedProduct = elasticSearchRepository.save(product);
        return new ProductResponse(savedProduct.getId().toString(),
                savedProduct.getName(), savedProduct.getDescription(), savedProduct.getCategory(), savedProduct.getPrice());
    }

    public ProductResponse findById(String id) {
        Product product = elasticSearchRepository.findById(UUID.fromString(id)).orElseThrow();
        return new ProductResponse(product.getId().toString(),
                product.getName(), product.getDescription(), product.getCategory(), product.getPrice());
    }
}
