package pl.dominisz.springintroduction.service;

import pl.dominisz.springintroduction.exception.UnreachableException;
import pl.dominisz.springintroduction.model.ChargeResult;
import pl.dominisz.springintroduction.model.CreditCard;

import java.util.Random;

public class PaypalCreditCardProcessor implements CreditCardProcessor {

    private Random random = new Random();

    public ChargeResult charge(CreditCard creditCard, Object amount) {
        int number = random.nextInt(3);
        if (number == 0) {
            System.out.println("Pobrano z karty: " + creditCard.getCardNumber() + " kwotę " + amount);
            return new ChargeResult(true, "Successful charge");
        } else if (number == 1) {
            System.out.println("Operacja pobrania z karty: " + creditCard.getCardNumber() + " zakończona niepowodzeniem");
            return new ChargeResult(false, "Successful charge");
        } else {
            throw new UnreachableException("Błąd połączenia sieciowego");
        }
    }
}
