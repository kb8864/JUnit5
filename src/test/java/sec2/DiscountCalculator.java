package sec2;

public class DiscountCalculator {

    public double calculateDiscount(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("金額は0以上である必要があります");
        }

        if (amount < 5000) {
            return 0;
        } else if (amount < 10000) {
            return amount * 0.05;
        } else {
            return amount * 0.10;
        }
    }

}
