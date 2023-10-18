package com.ComponentesProyecto.ProyectoAPI.exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String msg) {
        super(msg);
    }
}
