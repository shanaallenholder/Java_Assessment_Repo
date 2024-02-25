package com.cbfacademy.apiassessment.core;

public class DataPersistenceException extends RuntimeException {

    private final String errorMessage;

    public DataPersistenceException(String message, Throwable cause) {
        super(message, cause);
        this.errorMessage = message;
    }

    public String getErrorMessage() { 
        return errorMessage;
    }
    
}


