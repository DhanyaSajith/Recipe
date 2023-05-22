package com.example.recipe.service;

import com.example.recipe.entity.Recipe;

import java.util.List;

public interface RecipeService {
    List<Recipe>getAllRecipes();
    Recipe getRecipeById(Long id);
    Recipe createRecipe(Recipe recipe);
    Recipe updateRecipe(Long id, Recipe recipe);
    void deleteRecipe(Long id);
    List<Recipe> filterRecipes(Boolean vegetarian, Integer servings, List<String> includeIngredients, List<String> excludeIngredients, String searchText);
}
