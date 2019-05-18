package pl.dominisz.springintroduction.service;

import pl.dominisz.springintroduction.model.ChargeResult;
import pl.dominisz.springintroduction.model.CreditCard;

public interface CreditCardProcessor {
    ChargeResult charge(CreditCard creditCard, Object amount);

}
