package pl.dominisz.springintroduction;

import pl.dominisz.springintroduction.model.CreditCard;
import pl.dominisz.springintroduction.model.Order;
import pl.dominisz.springintroduction.model.OrderItem;
import pl.dominisz.springintroduction.model.Receipt;
import pl.dominisz.springintroduction.service.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Application {

    public static void main(String[] args) {

        BillingService billingService = new CreditCardBillingService();

        Order order = new Order();
        OrderItem hotDog = new OrderItem("Hot dog", BigDecimal.valueOf(3.59));
        OrderItem coffee = new OrderItem("Coffee", BigDecimal.valueOf(4.99));
        order.addItem(hotDog);
        order.addItem(coffee);

        CreditCard creditCard = new CreditCard("123", "Dexter", "Morgan",
                LocalDate.of(2022, 01, 01));

        Receipt receipt = billingService.chargeOrder(order, creditCard);

        System.out.println(receipt.toString());
    }

}
