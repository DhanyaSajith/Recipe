package com.example.recipe.controller;
import com.example.recipe.entity.Recipe;
import com.example.recipe.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/recipes")
public class RecipeController {
    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    public List<Recipe> getAllRecipes() {
        return recipeService.getAllRecipes();
    }

    @GetMapping("/{id}")
    public Recipe getRecipeById(@PathVariable Long id) {
        return recipeService.getRecipeById(id);
    }

    @PostMapping
    public Recipe createRecipe(@RequestBody Recipe recipe) {
        return recipeService.createRecipe(recipe);
    }

    @PutMapping("/{id}")
    public Recipe updateRecipe(@PathVariable Long id, @RequestBody Recipe recipe) {
        return recipeService.updateRecipe(id, recipe);
    }

    @DeleteMapping("/{id}")
    public void deleteRecipe(@PathVariable Long id) {
        recipeService.deleteRecipe(id);
    }

    @GetMapping("/filter")
    public List<Recipe> filterRecipes(@RequestParam(required = false) Boolean vegetarian,
                                      @RequestParam(required = false) Integer servings,
                                      @RequestParam(required = false) List<String> includeIngredients,
                                      @RequestParam(required = false) List<String> excludeIngredients,
                                      @RequestParam(required = false) String searchText) {
        return recipeService.filterRecipes(vegetarian, servings, includeIngredients, excludeIngredients, searchText);
    }
    }

