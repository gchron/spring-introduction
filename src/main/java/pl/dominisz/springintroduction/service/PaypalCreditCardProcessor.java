package pl.dominisz.springintroduction.service;

import pl.dominisz.springintroduction.model.ChargeResult;
import pl.dominisz.springintroduction.model.CreditCard;

public class PaypalCreditCardProcessor implements CreditCardProcessor {
    public ChargeResult charge(CreditCard creditCard, Object amount) {
        return null;
    }
}
