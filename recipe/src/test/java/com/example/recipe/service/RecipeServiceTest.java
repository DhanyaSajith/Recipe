package com.example.recipe.service;

import com.example.recipe.entity.Recipe;
import com.example.recipe.repository.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class RecipeServiceTest {
    @Mock
    private RecipeRepository recipeRepository;

    @InjectMocks
    private RecipeServiceImpl recipeService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllRecipes() {
        List<Recipe> recipes = new ArrayList<>();
        recipes.add(new Recipe());
        recipes.add(new Recipe());
        when(recipeRepository.findAll()).thenReturn(recipes);
        List<Recipe> result = recipeService.getAllRecipes();

        assertEquals(2, result.size());
        verify(recipeRepository, times(1)).findAll();
    }

    @Test
    public void testGetRecipeById() {
        Long recipeId = 1L;
        Recipe recipe = new Recipe();
        recipe.setId(recipeId);
        when(recipeRepository.findById(recipeId)).thenReturn(Optional.of(recipe));

        Recipe result = recipeService.getRecipeById(recipeId);

        assertEquals(recipeId, result.getId());
        verify(recipeRepository, times(1)).findById(recipeId);
    }

    @Test
    public void testCreateRecipe() {
        Recipe recipe = new Recipe();
        when(recipeRepository.save(any(Recipe.class))).thenReturn(recipe);

        Recipe result = recipeService.createRecipe(recipe);

        assertEquals(recipe, result);
        verify(recipeRepository, times(1)).save(recipe);
    }
    @Test
    public void testUpdateRecipe() {
        Long recipeId = 1L;
        Recipe existingRecipe = new Recipe();
        existingRecipe.setId(recipeId);

        Recipe updatedRecipe = new Recipe();
        updatedRecipe.setId(recipeId);
        updatedRecipe.setName("Updated Recipe");

        when(recipeRepository.findById(recipeId)).thenReturn(Optional.of(existingRecipe));
        when(recipeRepository.save(any(Recipe.class))).thenReturn(updatedRecipe);

        Recipe result = recipeService.updateRecipe(recipeId, updatedRecipe);

        assertEquals("Updated Recipe", result.getName());
        verify(recipeRepository, times(1)).findById(recipeId);
        verify(recipeRepository, times(1)).save(existingRecipe);
    }
    @Test
    public void testDeleteRecipe() {
        Long recipeId = 1L;

        recipeService.deleteRecipe(recipeId);

        verify(recipeRepository, times(1)).deleteById(recipeId);
    }
    }

