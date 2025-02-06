package com.tsoft.poc.elastic.controller;

import com.tsoft.poc.elastic.annotation.LogExecutionTime;
import com.tsoft.poc.elastic.dto.ProductRequest;
import com.tsoft.poc.elastic.dto.ProductResponse;
import com.tsoft.poc.elastic.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/test")
    @ResponseStatus(HttpStatus.OK)
    public String test() {
        return "Hello World";
    }

    @LogExecutionTime
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse createProduct(@RequestBody ProductRequest productRequest) {
        log.info("Creating product: {}", productRequest);
        return productService.save(productRequest);
    }

    @LogExecutionTime
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ProductResponse getProduct(@RequestParam String id) {
        return productService.findById(id);
    }

    @LogExecutionTime
    @GetMapping("/{name}")
    @ResponseStatus(HttpStatus.OK)
    public ProductResponse getProductByName(@PathVariable String name) {
        return productService.findByName(name);
    }
}
