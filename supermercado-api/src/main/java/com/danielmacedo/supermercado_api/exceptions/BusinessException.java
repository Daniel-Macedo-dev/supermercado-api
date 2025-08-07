package com.danielmacedo.supermercado_api.exceptions;

public class BusinessException extends RuntimeException{
    public BusinessException(String mensagem){
        super(mensagem);
    }
}
