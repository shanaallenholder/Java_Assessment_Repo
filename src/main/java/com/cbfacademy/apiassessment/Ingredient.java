package com.cbfacademy.apiassessment;
// The Ingredient class represents a Ingredient entity with details such as the ingredients name, weight and dietry restrictions.  
public class Ingredient {


    // These are the unique indentifiers for this class - the attributes.
    private String name;
    private double weight;
    private boolean isVegan;
    private boolean isGlutenFree;
    private boolean isNutFree;

    // default constructor
    public Ingredient() {
    }

    /**
     * Parameterised constructor for Ingredients with these specific details.
     * 
     * @param name The name of the ingredient.
     * @param weight The weight of the ingredient in grams.
     * @param isVegan Indicated whether the ingrdient is suitable for vegans.
     * @param isGlutenFree Indicated whether the ingredient is gluten-free.
     * @param isNutFree Indicates whether the ingredient is nut-free.
     */

    public Ingredient(String name, double weight, boolean isVegan, boolean isGlutenFree, boolean isNutFree) {

        this.name = name;
        this.weight = weight;
        this.isVegan = isVegan;
        this.isGlutenFree = isGlutenFree;
        this.isNutFree = isNutFree;

    }

    /**
     * Get the name of the ingredient
     * 
     * @return The name of the ingredient
     */
    public String getName() {
        return name;
    }

    /**
     * Get the weight of the ingredient.
     * 
     * @return The weight of the ingredient.
     */
    public double getWeight() {
        return weight;
    }
   /**
    * Set the weight of a ingredient 
    * @param weight of the ingredient is set to ingredient only if more than 0, weight can not be less than, if no then an exception is thrown.
    */
    public void setWeight(double weight) {
        if (weight < 0) {
        throw new IllegalArgumentException("Weight cannot be a negative number");
        }
        this.weight = weight;
    }

    /**
    * Checks if the recipe is suitable for vegans.
    * @return True if the recipe is vegan, false otherwise. 
    */
    public boolean isVegan() {
        return isVegan;
    }

    /**
    * Sets whether the recipe is suitable for vegans.
    * @param vegan  True if the recipe is suitable for vegans, false otherwise.
    */
    public void setVegan(boolean vegan) {
        isVegan = vegan;
    }

    /**
    * Checks if the recipe is suitable for people with celiac allergies.
    * @return True if the recipe is gluten-free, false otherwise.
    */
    public boolean isGlutenFree() {
        return isGlutenFree;
    }

    /**
    * Sets whether the recipe is suitable for people with Celiac allergies.
    * @param glutenFree  True if the recipe is gluten-free, false otherwise.
    */
    public void setGlutenFree(boolean glutenFree) {
        isGlutenFree = glutenFree;
    }

    /**
    * Checks if the recipe is suitable for people with nut allergies.
    * @return True if the recipe is nut-free, false otherwise. 
    */
    public boolean isNutFree() {
        return isNutFree;
    }

    /**
    * Sets whether the recipe is suitable for people with nut allergies.
    * @return True if the recipe is suitable for people with nut allergies, false otherwise.
    */
    public void setNutFree(boolean nutFree) {
        isNutFree = nutFree;
    }
    
}
