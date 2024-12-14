public class TaxRateFactory {
    private static TaxRateFactory instance;
    
    private TaxRateFactory() {}

    public static TaxRateFactory getInstance() {
        if (instance == null) {
            instance = new TaxRateFactory();
        }
        return instance;
    }

    public TaxRate getTaxRate(String province) {
        if ("Ontario".equalsIgnoreCase(province)) {
            return OntarioTaxRate.getInstance();
        } else if ("Quebec".equalsIgnoreCase(province)) {
            return QuebecTaxRate.getInstance();
        }
        // Default to a generic tax rate if the province is not recognized
        return new GenericTaxRate();
    }
}

// Generic tax rate for unknown provinces
class GenericTaxRate implements TaxRate {
    @Override
    public double getRate() {
        return 0;
    }
}
