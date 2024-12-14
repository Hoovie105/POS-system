import java.util.ArrayList;
import java.util.List;

class Register {
    private Sale currentSale;
    private ProductCatalog productCatalog;
    private TaxRateFactory taxRateFactory;
    private DiscountStrategy discountStrategy;

    public Register(ProductCatalog productCatalog, TaxRateFactory taxRateFactory, DiscountStrategy discountStrategy) {
        this.productCatalog = productCatalog;
        this.taxRateFactory = taxRateFactory;
        this.discountStrategy = discountStrategy;
    }

    public void startNewSale() {
        currentSale = new Sale(taxRateFactory, discountStrategy); // Pass discountStrategy to Sale constructor
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