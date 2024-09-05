package com.example.SpringProject_01.controller;

import com.example.SpringProject_01.Coffee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/coffees")
public class RestApiDemoController {
    private List<Coffee> coffees = new ArrayList<Coffee>();

    public RestApiDemoController() {
        coffees.addAll(List.of(
                new Coffee("Café Cereza"),
                new Coffee("Café Ganador"),
                new Coffee("Café Lareño"),
                new Coffee("Café Três Pontas")));
    }

    /** Iterable — это интерфейс в Java, который представляет собой коллекцию элементов,
    по которой можно итерироваться (перебирать элементы).
    В данном случае, Iterable<Coffee> означает, что метод возвращает коллекцию объектов
    типа Coffee, и клиент может итерироваться по этим объектам.

    Данный метод показывает весь список кофе.*/
    @GetMapping
    Iterable<Coffee> getCoffees() {
        return coffees;
    }

    /**
     * Метод ищет кофе с заданным идентификатором и возвращает его, если он найден.
     * @param id
     * @return
     */
    @GetMapping("/{id}") // GET запросы используются для получения ресурсов на сервере.
    Optional<Coffee> getCoffeeById(@PathVariable String id) { // Аннотация @PathVariable используется для извлечения
                                                              // значения переменной из URL и передачи его в метод.
                                                              // В этом случае, значение переменной {id} из URL будет
                                                              // передано в параметр id метода как строка (String).
        for (Coffee c: coffees) {
            if (c.getId().equals(id)) {
                return Optional.of(c); // Optional — это контейнер, который может содержать значение или быть пустым;
                // В данном случае Optional.of(c) означает,
                // что значение (объект Coffee) присутствует и будет возвращено.
            }
        }
        return Optional.empty();
        // Если ни один из объектов в списке не имеет совпадающего идентификатора,
        // метод возвращает Optional.empty(), что означает, что значение не найдено.
        // ___________________________________________________________________________________________________________
        /* Optional используется для представления возможного отсутствия значения. В данном случае это означает,
        что метод может вернуть либо объект Coffee, либо ничего (отсутствие объекта). Это позволяет избежать
        возврата null и явно обозначить, что результат может быть пустым. Это также позволяет клиенту,
        использующему API, легче обрабатывать случаи, когда объект не найден. */
    }

    /**
     * Метод создает новый экземпляр кофе.
     * @param coffee
     * @return
     */
    @PostMapping // POST запросы обычно используются для создания новых ресурсов на сервере.
    Coffee postCoffee(@RequestBody Coffee coffee) { // Аннотация @RequestBody используется для извлечения тела запроса
                                                    // и преобразования его в объект, который передается в метод.
        coffees.add(coffee);
        return coffee;
    }

    /**
     * Метод изменяет экземпляры кофе из существующего списка.<p></p>
     * @PathVariable String id — это аннотация, которая связывает значение переменной id из URL с параметром метода.
     * id представляет уникальный идентификатор кофе, который клиент хочет обновить. <p></p>
     * @RequestBody Coffee coffee — это аннотация, которая указывает, что тело запроса содержит объект кофе,
     * который нужно использовать для обновления существующего ресурса.
     * @param id
     * @param coffee
     * @return
     */
    @PutMapping("/{id}") // PUT запросы обычно используются для изменения ресурсов на сервере.
    Coffee putCoffee(@PathVariable String id, @RequestBody Coffee coffee) {
        int coffeeIndex = -1; // Переменная coffeeIndex используется для хранения индекса объекта кофе в коллекции
                              // coffees. Изначально она устанавливается в -1, что указывает на то, что кофе не найдено.
        for (Coffee c: coffees) {
            if (c.getId().equals(id)) {
                coffeeIndex = coffees.indexOf(c); // находим индекс объекта c в коллекции coffees;
                coffees.set(coffeeIndex, coffee); // обновляем объект в коллекции на новый объект кофе, который передан в теле запроса
            }
        }
        return (coffeeIndex == -1) ? // Используем тернарный оператор вместо IF-ELSE;
                // Если экземпляр кофе не найден, то создаем его;
                new ResponseEntity<>(postCoffee(coffee), HttpStatus.CREATED).getBody() :
                // Если экземпляр найден, то изменяем его;
                new ResponseEntity<>(coffee, HttpStatus.OK).getBody();
    }

    /**
     * Метод для удаления экземпляров кофе.<p>
     * Метод ничего не возвращает, а просто удаляет экземпляр кофе из списка.
     * </p>
     * @param id
     */
    @DeleteMapping("/{id}") // DELETE запросы обычно используются для удаления ресурсов с сервера.
    void deleteCoffee(@PathVariable String id) {
        coffees.removeIf(c -> c.getId().equals(id));
    }
}
