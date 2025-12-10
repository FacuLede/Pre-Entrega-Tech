package com.tech_project.api_rest.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class ProductRequest {
    private Long id;
    @NotBlank(message = "El campo nombre no puede estar vacío.")
    private String name;
    @NotNull(message = "El campo precio no puede estar vacío.")
    @Positive( message = "El precio debe ser un valor positivo.")
    private Double price;
    @NotNull(message = "El campo stock no puede estar vacío.")
    @PositiveOrZero(message = "El stock no puede ser un valor negativo.")
    private Long stock;
    private String description;   
    private String category;
    private String image;
}
