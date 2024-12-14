import java.util.ArrayList;
import java.util.List;

class SalesLineItem {
    private ProductSpecification product;
    private int quantity;
    private TaxRate taxRate;

    public SalesLineItem(ProductSpecification product, int quantity, TaxRate taxRate) {
        this.product = product;
        this.quantity = quantity;
        this.taxRate = taxRate;
    }

    public double getSubtotal() {
        return product.getPrice() * quantity;
    }

    public double getTotalWithTax() {
        return getSubtotal() * (1 + taxRate.getRate());
    }

    @Override
    public String toString() {
        return String.format("%s x%d - Subtotal: %.2f, Total with Tax: %.2f",
                product.getProductName(), quantity, getSubtotal(), getTotalWithTax());
    }
}