package com.cbfacademy.apiassessment;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cbfacademy.apiassessment.core.DataPersistenceException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import org.springframework.web.bind.annotation.RequestParam;


/**
 *  Controller class to implment Recipe API endpoints (CRUD/Http)
 */
@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    
private final RecipeService recipeService;

public RecipeController(RecipeService recipeService) {
    this.recipeService = recipeService;
    }
    
/**
 * Get request
 * 
 * Retrieves a list of all recipes.
 * @return A ResponseEntity containing a list of all recipes and HttpStatus OK if successful.
 * 
 * Endpoint URL http://localhost:8080/api/recipes
 * 
 */
 @GetMapping
public ResponseEntity<List<Recipe>> getAllRecipes() {
    try {
        List <Recipe> recipes = recipeService.getAllRecipes();
        return new ResponseEntity<>(recipes, HttpStatus.OK);

    } catch (Exception e) {

        e.printStackTrace();
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  
 }   
    
/**
 * Get request
 * 
 * Retrieves a specific recipe by its unique identifier/ID
 * @param  ID of the recipe to retrieve
 * 
 */
    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable UUID id) {

      Recipe recipe = recipeService.getRecipeById(id);
      if (recipe != null) {
        return new ResponseEntity<>(recipe, HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }   

    }


/**
 * Get request
 * 
 * Searches for a recipe by its name.
 * 
 * @param name The name of the recipe to search for.
 * @return The recipe with that name
 *
 */ 
@GetMapping("/name/{name}")
public ResponseEntity <List<Recipe>> searchRecipeByName(@PathVariable String name) {
 try {
    List<Recipe> recipes = recipeService.searchRecipeByName(name);
    return ResponseEntity.ok().body(recipes);
 } catch (Exception e) {
    e.printStackTrace();
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
 }
}


/**
 * Get request 
 * 
* Searches for a recipe based on specified allergen.
* 
* @param  isGlutenFree Boolean indicating whether the recipe should be gluten-free.
* @param isNutFree Boolean indicatig whether the recipe should be nut-free.
* @param isVegan  Boolean indicating whether the recipe should be vegan.
* @return List of recipes that match the specified allergen criteria.
* 
*/ 
@GetMapping("/allergen/{allergen}")
public ResponseEntity<List<Recipe>> searchRecipeByAllergen(
          @RequestParam(required = false) Boolean glutenFree,
          @RequestParam(required = false) Boolean nutFree,
          @RequestParam(required = false) Boolean vegan) throws IOException  {
      List<Recipe> recipes = recipeService.searchRecipeByAllergen(glutenFree, nutFree, vegan);
      return  ResponseEntity.ok().body(recipes);
}


/**
 *  Allows the user to create a new recipe.
 * @param createRecipe The recipe to be created.
 * 
 */
  @PostMapping ()
    public ResponseEntity<Recipe> createRecipe(@RequestBody Recipe recipe) {
      try {
        Recipe newRecipe = recipeService.createRecipe(recipe);
        return new ResponseEntity<>(newRecipe, HttpStatus.CREATED);
      } catch (DataPersistenceException e) {
        e.printStackTrace();
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      }  

  }


/**
 * Allows the user to update an exisiting recipe by its ID.
 * 
 * @param id The ID of the recipe to update.
 * @param updatedRecipe The updated recipe.
 * Example URL to test http://localhost:8080/api/recipes/e5573a42-a0ee-4cc7-b72e-97e0076eac2e
 */ 
@PutMapping("/{id}")
    public ResponseEntity<Recipe> updateRecipe(@PathVariable UUID id, @RequestBody Recipe recipe) throws IOException {
            Recipe updatedRecipe = recipeService.updateRecipe(id, recipe);
            return new ResponseEntity<>(updatedRecipe, HttpStatus.OK);
      
        }



/**
 * Allows the user to delete a recipe by its ID.
 * 
 * @param id The recipe ID that will be deleted.
 */ 
@DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable UUID id) throws IOException {
        recipeService.deleteRecipe(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
