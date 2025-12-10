package com.tech_project.api_rest.dtos;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {
    private Long id;   
    
    @NotEmpty(message = "La lista de detalles no puede estar vacía.")
    @Builder.Default
    private List<OrderDetailRequest> orderDetails = new ArrayList<>();
}
