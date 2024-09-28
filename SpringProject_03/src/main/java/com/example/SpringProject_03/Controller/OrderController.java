package com.example.SpringProject_03.Controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.example.SpringProject_03.Model.TacoOrder;
import org.springframework.web.bind.support.SessionStatus;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder") // Указывает, что объект tacoOrder будет храниться в сессии,
                                // что позволяет сохранять состояние между разными запросами;
/* Этот контроллер управляет процессом создания заказа, предоставляя пользователю форму для ввода данных и обрабатывая их после отправки. */
public class OrderController {
    @GetMapping("/current")
    public String orderForm() {
        return "orderForm";
    }

    /**
     * 1. Обрабатывает POST-запросы на /orders.
     * 2. Принимает объект TacoOrder, который должен быть валидирован, и объект Errors, который содержит информацию об ошибках валидации.
     * 3. Если валидация не прошла (т.е. есть ошибки), возвращает ту же форму (orderForm) для исправления.
     * 4. Если ошибок нет, записывает информацию о заказе в лог и завершает сессию, устанавливая состояние sessionStatus как завершенное.
     * 5. После успешной обработки заказа перенаправляет пользователя на корневую страницу.
     * @param order
     * @param errors
     * @param sessionStatus
     * @return
     */
    @PostMapping
    public String processOrder(@Valid TacoOrder order, Errors errors, SessionStatus sessionStatus) {
        if (errors.hasErrors()) {
            return "orderForm";
        }
        log.info("Order submitted: {}", order);
        sessionStatus.setComplete();

        return "redirect:/";
    }
}
