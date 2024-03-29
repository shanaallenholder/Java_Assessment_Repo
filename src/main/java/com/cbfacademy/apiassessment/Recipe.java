package com.cbfacademy.apiassessment;

import java.util.List;
import java.util.UUID;

public class Recipe {


    // These are the unique identifiers for this class- The attributes.
    private UUID id;  //Unique identifier for each recipe
    private String name;
    private boolean isVegan;
    private boolean isGlutenFree;
    private boolean isNutFree;
    private String instructions; 
    private List<Ingredient> ingredients;
    private int servings;

    public Recipe() {
    }

    /**
     * Parameterised constructor to create a Recipe with these specific details.
     * 
     * @param id  The unique ID of the recipe.
     * @param name The name of the Recipe.
     * @param isVegan Indicates wheter the recipe is suitable for vegans or not.
     * @param isGlutenFree Indicates wheter the recipe is gluten-free.
     * @param isNutFree Indicates wheter the recipe is nut-free.
     * @param instructions The instructions to execute the recipe
     * @param ingredients The ingredients for the recipe 
     * @param servings  The amount of servings the recipe yields.
     *
     * 
     */

    // This is the recipe contructor whihch doesnt include the UUID as this is to be
    // generated from the back end not the caller
    public Recipe(String name, boolean isVegan, boolean isGlutenFree, boolean isNutFree, String instructions, List<Ingredient> ingredients, int servings){
        this.id = UUID.randomUUID(); // Generating a random UUID
        this.name = name;
        this.isVegan = isVegan;
        this.isGlutenFree = isGlutenFree;
        this.isNutFree = isNutFree;
        this.instructions = instructions;
        this.ingredients = ingredients;
        this.servings = servings;
    }

    /**
     * Get the unique ID of the recipe - No setter is needed as we dont want the
     * identifier to be changed.
     * 
     * @return The unique identifier for the recipe.
     */
    public UUID getId() {
        return id;
    }

    /**
     * Set the new UUID
     * 
     * @param randomUUID
     */

      public void setId(UUID id) {
         this.id = id;
    }

    /**
     * Get the name of the recipe.
     * 
     * @return The name of the recipe.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the new name of the recipe.
     * 
     * @param name Of the Recipe is set as the new name for recipe.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Checks if the recipe is suitable for vegans.
     * 
     * @return True if the recipe is vegan, false otherwise.
     */
    public boolean isVegan() {
        return isVegan;
    }

    /**
     * Sets whether the recipe is suitable for vegans.
     * 
     * @param vegan True if the recipe is suitable for vegans, false otherwise.
     */
    public void setVegan(boolean vegan) {
        isVegan = vegan;
    }

    /**
     * Checks if the recipe is suitable for people with celiac allergies.
     * 
     * @return True if the recipe is gluten-free, false otherwise.
     */
    public boolean isGlutenFree() {
        return isGlutenFree;
    }

    /**
     * Sets whether the recipe is suitable for people with Celiac allergies.
     * 
     * @param glutenFree True if the recipe is gluten-free, false otherwise.
     */
    public void setGlutenFree(boolean glutenFree) {
        isGlutenFree = glutenFree;
    }

    /**
     * Checks if the recipe is suitable for people with nut allergies.
     * 
     * @return True if the recipe is nut-free, false otherwise.
     */
    public boolean isNutFree() {
        return isNutFree;
    }

    /**
     * Sets whether the recipe is suitable for people with nut allergies.
     * 
     * @return True if the recipe is suitable for people with nut allergies, false
     *         otherwise.
     */
    public void setNutFree(boolean nutFree) {
        isNutFree = nutFree;
    }


    /**
     * Get the instructions required to make a recipe.
     * 
     * @return The cooking instructions for a recipe. 
     */
       
     public String getInstructions(){
        return instructions;
     }


    /**
     * set the instructions required to make a recipe 
     * 
     * @param instructions are set for the new recipe 
     */
       
     public void setInstructions(String instructions){
        this.instructions = instructions;
     }


     /**
     * Get the ingredients required to make a particular recipe. 
     * 
     * @return The list of ingredients needed for a particular recipe.
     */
       
     public List<Ingredient> getIngredients(){
        return ingredients;
     }

    /**
     * set the ingredients required to make a recipe 
     * 
     * @param ingredients are set for the recipe 
     */
       
     public void setIngredients(List<Ingredient> ingredients){
        this.ingredients = ingredients;
     }

    /**
     * Get the number of servings the recipe yields.
     * 
     * @return The number of servings the recipe yields.
     */
    public int getServings() {
        return servings;
    }

    /**
     * Sets the number of servings the recipe will have.
     * 
     * @param servings The amount of servings is set to the recipe.
     */
    public void setServings(int servings) {
        this.servings = servings;
    

}

}