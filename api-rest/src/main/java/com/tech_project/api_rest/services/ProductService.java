package com.tech_project.api_rest.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tech_project.api_rest.dtos.ProductRequest;
import com.tech_project.api_rest.dtos.ProductResponse;
import com.tech_project.api_rest.entities.Product;
import com.tech_project.api_rest.exceptions.NotFoundException;
import com.tech_project.api_rest.repositories.ProductRepository;
import com.tech_project.api_rest.mappers.Mapper;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    //Contructor con inyección de dependencias
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    //Retorna todos los productos
    public List<ProductResponse> getProducts(){
        return productRepository.findAll().stream().map(Mapper :: toResponse).toList();
    }
    
    //Retorna un producto
    public ProductResponse getProduct(Long id){
        Product product = productRepository.findById(id)
        .orElseThrow(() -> new NotFoundException(id));
        return Mapper.toResponse(product);
    }

    //Crea un producto nuevo en la base y lo retorna
    public ProductResponse createProduct(ProductRequest product){
        return Mapper.toResponse(
            productRepository.save(
                Product.builder()
                .name(product.getName())
                .price(product.getPrice())
                .stock(product.getStock())
                .description(product.getDescription())
                .build()
            )
        );
    }

    //Actualiza un producto existente 
    public ProductResponse updateProduct(ProductRequest productRequest){
        Product product = productRepository.findById(productRequest.getId())
        .orElseThrow(() -> new NotFoundException(productRequest.getId()));

        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        product.setStock(productRequest.getStock());
        product.setDescription(productRequest.getDescription());

        return Mapper.toResponse(productRepository.save(product));
    }

    //Elimina un producto
    public void deleteProduct(Long id){
        Product product = productRepository.findById(id)
        .orElseThrow(() -> new NotFoundException(id));
        productRepository.delete(product);
    }
    
}
