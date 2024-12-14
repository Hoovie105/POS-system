public class TenPercentDiscount implements DiscountStrategy {
    private static final double DISCOUNT_PERCENTAGE = 0.10;

    @Override
    public double applyDiscount(double originalAmount) {
        return originalAmount - (originalAmount * DISCOUNT_PERCENTAGE);
    }
}
