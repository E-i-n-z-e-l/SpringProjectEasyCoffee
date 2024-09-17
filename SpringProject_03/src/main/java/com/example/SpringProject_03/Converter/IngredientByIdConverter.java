package com.example.SpringProject_03.Converter;

import com.example.SpringProject_03.Repository.Ingredient;
import com.example.SpringProject_03.Repository.Ingredient.Type;
import com.example.SpringProject_03.Repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/* @Component обнаруживается механизмом сканирования и создается как bean-компонент в контексте приложения Spring. */
@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {
    private IngredientRepository ingredientRepo;

    @Autowired
    public IngredientByIdConverter(IngredientRepository ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }
    @Override
    public Ingredient convert(String id) {
        return ingredientRepo.findById(id).orElse(null);
    }
}
