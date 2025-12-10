package com.tech_project.api_rest.mappers;

import java.util.List;
import java.util.stream.Collectors;

import com.tech_project.api_rest.dtos.OrderDetailRequest;
import com.tech_project.api_rest.dtos.OrderDetailResponse;
import com.tech_project.api_rest.dtos.OrderRequest;
import com.tech_project.api_rest.dtos.OrderResponse;
import com.tech_project.api_rest.dtos.ProductRequest;
import com.tech_project.api_rest.dtos.ProductResponse;
import com.tech_project.api_rest.entities.Order;
import com.tech_project.api_rest.entities.OrderDetail;
import com.tech_project.api_rest.entities.Product;

public class Mapper {
    public static ProductResponse toResponse(Product product){
        return ProductResponse.builder()
        .id(product.getId())
        .name(product.getName())
        .price(product.getPrice())
        .stock(product.getStock())
        .description(product.getDescription())
        .category(product.getCategory())
        .image(product.getImage())
        .build();
    }

    public static Product toEntity(ProductRequest productRequest){
        return Product.builder()
            .name(productRequest.getName())
            .price(productRequest.getPrice())
            .stock(productRequest.getStock())
            .description(productRequest.getDescription())
            .category(productRequest.getCategory())
            .image(productRequest.getImage())
            .build();
    }

    // Mapper de OrderDetailRequest → OrderDetail (Que recibe el producto)
    public static OrderDetail toEntity(OrderDetailRequest dto, Order order, Product product) {
        return OrderDetail.builder()
                .product(product)      
                .quantity(dto.getQuantity())
                .unitPrice(product.getPrice())
                .subtotal(product.getPrice() * dto.getQuantity())
                .order(order)               
                .build();
    }

    // Mapper de OrderDetailRequest → OrderDetail 
    public static OrderDetail toEntity(OrderDetailRequest dto, Order order) {
        return OrderDetail.builder()
                .product(toEntity(dto.getProduct()))      
                .quantity(dto.getQuantity())
                .unitPrice(dto.getProduct().getPrice())
                .subtotal(dto.getProduct().getPrice() * dto.getQuantity())
                .order(order)               
                .build();
    }

    // Mapper de OrderRequest → Order 
    public static Order toEntity(OrderRequest orderRequest) {
        Order order = new Order();

        List<OrderDetail> orderDetails = orderRequest.getOrderDetails()
            .stream()
            .map(detail -> toEntity(detail, order))
            .collect(Collectors.toList());

        order.setOrderDetails(orderDetails);

        return order;
    }

    // Mapper de OrderDetail → OrderDetailResponse
    public static OrderDetailResponse toResponse(OrderDetail detail) {
        return OrderDetailResponse.builder()
                .id(detail.getId())
                .quantity(detail.getQuantity())
                .product(Mapper.toResponse(detail.getProduct())) 
                .subtotal(detail.getSubtotal())
                .unitPrice(detail.getUnitPrice())
                .build();
    }

    // Mapper de Order → OrderResponse
    public static OrderResponse toResponse(Order order) {
        List<OrderDetailResponse> details = order.getOrderDetails()
                .stream()
                .map(Mapper::toResponse)
                .collect(Collectors.toList());
        return OrderResponse.builder()
                .id(order.getId())
                .orderDetails(details)
                .build();
    }
}
