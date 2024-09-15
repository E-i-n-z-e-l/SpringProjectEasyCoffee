package com.example.SpringProject_04;

import com.example.SpringProject_04.Controller.encyclopediaHomeController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(encyclopediaHomeController.class) // Тест для encyclopediaHomeController;
public class encyclopediaHomeControllerTest {
    @Autowired
    private MockMvc mockMvc; // Внедрить MockMvc;
    /* Это часть Spring Test, предназначенная для тестирования веб-слоев в Spring-приложениях.
    Он позволяет выполнять HTTP-запросы к контроллерам вашего приложения в тестовом окружении,
    проверять ответы и взаимодействовать с ними без необходимости запускать реальный сервер. */
    @Test
    public void testHomePage() throws Exception {
        mockMvc.perform(get("/")) // Выполнить запрос GET /;
                .andExpect(status().isOk()) // Ожидается код ответа HTTP 200;
                .andExpect(view().name("enciklopediyaHome")) // Ожидается имя представления home;
                .andExpect(content().contentType("text/html;charset=UTF-8")) // Явное указание кодировки;
                .andExpect(content().string(containsString("\"Энциклопедия Ангарска от А до Я\"")));
    }

}
