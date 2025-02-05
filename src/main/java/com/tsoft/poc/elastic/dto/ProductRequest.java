package com.tsoft.poc.elastic.dto;

import java.math.BigDecimal;

public record ProductRequest(String name, String description, String category, BigDecimal price) {
}
