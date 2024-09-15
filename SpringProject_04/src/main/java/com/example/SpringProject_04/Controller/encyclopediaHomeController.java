package com.example.SpringProject_04.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // Используется для обозначения класса как компонента, который обрабатывает HTTP-запросы и возвращает результаты;
public class encyclopediaHomeController {
    @GetMapping("/") // Обработка GET запросов;
    public String home() {
        return "enciklopediyaHome"; // Возвращает строку "home";
    }
}
