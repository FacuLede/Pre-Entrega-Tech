package com.tech_project.api_rest.services;



import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.tech_project.api_rest.dtos.OrderRequest;
import com.tech_project.api_rest.dtos.OrderResponse;
import com.tech_project.api_rest.entities.Order;
import com.tech_project.api_rest.entities.OrderDetail;
import com.tech_project.api_rest.entities.Product;
import com.tech_project.api_rest.exceptions.NotFoundException;
import com.tech_project.api_rest.mappers.Mapper;
import com.tech_project.api_rest.repositories.OrderRepository;
import com.tech_project.api_rest.repositories.ProductRepository;

import lombok.AllArgsConstructor;

import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class OrderService {
    
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    //Retorna todos los pedidos
    public List<OrderResponse> getOrders(){
        return orderRepository.findAll().stream().map(Mapper :: toResponse).collect(Collectors.toList());
    }

    //Retorna un pedido
    @Transactional(readOnly = true)
    public OrderResponse getOrder(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id));
        return Mapper.toResponse(order);
    }

    //Crea un pedido
    @Transactional
    public OrderResponse createOrder(OrderRequest orderRequest) {

        Order order = new Order();

        List<OrderDetail> orderDetails = orderRequest.getOrderDetails().stream()
        .map(dto -> {
            Product product = productRepository.findById(dto.getProductId())
                .orElseThrow(() -> new NotFoundException(dto.getProductId()));

            return Mapper.toEntity(dto, order, product);
        })
        .collect(Collectors.toList());

        order.setOrderDetails(orderDetails);
        return Mapper.toResponse(orderRepository.save(order));
    }

    //Actualiza un pedido si existe
    @Transactional
    public OrderResponse updateOrder(OrderRequest orderRequest) {
        Order order = orderRepository.findById(orderRequest.getId())
                .orElseThrow(() -> new NotFoundException(orderRequest.getId()));

        // Reemplazamos detalles manteniendo la misma colección para evitar problemas con orphanRemoval
        order.getOrderDetails().clear();

        List<OrderDetail> updatedDetails = orderRequest.getOrderDetails()
                .stream()
                .map(detailDto -> {
                    Product product = productRepository.findById(detailDto.getProductId())
                            .orElseThrow(() -> new NotFoundException(detailDto.getProductId()));
                    return Mapper.toEntity(detailDto, order, product);
                })
                .collect(Collectors.toList());

        order.getOrderDetails().addAll(updatedDetails);

        return Mapper.toResponse(orderRepository.save(order));
    }

    //Elimina un pedido si existe
    public void deleteOrder(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id));
        orderRepository.delete(order);
    }
}
