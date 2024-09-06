package com.example.SpringProject_01;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

/**
 * Создаем класс Кофе.
 */
@Entity // Обозначает, что класс является сущностью, которая будет отображаться на таблицу в базе данных
public class Coffee {
    @Id
    private String id;
    private String name;
    public Coffee(String id, String name) {
        this.id = id;
        this.name = name;
    }
    public Coffee() {}

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId (String id) {
        this.id = id;
    }

    public Coffee (String name) {
        this(UUID.randomUUID().toString(), name);
    }
}
