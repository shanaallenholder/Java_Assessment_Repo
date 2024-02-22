package com.cbfacademy.apiassessment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class ListRecipeService implements RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;


    @Override 
    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }
    

}
