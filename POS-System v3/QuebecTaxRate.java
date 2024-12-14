public class QuebecTaxRate implements TaxRate {
    private static final double RATE = 0.14; // Quebec tax rate

    private QuebecTaxRate() {}

    public static QuebecTaxRate getInstance() {
        return new QuebecTaxRate();
    }

    @Override
    public double getRate() {
        return RATE;
    }
}
