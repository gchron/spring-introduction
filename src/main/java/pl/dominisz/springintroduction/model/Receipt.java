package pl.dominisz.springintroduction.model;

public class Receipt {


    public static Receipt forSuccessfulCharge(Object amount) {
        return null;
    }

    public static Receipt forDeclinedCharge(ChargeResult chargeResult) {
        return null;
    }


    public static Receipt forSystemFailure(String message) {
        return null;
    }
}
