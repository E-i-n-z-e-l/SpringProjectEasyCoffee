package com.example.SpringProject_01.repository;

import com.example.SpringProject_01.Coffee;
import org.springframework.data.repository.CrudRepository;

/**
 * Для того чтобы наше приложение могло пользоваться репозиторием, необходимо определить специфичный для приложения интерфейс.
 */
public interface CoffeeRepository extends CrudRepository<Coffee, String> {
}
