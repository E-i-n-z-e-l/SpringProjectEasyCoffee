package com.example.SpringProject_03.Repository;

import lombok.*;

import java.util.List;

@Data
public class Taco {
    private String name;
    private List<Ingredient> ingredients;
}
