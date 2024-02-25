package com.cbfacademy.apiassessment;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface RecipeService {

/**
 * Retrieves a list of all Recipes.
 * 
 * @return A list of all recipes.
 */ 
  List<Recipe> getAllRecipes(); 
   

/**
 * Retrieves a recipe by its specific ID.
 * 
 * @param id The ID of the recipe to retrieve.
 * @return The recipe with the specified ID, or exception messageif not found. 
 */ 
  Recipe getRecipeById(UUID id);
  

/**
 * Searches for a recipe by its name.
 * 
 * @param name The recipe of the recipe to search for.
 * @return The recipe with that name
 */ 
 List<Recipe> searchRecipeByName(String name);


 /**
 * Searches for a recipe based on specified allergen criteria
 * 
 * @param  isGlutenFree Boolean indicating whether the recipe should be gluten-free.
 * @param isNutFree Boolean indicatig whether the recipe should be nut-free.
 * @param isVegan  Boolean indicating whether the recipe should be vegan.
 * @return List of recipes that match the specified allergen criteria.
 */ 
List<Recipe> searchRecipeByAllergen(Boolean isGlutenFree, Boolean isNutFree, Boolean isVegan);


/**
 * Create new recipe.
 * 
 * @param recipe The recipe to create.
 * @return The created recipe. 
 */ 
Recipe createRecipe(Recipe recipe);


/**
 * Updates an exisiting recipe by its ID.
 * 
 * @param id The ID of the recipe to update.
 * @param updatedRecipe The updated recipe.
 * @return The updated recipe.
 */  
 Recipe updateRecipe(UUID id, Recipe updatedRecipe);


/**
 * Deletes a recipe by its ID.
 * 
 * @param id The recipe of the recipe to search for.
 */ 
 void deleteRecipe(UUID id); 



}
