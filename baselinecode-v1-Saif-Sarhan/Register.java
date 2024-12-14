import java.util.ArrayList;
import java.util.List;

class Register {
    private Sale currentSale;
    private ProductCatalog productCatalog;

    public Register(ProductCatalog productCatalog) {
        this.productCatalog = productCatalog;
    }

    public void startNewSale() {
        currentSale = new Sale();
    }

    public void addProductToSale(String productId, int quantity) {
        ProductSpecification product = productCatalog.getProduct(productId);
        if (product != null) {
            currentSale.addLineItem(product, quantity);
        } else {
            System.out.println("Product NA");
        }
    }

    public void completeSale() {
        currentSale.displayReceipt();
    }
}