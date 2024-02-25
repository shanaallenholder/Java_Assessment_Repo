package com.cbfacademy.apiassessment.core;

public class RecipeServiceException extends RuntimeException {
 
        public RecipeServiceException(String message) {
            super("Recipe service error:" + message);
        }
    
        public RecipeServiceException(String message, Throwable cause) {
            super("Recipe service error:" + message, cause);
   
    }
    
}
