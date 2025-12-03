package com.tech_project.api_rest.exceptions;

public class NotFoundException extends RuntimeException{
    public NotFoundException (Long id){
        super("No se encontró el producto con el id: "+id);
    }
}
