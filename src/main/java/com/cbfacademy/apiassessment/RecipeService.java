package com.cbfacademy.apiassessment;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RecipeService {

//Retrieves a list of all recipes.
List<Recipe> getAllRecipes();

}
