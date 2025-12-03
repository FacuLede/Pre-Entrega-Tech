package com.tech_project.api_rest.mappers;

import com.tech_project.api_rest.dtos.ProductResponse;
import com.tech_project.api_rest.entities.Product;

public class Mapper {
    public static ProductResponse toResponse(Product product){
        return ProductResponse.builder()
        .id(product.getId())
        .name(product.getName())
        .price(product.getPrice())
        .stock(product.getStock())
        .description(product.getDescription())
        .build();
    }
}
