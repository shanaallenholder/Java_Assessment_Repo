package com.cbfacademy.apiassessment;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    private final RecipeService RecipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }
    

    
    // Get/api/recipes
    @GetMapping()
    public ResponseEntity<List<Recipe>> getAllRecipes() {
        List <Recipe> recipes = recipeService.getAllRecipes();

        return new ResponseEntity<>(recipes, HttpStatus.OK);
        
       
}
}