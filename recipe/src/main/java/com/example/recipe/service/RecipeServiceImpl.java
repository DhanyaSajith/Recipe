package com.example.recipe.service;

import com.example.recipe.entity.Recipe;
import com.example.recipe.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RecipeServiceImpl implements RecipeService {
    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    @Override
    public Recipe getRecipeById(Long id) {
        return recipeRepository.findById(id).orElse(null);
    }

    @Override
    public Recipe createRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    @Override
    public Recipe updateRecipe(Long id, Recipe recipe) {
        Recipe existingRecipe = recipeRepository.findById(id).orElse(null);
        if (existingRecipe != null) {
            existingRecipe.setName(recipe.getName());
            existingRecipe.setInstructions(recipe.getInstructions());
            existingRecipe.setVegetarian(recipe.isVegetarian());
            existingRecipe.setServings(recipe.getServings());
            return recipeRepository.save(existingRecipe);
        }
        return null;
    }

        @Override
        public void deleteRecipe(Long id) {
           recipeRepository.deleteById(id);

        }

        @Override
        public List<Recipe> filterRecipes(Boolean vegetarian, Integer servings, List<String> includeIngredients,
                List<String> excludeIngredients, String searchText) {
            // Implement filtering logic based on the provided criteria
            // Return the filtered recipes
            return null;
        }
    }