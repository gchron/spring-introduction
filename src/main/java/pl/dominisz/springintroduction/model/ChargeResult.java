package pl.dominisz.springintroduction.model;

public class ChargeResult {

    private boolean successful;
    private String message;

    public boolean isSuccessful() {
        return successful;
    }

    public String getDeclineMessage() {
        return message;
    }
}
