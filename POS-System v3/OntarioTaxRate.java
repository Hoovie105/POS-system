public class OntarioTaxRate implements TaxRate {
    private static final double RATE = 0.13; // Ontario tax rate

    private OntarioTaxRate() {}

    public static OntarioTaxRate getInstance() {
        return new OntarioTaxRate();
    }

    @Override
    public double getRate() {
        return RATE;
    }
}