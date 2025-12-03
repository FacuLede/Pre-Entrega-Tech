package com.tech_project.api_rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tech_project.api_rest.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
