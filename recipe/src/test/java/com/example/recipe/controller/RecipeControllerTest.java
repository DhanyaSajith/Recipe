package com.example.recipe.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import com.example.recipe.entity.Recipe;
import com.example.recipe.service.RecipeService;

import static org.mockito.Mockito.when;

public class RecipeControllerTest {
    private MockMvc mockMvc;
    @Mock
    private RecipeService recipeService;

    @InjectMocks
    private RecipeController recipeController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(recipeController).build();
    }

    @Test
    public void testGetAllRecipes() throws Exception {
        List<Recipe> recipes = new ArrayList<>();
        recipes.add(new Recipe());
        recipes.add(new Recipe());
        when(recipeService.getAllRecipes()).thenReturn(recipes);

        mockMvc.perform(get("/recipes"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(2));

        verify(recipeService, times(1)).getAllRecipes();
    }

    @Test
    public void testGetRecipeById() throws Exception {
        Long recipeId = 1L;
        Recipe recipe = new Recipe();
        recipe.setId(recipeId);
        when(recipeService.getRecipeById(recipeId)).thenReturn(recipe);

        mockMvc.perform(get("/recipes/{id}", recipeId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(recipeId));

        verify(recipeService, times(1)).getRecipeById(recipeId);
    }

    @Test
    public void testUpdateRecipe() throws Exception {
        Long recipeId = 1L;
        Recipe recipe = new Recipe();
        recipe.setId(recipeId);
        recipe.setName("Updated Recipe");
        when(recipeService.updateRecipe(eq(recipeId), any(Recipe.class))).thenReturn(recipe);

        mockMvc.perform(put("/recipes/{id}", recipeId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Updated Recipe\"}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("Updated Recipe"));

        verify(recipeService, times(1)).updateRecipe(eq(recipeId), any(Recipe.class));
    }
    @Test
    public void testDeleteRecipe() throws Exception {
        Long recipeId = 1L;

        mockMvc.perform(delete("/recipes/{id}", recipeId))
                .andExpect(status().isOk());

        verify(recipeService, times(1)).deleteRecipe(recipeId);
    }

}

