package com.cbfacademy.apiassessment.core;

import java.util.UUID;

public class RecipeNotFoundException extends RuntimeException {

    private final UUID recipeId;

    public RecipeNotFoundException(String message) {

        super(message);
        this.recipeId = null;

    }

    public RecipeNotFoundException(UUID recipeId) {
        super("Recipe not found with ID:" + recipeId);
        this.recipeId = null;
    }

    public UUID getRecipeById() {
        return recipeId;
    }

}
