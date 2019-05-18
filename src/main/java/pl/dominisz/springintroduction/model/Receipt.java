package pl.dominisz.springintroduction.model;

import java.math.BigDecimal;

public class Receipt {
    private BigDecimal amount;
    private String message;
    private boolean successful;

    public Receipt(BigDecimal amount, String message, boolean successful) {
        this.amount = amount;
        this.message = message;
        this.successful = successful;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccessful() {
        return successful;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "amount=" + amount +
                ", message='" + message + '\'' +
                ", successful=" + successful +
                '}';
    }

    public static Receipt forSuccessfulCharge(BigDecimal amount) {
        return new Receipt(amount, null, true);
    }

    public static Receipt forDeclinedCharge(String declineMessage) {
        return new Receipt(null, declineMessage, false);
    }

    public static Receipt forSystemFailure(String message) {
        return new Receipt(null, message, false);
    }
}

