import java.util.ArrayList;
import java.util.List;

class ProductSpecification {
    private String productId;
    private String productName;
    private double price;

    public ProductSpecification(String productId, String productName, double price) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
    }
    
     // Getter Functions
    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }
}