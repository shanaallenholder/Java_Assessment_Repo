package com.cbfacademy.apiassessment;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.PersistenceException;
import org.springframework.stereotype.Service;

import com.cbfacademy.apiassessment.core.DataPersistenceException;
import com.cbfacademy.apiassessment.core.RecipeNotFoundException;
import com.cbfacademy.apiassessment.core.RecipeServiceException;

/**
 * 
 * The DefaultRecipeService class holds the logic for the Service Interface
 * methods.
 * It defines the methods being used for retrieving, creating, updating and
 * deleting recipes.
 * As well as methods for searching recipes by name and their allergens.
 * It will communicate and retrieve its information direct from the
 * RecipRepository.
 */

@Service
public class DefaultRecipeService implements RecipeService {

    // Injects RecipeRepository into this class. 
    private final RecipeRepository recipeRepository;
   
    // Constructor that must be used with injection to instantiate the injection.
    public DefaultRecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    // Implements the method to get all recipes.
    @Override
    public List<Recipe> getAllRecipes() {
        try {
            return recipeRepository.findAll(); // takes the findall method from the repository to retrieve this inforamtion from the json file

        } catch (PersistenceException e) { // Throw an exception if the getAllRecipe cant be retrieved. 
            e.getMessage();
            return new ArrayList<>(); // An empty list is returned if an exception is to occur. 
        }
    }

    // Implements the method to get a specific recipe by its unique identifier ID.
    @Override
    public Recipe getRecipeById(UUID id) throws RecipeNotFoundException {

        Recipe recipe = recipeRepository.findbyId(id);

        if (recipe == null) {
            throw new RecipeNotFoundException("Recipe not found with id: " + id);
        }
        return recipe;

    }

    // Implements the method to search for a recipe based on specified allergen
    // criteria.
    @Override
    public List<Recipe> searchRecipeByName(String name) {
        try {
            return recipeRepository.searchRecipeByName(name);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    // Implements the method to search for a recipe by thier specific allergen.
    @Override
    public List<Recipe> searchRecipeByAllergen(Boolean isGlutenFree, Boolean isNutFree, Boolean isVegan)
            throws RecipeServiceException {
        try {
            return recipeRepository.searchRecipeByAllergen(isGlutenFree, isNutFree, isVegan);
        } catch (DataPersistenceException e) {
            throw new RecipeServiceException("Failed to search recipes by allergen", e);
        }
    }

    // Implements the method to add/create a new recipe.
    @Override
    public Recipe createRecipe(Recipe recipe) throws RecipeServiceException {
        try {
            return recipeRepository.createRecipe(recipe);
        } catch (DataPersistenceException e) {
            throw new RecipeServiceException("Failed to create recipe", e);
        }
    }

    // Implements the method to update an exisiting recipe by its ID.
    @Override
    public Recipe updateRecipe(UUID id, Recipe updatedRecipe) throws RecipeNotFoundException, RecipeServiceException {
        try {
            getRecipeById(id);
            updatedRecipe.setId(id); // Ensure the id of the updated recipe matches the provided id.
            return recipeRepository.updateRecipe(updatedRecipe);

        } catch (RecipeNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new RecipeServiceException("Failed to update recipe wth ID: " + id, e);

        }

    }

    // Implements the method that will delete a recipe by its ID.
    @Override
    public void deleteRecipe(UUID id) throws RecipeNotFoundException, RecipeServiceException {
        try {
            getRecipeById(id);
            recipeRepository.deleteRecipe(id);
        } catch (RecipeNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new RecipeServiceException("Failed to delete recipe with ID: " + id, e);
        }

    }

}
