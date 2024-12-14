import java.util.ArrayList;
import java.util.List;

class SalesLineItem {
    private ProductSpecification product;
    private int quantity;

    public SalesLineItem(ProductSpecification product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public double getSubtotal() {
        return product.getPrice() * quantity;
    }

    @Override
    public String toString() {
        return String.format("%s x%d - %.2f", product.getProductName(), quantity, getSubtotal());
    }
}