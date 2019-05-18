package pl.dominisz.springintroduction.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;


class OrderTest {
    @Test
    public void newOrderShouldBeEmpty() {
        Order order = new Order();
        Assertions.assertTrue(order.getOrderItemList().isEmpty());
        Assertions.assertEquals(BigDecimal.ZERO, order.getAmount());
    }

    @Test
    public void orderShouldContainTwoOrderItems() {
        Order order = new Order();
        OrderItem hotDog = new OrderItem("Coca-Cola", BigDecimal.valueOf(2.99));
        OrderItem coffee = new OrderItem("Coffee", BigDecimal.valueOf(4.5));

        order.addItem(hotDog);
        order.addItem(coffee);

        Assertions.assertFalse(order.getOrderItemList().isEmpty());
        Assertions.assertEquals(BigDecimal.valueOf(2), BigDecimal.valueOf(order.getOrderItemList().size()));
        Assertions.assertEquals(BigDecimal.valueOf(7.49), order.getAmount());
    }
}