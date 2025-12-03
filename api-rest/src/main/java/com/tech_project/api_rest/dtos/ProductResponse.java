package com.tech_project.api_rest.dtos;


import jakarta.persistence.Column;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {
    private Long id;
    @Column(unique = true)
    private String name;
    @Positive
    private Double price;
    @PositiveOrZero
    private Long stock;
    private String description;
}
