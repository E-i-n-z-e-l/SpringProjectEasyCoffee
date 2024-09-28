package com.example.SpringProject_03.Model;


import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.CreditCardNumber;
import java.util.List;
import java.util.ArrayList;
import lombok.Data;

/**
 * Класс, представляющий заказы, которые клиенты будут оставлять на сайте, с информацией о рецепте, оплате и доставке.
 */
@Data
public class TacoOrder {

    @NotBlank(message="Delivery name is required") // Аннотация @NotBlank означает что переменная не может быть пустой;
    private String deliveryName;

    @NotBlank(message="Street is required")
    private String deliveryStreet;

    @NotBlank(message="City is required")
    private String deliveryCity;

    @NotBlank(message="State is required")
    private String deliveryState;

    @NotBlank(message="Zip code is required")
    private String deliveryZip;

    @CreditCardNumber(message="Not a valid credit card number") // Аннотация проверки номера карты;
    private String ccNumber;

    @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([2-9][0-9])$", // Поле для даты истечения срока действия кредитной карты,
            message="Must be formatted MM/YY")              // помеченное аннотацией @Pattern, которая требует определённого формата (MM/YY);
    private String ccExpiration;

    @Digits(integer=3, fraction=0, message="Invalid CVV") // Аннотация проверки, что значение состоит из трех цифр;
    private String ccCVV;

    private List<Taco> tacos = new ArrayList<>();

    /**
     * Этот метод добавляет объект Taco в список tacos. Это позволяет динамически формировать заказ,
     * добавляя тако по мере необходимости.
     * @param taco
     */
    public void addTaco(Taco taco) {
        this.tacos.add(taco);
    }
}
