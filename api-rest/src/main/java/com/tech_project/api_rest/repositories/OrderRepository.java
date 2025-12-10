package com.tech_project.api_rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tech_project.api_rest.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
    
}
