package com.cbfacademy.apiassessment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.cbfacademy.apiassessment.core.DataPersistenceException;
import com.cbfacademy.apiassessment.core.RecipeNotFoundException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
@Primary
public class JsonRecipeRepository implements RecipeRepository {

    // private String filepath =
    // "/Users/shanaah/Desktop/Api_Project_New/api_assessment_new/src/main/resources/RecipeList.json";
    // // files path to the Json file
    private String filepath;
    private ObjectMapper objectMapper; // Object mapper for json
    // private List<Recipe> recipes; // Map which stores the recipes with their UUID
    private final Map<UUID, Recipe> recipes; // Map which stores the recipes with their UUID

    public JsonRecipeRepository(@Value("${json.file.path}") String filepath) {
        this.filepath = filepath;
        this.objectMapper = new ObjectMapper();
        this.recipes = loadRecipesFromJson();

    }

    // Reading data from the JSON file
    public Map<UUID, Recipe> loadRecipesFromJson() {
        try {

            File file = new File(filepath);
            if (!file.exists()) {
                throw new FileNotFoundException("File not found" + filepath);
            }
            return objectMapper.readValue(file, new TypeReference<Map<UUID, Recipe>>() {
            });

        } catch (IOException e) {
            e.printStackTrace();
            return new HashMap<>();
        }

    }

    // Writing data to JSON file.
    private void saveRecipeToJson() {
        if (filepath == null || filepath.isEmpty()) {
            throw new IllegalArgumentException("filepath cannot be null or empty");
        }
        try {
     
            objectMapper.writeValue(new File(filepath),recipes);
        } catch (IOException e) {
            e.printStackTrace();
            throw new DataPersistenceException("Failed to save recipe/data to JSON file:" + filepath, e);
        }

    }

    // Implementing the method to retrieve all recipes
    @Override
    public List<Recipe> findAll() throws DataPersistenceException {
        if (recipes == null || recipes.isEmpty()) {
            throw new PersistenceException("No recipes were found");
        }
        return new ArrayList<>(recipes.values());

    }

    // Implementing the method to retrieve a recipe by its UUID/ID
    @Override
    public Recipe findbyId(UUID id) {
        return recipes.get(id);
    }


    // Implementing the method which will create a new recipe
    @Override
    public Recipe createRecipe(Recipe recipe) throws PersistenceException {
        if (recipe.getId() == null) {
            recipe.setId(UUID.randomUUID());
        }
        recipes.put(recipe.getId(), recipe);
        saveRecipeToJson();
        return recipe;

    }

    // Implementing the method to update an existing recipe
    @Override
    public Recipe updateRecipe(Recipe updatedRecipe) throws IllegalArgumentException, DataPersistenceException {
        if (updatedRecipe.getId() == null || !recipes.containsKey(updatedRecipe.getId())) {
            throw new IllegalArgumentException("Recipe not found so no updates were made");
        }
        recipes.put(updatedRecipe.getId(), updatedRecipe);
        saveRecipeToJson();
        return updatedRecipe;
    }

    // Implementing the method to delete a recipe by its UUID/ID.
    @Override
    public void deleteRecipe(UUID id) throws IllegalArgumentException, RecipeNotFoundException {
        if (!recipes.containsKey(id)) {
            throw new IllegalArgumentException("Recipe not found so cant be deleted");
        }
        recipes.remove(id);
        saveRecipeToJson();
    }
    
    // Implementing the method to search a recipe by name.
    @Override
    public List<Recipe> searchRecipeByName(String name) throws DataPersistenceException {

        if (name == null || name.isEmpty()) {
        }

        return recipes.values().stream()
               .filter(recipe -> recipe.getName().equalsIgnoreCase(name))
               .collect(Collectors.toList());

    }
    
    // Implementing the method to search a recipe by allergen.
    @Override
    public List<Recipe> searchRecipeByAllergen(Boolean isGlutenFree, Boolean isNutFree, Boolean isVegan) throws PersistenceException {

        if (isGlutenFree == null && isNutFree == null && isVegan == null) {
            throw new PersistenceException("At least one allergen criteria must be provided");
        }
            return recipes.values().stream()
                   .filter(recipe ->
                   (isGlutenFree == null || recipe.isGlutenFree() == isGlutenFree) &&
                   (isNutFree == null || recipe.isNutFree() == isNutFree) &&
                   (isVegan == null || recipe.isVegan() == isVegan))
           .collect(Collectors.toList());
        }
    }


