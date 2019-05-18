package pl.dominisz.springintroduction.model;

import java.time.LocalDate;

public class CreditCard {

    private String cardNumber;
    private String firstName;
    private String lastName;
    private LocalDate expireDate;

    public CreditCard(String cardNumber, String firstName, String lastName, LocalDate expireDate) {
        this.cardNumber = cardNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.expireDate = expireDate;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }
}
