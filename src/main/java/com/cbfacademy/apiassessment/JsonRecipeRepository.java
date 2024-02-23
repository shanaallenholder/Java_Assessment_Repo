package com.cbfacademy.apiassessment;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;


// This class implements the Recipe Repository interface and provides the
// implementations of the methods that allow us to interact with recipes stored
// in the JSON file.
@Repository
public class JsonRecipeRepository implements RecipeRepository {

    private final String filepath; // files path to the Json file
    private ObjectMapper objectMapper = new ObjectMapper(); // Object mapper for json
    private final Map<UUID, Recipe> database; // Map which stores the recipes with their UUID
    
    public JsonRecipeRepository(@Value("${json.file.path}") String filepath, ObjectMapper objectMapper) {
        this.filepath = filepath;
        this.objectMapper = objectMapper;
        this.database = loadRecipesFromJson(); // Loads the recipes from the Json file
    }

     // Reading data from JSON file.
    private Map<UUID, Recipe> loadRecipesFromJson() {
        try {
            File file = new File(filepath);
            if (file.exists()) {
                return objectMapper.readValue(file, new TypeReference<Map<UUID, Recipe>>() {}); 
                } else {
                   throw new FileNotFoundException("Json file was not found:" + filepath);
                   }
                } catch (IOException e) {
                    e.printStackTrace();
            throw new DataPersistenceException("Failed to load recipes from the JSON file:" , e);
        }
        
        
    }


    // // Writing data to JSON file.
    // private void saveDataToJson() {
    //     try {
    //         objectMapper.writeValue(new File(filepath), database);

    //     } catch (IOException e) {
    //         throw new DataPersistenceException("Failed to write/save recipes to JSON file:", e);
    //     }
    
    // }

    @Override
    public List<Recipe> findAll() {
        try {
            return new ArrayList<>(database.values());
        } catch (Exception e) {
            throw new DataPersistenceException("Failed to retrieve recipes from the Json file:", e);
        }
    }

    // @Override
    // public Optional<Recipe> findById(UUID id) {
    //     try {
    //         Recipe recipe = database.get(id);
    //         if (recipe != null) {
    //             return Optional.of(recipe);
    //         } else {
    //         return Optional.empty();
    //     }
    // } catch (Exception e) {
    //     throw new DataPersistenceException("Failed to retrieve recipe by its ID:" + id, e);
    // }
    
 

//     @Override
//     public List<Recipe> searchRecipeByName(String name) {
//         try {
//             List<Recipe> foundRecipes
//         }
//         throw new UnsupportedOperationException("Unimplemented method 'searchRecipeByName'");
//     }

//     @Override
//     public List<Recipe> searchRecipeByAllergen(Boolean isGlutenFree, Boolean isNutFree, Boolean isVegan) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'searchRecipeByAllergen'");
//     }

//     @Override
//     public Recipe createRecipe(Recipe recipe) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'createRecipe'");
//     }

//     @Override
//     public Recipe updateRecipe(UUID id, Recipe updatedRecipe) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'updateRecipe'");
//     }

//     @Override
//     public void deleteRecipe(UUID id) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'deleteRecipe'");
//     }

    

      
    }



    

