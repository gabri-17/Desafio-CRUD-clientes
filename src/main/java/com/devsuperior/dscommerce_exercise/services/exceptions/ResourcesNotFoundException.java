package com.devsuperior.dscommerce_exercise.services.exceptions;

public class ResourcesNotFoundException extends RuntimeException{
    // Exceção personalizada para indicar que um recurso não foi encontrado.
    public ResourcesNotFoundException(String message) {
        super(message); // chamar o construtor da RuntimeException com a mensagem passada.
    }
}
