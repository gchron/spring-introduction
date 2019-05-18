package pl.dominisz.springintroduction.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.dominisz.springintroduction.model.CreditCard;
import pl.dominisz.springintroduction.model.Order;
import pl.dominisz.springintroduction.model.OrderItem;
import pl.dominisz.springintroduction.model.Receipt;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CreditCardBillingServiceTest {

    @Test
    public void shouldSuccessfullyChargedCard() {
        CreditCardBillingService creditCardBillingService = new CreditCardBillingService();
        Order order = new Order();

        OrderItem hotDog = new OrderItem("Coca-Cola", BigDecimal.valueOf(2.99));
        OrderItem coffee = new OrderItem("Coffee", BigDecimal.valueOf(4.5));

        order.addItem(hotDog);
        order.addItem(coffee);

        CreditCard card = new CreditCard("123445435", "Grzegorz", "Brzęczyszczykiewicz", LocalDate.of(2022, 01, 01));

        Receipt receipt = creditCardBillingService.chargeOrder(order, card);

        Assertions.assertTrue(receipt.isSuccessful());
        Assertions.assertEquals(BigDecimal.valueOf(7.49), receipt.getAmount());
    }
}