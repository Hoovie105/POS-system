import java.util.ArrayList;
import java.util.List;

class SalesLineItem {
    private ProductSpecification product;
    private int quantity;
    private TaxRate taxRate;
    private DiscountStrategy discountStrategy;

    public SalesLineItem(ProductSpecification product, int quantity, TaxRate taxRate, DiscountStrategy discountStrategy) {
        this.product = product;
        this.quantity = quantity;
        this.taxRate = taxRate;
        this.discountStrategy = discountStrategy;
    }

    public double getSubtotal() {
        return product.getPrice() * quantity;
    }

    public double getTotalWithTaxAndDiscount() {
        double subtotal = getSubtotal();
        double totalWithoutDiscount = subtotal * (1 + taxRate.getRate());
        return discountStrategy.applyDiscount(totalWithoutDiscount);
    }

    @Override
    public String toString() {
        return String.format("%s x%d - Subtotal: %.2f, Total after Tax and Discount: %.2f",
                product.getProductName(), quantity, getSubtotal(), getTotalWithTaxAndDiscount());
    }
}
