import java.util.ArrayList;
import java.util.List;

class Sale {
    private List<SalesLineItem> lineItems;

    public Sale() {
        lineItems = new ArrayList<>();
    }

    public void addLineItem(ProductSpecification product, int quantity) {
        SalesLineItem lineItem = new SalesLineItem(product, quantity);
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
        System.out.println("      Receipt");
        System.out.println("--------------------");
        for (SalesLineItem lineItem : lineItems) {
            System.out.println(lineItem);
        }
        System.out.println("--------------------");
        System.out.println("Total: " + getTotal());
    }
}