package com.danielmacedo.supermercado_api.exceptions;

public class BadRequestException extends RuntimeException{
    public BadRequestException (String mensagem){
        super(mensagem);
    }
}
