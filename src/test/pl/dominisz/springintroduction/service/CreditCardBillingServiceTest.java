package pl.dominisz.springintroduction.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import pl.dominisz.springintroduction.model.*;

import java.math.BigDecimal;
import java.time.LocalDate;

class CreditCardBillingServiceTest {

    @Test
    public void shouldSuccessfullyChargedCard() {
        Order order = new Order();
        OrderItem hotDog = new OrderItem("Coca-Cola", BigDecimal.valueOf(2.99));
        OrderItem coffee = new OrderItem("Coffee", BigDecimal.valueOf(4.5));

        order.addItem(hotDog);
        order.addItem(coffee);

        CreditCard card = new CreditCard("123445435", "Grzegorz", "Brzęczyszczykiewicz", LocalDate.of(2022, 01, 01));

        CreditCardProcessor creditCardProcessor = Mockito.mock(CreditCardProcessor.class);
        Mockito.when(creditCardProcessor.charge(
                card, order.getAmount())).thenReturn(new ChargeResult(true, "successful"));

        TransactionLog transactionLog = Mockito.mock(TransactionLog.class);

        CreditCardBillingService creditCardBillingService = new CreditCardBillingService(creditCardProcessor, transactionLog);

        Receipt receipt = creditCardBillingService.chargeOrder(order, card);

        Assertions.assertTrue(receipt.isSuccessful());
        Assertions.assertEquals(BigDecimal.valueOf(7.49), receipt.getAmount());
    }
}