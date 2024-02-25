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

    
    
    private String filepath; //  Full path It will be here /Users/shanaah/Desktop/Api_Project_New/api_assessment_new/src/main/resources/RecipeList.json";
    private ObjectMapper objectMapper; // Object mapper for Json file, will alow reading data from the Json file.
    private final Map<UUID, Recipe> recipes; // Map which stores the recipes with their UUID's.

    public JsonRecipeRepository(@Value("${json.file.path}") String filepath) {
        this.filepath = filepath; // Variable to store the file path to the Json file
        this.objectMapper = new ObjectMapper(); // Used FOR serialisation and deserialistion for the JSON file.
        this.recipes = loadRecipesFromJson(); // Method instantiated to load recipes from the Json file.

    }

    // Reading data from the JSON file
    public Map<UUID, Recipe> loadRecipesFromJson() {
        try {

            File file = new File(filepath); // new file variable created to represent the file path.
            if (!file.exists()) { // If the file does not exist then execption below is given.
                throw new FileNotFoundException("File not found" + filepath);
            }
            return objectMapper.readValue(file, new TypeReference<Map<UUID, Recipe>>() { // reads from the file
            });

        } catch (IOException e) {
            e.printStackTrace();
            return new HashMap<>();
        }

    }

    // Writing data to JSON file.
    private void saveRecipeToJson() {
        if (filepath == null || filepath.isEmpty()) { // Checking if the filepath is empty or non existent.
            throw new IllegalArgumentException("filepath cannot be null or empty"); // Exception thorown if it is null or emtpy.
           }
              try {
            objectMapper.writeValue(new File(filepath), recipes); // Writes recipes to the Json file.
        } catch (IOException e) {
            e.printStackTrace(); // Print the error (stack trace) in full if the error is thrown.
            throw new DataPersistenceException("Failed to save recipe/data to JSON file:" + filepath, e); // Error that will appear 
        }

    }

    // Implementing the method to retrieve all recipes
    @Override
    public List<Recipe> findAll() throws DataPersistenceException {
        if (recipes == null || recipes.isEmpty()) { // Checking if the recipes map is non existent or if its empty.
            throw new PersistenceException("No recipes were found"); // If it is empty then this exception will read the message in string.
        }
            return new ArrayList<>(recipes.values()); // If recipes map is not empty or null then recipes map/ wil be returned.
    }

    // Implementing the method to retrieve a recipe by its UUID/ID
    @Override
    public Recipe findbyId(UUID id) { // find the recipe at this ID.
        return recipes.get(id); // return the recipe at this ID.
    }

    // Implementing the method which will create a new recipe
    @Override
    public Recipe createRecipe(Recipe recipe) throws PersistenceException {
        if (recipe.getId() == null) { // If the recipe created doesnt have have a ID (which it wont).
            recipe.setId(UUID.randomUUID()); // Set a new random UUID to the recipe.
        }
        recipes.put(recipe.getId(), recipe); // Add the new recipe to the Map
        saveRecipeToJson(); // Save the map of updated recipes to the Json file
        return recipe; // Return the new recipe map with the updates.

    }

    // Implementing the method to update an existing recipe
    @Override
    public Recipe updateRecipe(Recipe updatedRecipe) throws IllegalArgumentException, DataPersistenceException {
        if (updatedRecipe.getId() == null || !recipes.containsKey(updatedRecipe.getId())) { // Check that if the updated recipe exist/isnt empty with the specified ID that it exisits pecified ID exisits within the recipes map.                                                                
            throw new IllegalArgumentException("Recipe not found so no updates were made"); // throw an exception if recipe with specified ID isnt found                                                                  
        }
        recipes.put(updatedRecipe.getId(), updatedRecipe); // Put the newly updated recipe with new UUID in the recipes map.
        saveRecipeToJson(); // Save the updated recipes to the Json file.
        return updatedRecipe; // Return the updated recipe.
    }

    // Implementing the method to delete a recipe by its UUID/ID.
    @Override
    public void deleteRecipe(UUID id) throws IllegalArgumentException, RecipeNotFoundException {
        if (!recipes.containsKey(id)) { // If the recipe with specified ID is within the recipes Map.
            throw new IllegalArgumentException("Recipe not found so cant be deleted"); // Throw and exception if the recipe is not/was not found.
                                                                                       
        }
        recipes.remove(id); // Remove the recipe by ID from the recipes map.
        saveRecipeToJson(); // Save these changes to the JSON file.
    }

    // Implementing the method to search a recipe by name.
    @Override
    public List<Recipe> searchRecipeByName(String name) throws DataPersistenceException {

        if (name == null || name.isEmpty()) { // Checks to see if the name exists.
        }

        return recipes.values().stream() // If the recipe does exist then filter through the recipe map to return the matching recipes with that name             
                .filter(recipe -> recipe.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());

    }

    // Implementing the method to search a recipe by allergen.
    @Override
    public List<Recipe> searchRecipeByAllergen(Boolean isGlutenFree, Boolean isNutFree, Boolean isVegan)
            throws PersistenceException {

        if (isGlutenFree == null && isNutFree == null && isVegan == null) { // Checking to see if the recipe contains an allerge
                                                                        
            throw new PersistenceException("At least one allergen must be provided");
        }
        return recipes.values().stream() // Filters through the recipe map values and filters out which recipes have which dietry requirments and returns matching ones.
                .filter(recipe -> (isGlutenFree == null || recipe.isGlutenFree() == isGlutenFree) &&
                        (isNutFree == null || recipe.isNutFree() == isNutFree) &&
                        (isVegan == null || recipe.isVegan() == isVegan))
                .collect(Collectors.toList());
    }
}
