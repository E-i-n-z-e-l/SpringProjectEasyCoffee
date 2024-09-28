package com.example.SpringProject_03.Controller;

import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Класс WebConfig настраивает конфигурацию веб-приложения на основе Spring MVC.
 * <p>
 * Класс реализует интерфейс WebMvcConfigurer, который позволяет настраивать различные аспекты конфигурации Spring MVC.
 * Это включает в себя обработку запросов, настройку контроллеров, представлений и другие параметры.
 * <p>
 * Этот класс упрощает настройку маршрутизации в приложении, позволяя напрямую связывать URL с представлениями
 * без необходимости создания отдельных контроллеров для простых маршрутов. В результате, когда пользователь
 * обращается к корневому URL, он автоматически видит домашнюю страницу, что делает код более лаконичным и организованным.
 */
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("home");
    }
}
