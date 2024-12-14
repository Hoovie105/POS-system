import java.util.ArrayList;
import java.util.List;

class Sale {
    private List<SalesLineItem> lineItems;
    private TaxRateFactory taxRateFactory;

    public Sale(TaxRateFactory taxRateFactory) {
        this.taxRateFactory = taxRateFactory;
        lineItems = new ArrayList<>();
    }

    public void addLineItem(ProductSpecification product, int quantity, String province) {
        TaxRate taxRate = taxRateFactory.getTaxRate(province);
        SalesLineItem lineItem = new SalesLineItem(product, quantity, taxRate);
        lineItems.add(lineItem);
    }

    public double getTotal() {
        double total = 0;
        for (SalesLineItem lineItem : lineItems) {
            total += lineItem.getSubtotal();
        }
        return total;
    }

    public void displayReceipt() {
        System.out.println("                      Receipt");
        System.out.println("---------------------------------------------------");
        for (SalesLineItem lineItem : lineItems) {
            System.out.println(lineItem);
        }
        System.out.println("---------------------------------------------------");
    }
}