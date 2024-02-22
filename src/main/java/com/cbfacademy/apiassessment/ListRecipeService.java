package com.cbfacademy.apiassessment;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service; 


@Service
public class ListRecipeService implements RecipeService {

    private final List<Recipe> recipes = new ArrayList<>();


    @Override 
    public List<Recipe> getAllRecipes() {
        return recipes;
    }
    
}
