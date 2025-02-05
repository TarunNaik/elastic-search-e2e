package com.tsoft.poc.elastic.dto;

import java.math.BigDecimal;

public record ProductResponse(String id, String name, String description, String category, BigDecimal price) {
}
