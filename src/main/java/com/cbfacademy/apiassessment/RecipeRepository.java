package com.cbfacademy.apiassessment;


import org.springframework.stereotype.Repository;

import com.cbfacademy.apiassessment.core.RepositoryR;

import java.util.List;
import java.util.UUID;



/**
 * This recipe repository interface defines the methods for managing the recipes in the system
 * It provides the methods for retrieving, saving, updating, adding, searching and deleting recipes. 
 *  All other methods from RepositoryR are automaticaly being inherited by the RecipeRepository class.
 * 
 **/ 

@Repository
public interface RecipeRepository extends RepositoryR<Recipe, UUID>   {


// // Method to search a recipe by name.
List<Recipe> searchRecipeByName(String name);


// // Method to search for a recipe by specific dietry requirments/needs. 
List<Recipe> searchRecipeByAllergen(Boolean isGlutenFree, Boolean isNutFree, Boolean isVegan);







}