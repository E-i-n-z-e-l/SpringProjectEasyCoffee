package com.example.SpringProject_01;

import java.util.UUID;

/**
 * Создаем класс Кофе.
 */
public class Coffee {
    private  final String id; // final чтобы id присваивался только при создании объекта и более не менялся;
    private String name;

    public Coffee(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coffee (String name) {
        this(UUID.randomUUID().toString(), name);
    }
}
