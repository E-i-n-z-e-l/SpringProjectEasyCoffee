package com.example.SpringProject_03.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller это класс, который обрабатывает запрос и возвращает некоторую информацию.
 * В нем могут создавать GET, POST и другие запросы(методы).
 */
@Controller
public class HomeController {
    /**
     * Простой метод, обрабатывающий GET запросы.
     * Именно этот метод просто указывает, что надо вывести веб-страницу "home".
     * @return
     */
    @GetMapping("/")
    public String home() {
        return "home";
    }

}
