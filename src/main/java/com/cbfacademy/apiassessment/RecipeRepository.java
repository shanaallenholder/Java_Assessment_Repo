package com.cbfacademy.apiassessment;



import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

/**
 * This recipe repository interface defines the methods for managing the recipes in the system
 * It provides the methods for retrieving, saving, updating, adding, searching and deleting recipes. 
 *  */ 

@Repository
public interface RecipeRepository {

// Retrieves all entities from the repository.
List<Recipe> findAll();

// Method to retrieve a recipe by its unique identifier (id).
Optional <Recipe> findById(UUID id);

// Method to search for recipes by name
List<Recipe> searchRecipeByName(String name);

// Method to search for recipe by allergen
List<Recipe> searchRecipeByAllergen(Boolean isGlutenFree, Boolean isNutFree, Boolean isVegan);

// Method to add a new recipe.
Recipe createRecipe(Recipe recipe);

// Method to update an exisitng recipe by its unique identifier (id).
Recipe updateRecipe(UUID id, Recipe updatedRecipe);

// Method to delete a recipe by its unique identifier (id).
void deleteRecipe(UUID id);





}