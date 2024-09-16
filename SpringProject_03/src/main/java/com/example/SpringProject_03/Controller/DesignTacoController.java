package com.example.SpringProject_03.Controller;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.example.SpringProject_03.Repository.Ingredient;
import com.example.SpringProject_03.Repository.Ingredient.Type;
import com.example.SpringProject_03.Repository.Taco;
import com.example.SpringProject_03.Repository.TacoOrder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import lombok.extern.slf4j.Slf4j;


@Slf4j // Аннотация во время компиляции автоматически добавляет Logger;
@Controller // С помощью этой аннотации создаем bean и Spring автоматически находит его и создает;
@RequestMapping("/design") // Эта аннотация определяет тип запросов начинающихся с /design;
@SessionAttributes("tacoOrder") // Эта аннотация указывает, что объект TacoOrder объявленный в классе чуть ниже,
// должен поддерживаться на уровне сеанса. Созданный нами заказ необходимо будет перенести в сеанс, охватывающий несколько запросов.
public class DesignTacoController {
    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("FLTO", "Flour Tortilla", Type.WRAP),
                new Ingredient("COTO", "Corn Tortilla", Type.WRAP),
                new Ingredient("GRBF", "Ground Beef", Type.PROTEIN),
                new Ingredient("CARN", "Carnitas", Type.PROTEIN),
                new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES),
                new Ingredient("LETC", "Lettuce", Type.VEGGIES),
                new Ingredient("CHED", "Cheddar", Type.CHEESE),
                new Ingredient("JACK", "Monterrey Jack", Type.CHEESE),
                new Ingredient("SLSA", "Salsa", Type.SAUCE),
                new Ingredient("SRCR", "Sour Cream", Type.SAUCE)
        );
        Type[] types = Ingredient.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }
    }
    @ModelAttribute(name = "tacoOrder")
    public TacoOrder order() {
        return new TacoOrder();
    }
    @ModelAttribute(name = "taco")
    public Taco taco() {
        return new Taco();
    }
    @GetMapping // Обрабатывает GET запросы;
    public String showDesignForm() {
        return "design";
    }
    private Iterable<Ingredient> filterByType(
            List<Ingredient> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }
}
