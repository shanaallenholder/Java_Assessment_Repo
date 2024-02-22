package com.cbfacademy.apiassessment;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;


@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    
    private RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }
    

    // Get/api/recipes
    @GetMapping()
    public ResponseEntity<List<Recipe>> getAllRecipes() {
        List <Recipe> recipes = recipeService.getAllRecipes();
        if (!recipes.isEmpty()) {
           return new ResponseEntity<>(recipes, HttpStatus.OK);
        } else {
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }      
}



}