import java.util.ArrayList;
import java.util.List;

class ProductCatalog {
    private List<ProductSpecification> products;

    public ProductCatalog() {
        products = new ArrayList<>();
    }

    public void addProduct(ProductSpecification product) {
        products.add(product);
    }

    public ProductSpecification getProduct(String productId) {
        for (ProductSpecification product : products) {
            if (product.getProductId().equals(productId)) {
                return product;
            }
        }
        return null; // Product NA
    }
}