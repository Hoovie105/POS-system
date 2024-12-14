import java.util.List;
import java.util.ArrayList;

public class CompositeDiscount implements DiscountStrategy {
    private List<DiscountStrategy> discounts;

    public CompositeDiscount() {
        this.discounts = new ArrayList<>();
    }

    public void addDiscount(DiscountStrategy discount) {
        discounts.add(discount);
    }

    @Override
    public double applyDiscount(double originalAmount) {
        double discountedAmount = originalAmount;

        // Apply each discount in the list
        for (DiscountStrategy discount : discounts) {
            discountedAmount = discount.applyDiscount(discountedAmount);
        }

        // Apply additional discount if total is greater than $200
        if (originalAmount > 200) {
            discountedAmount -= 10;
        }

        return discountedAmount;
    }
}
