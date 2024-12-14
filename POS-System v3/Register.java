import java.util.ArrayList;
import java.util.List;

class Register {
    private Sale currentSale;
    private ProductCatalog productCatalog;
    private TaxRateFactory taxRateFactory;

    public Register(ProductCatalog productCatalog, TaxRateFactory taxRateFactory) {
        this.productCatalog = productCatalog;
        this.taxRateFactory = taxRateFactory;
    }

    public void startNewSale() {
        currentSale = new Sale(taxRateFactory);
    }

    public void addProductToSale(String productId, int quantity, String province) {
        ProductSpecification product = productCatalog.getProduct(productId);
        if (product != null) {
            currentSale.addLineItem(product, quantity, province);
        } else {
            System.out.println("Product NA");
        }
    }

    public void completeSale() {
        currentSale.displayReceipt();
    }
}
