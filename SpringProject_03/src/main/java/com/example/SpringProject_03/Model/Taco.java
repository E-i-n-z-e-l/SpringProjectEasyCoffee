package com.example.SpringProject_03.Model;

import java.util.List;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
@Data
public class Taco {
    @NotNull
    // Аннотация указывает, что название должно содержать минимум 5 символов. Если это условие не выполняется,
    // будет возвращено соответствующее сообщение об ошибке.
    @Size(min=5, message="Name must be at least 5 characters long")
    private String name;
    @NotNull
    @Size(min=1, message="You must choose at least 1 ingredient")
    private List<Ingredient> ingredients;
}
