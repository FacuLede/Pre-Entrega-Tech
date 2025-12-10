package com.tech_project.api_rest.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.tech_project.api_rest.dtos.OrderRequest;
import com.tech_project.api_rest.dtos.OrderResponse;
import com.tech_project.api_rest.services.OrderService;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @GetMapping
    public List<OrderResponse> getOrders(){
        return orderService.getOrders();
    }
    
    @GetMapping("/{id}")
    public OrderResponse getOrder(@PathVariable Long id) {
        return orderService.getOrder(id);
    }

    @PostMapping()
    public OrderResponse createOrder(@RequestBody @Valid OrderRequest orderRequest) {
        return orderService.createOrder(orderRequest);
    }    
    
    @PutMapping("/{id}")   
    public OrderResponse updateOrder(@PathVariable Long id, @RequestBody @Valid OrderRequest orderRequest) {
        orderRequest.setId(id);
        return orderService.updateOrder(orderRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id){
        orderService.deleteOrder(id);
    }
    
}
