package com.example.SpringProject_03.Repository;

import java.util.Optional;

public interface IngredientRepository {
    Iterable<Ingredient> findAll();

    Optional<Ingredient> findById(String id);
    Ingredient save(Ingredient ingredient);

}
