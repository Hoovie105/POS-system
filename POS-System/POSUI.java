import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class POSUI {
    public static void main(String[] args) {
        // Create Sample Products
        ProductCatalog productCatalog = new ProductCatalog();
        productCatalog.addProduct(new ProductSpecification("A1", "Apple", 1.0));
        productCatalog.addProduct(new ProductSpecification("B1", "Banana", 2.0));
        productCatalog.addProduct(new ProductSpecification("O1", "Orange", 3.4));

        // Create a TaxRateFactory
        TaxRateFactory taxRateFactory = TaxRateFactory.getInstance();

        // Create discount strategies
        DiscountStrategy tenPercentDiscount = new TenPercentDiscount();
        DiscountStrategy tenDollarsOffDiscount = new FixedAmountDiscount(0);

        // Create a composite discount strategy
        CompositeDiscount compositeDiscount = new CompositeDiscount();
        compositeDiscount.addDiscount(tenPercentDiscount);
        compositeDiscount.addDiscount(tenDollarsOffDiscount);

        // Create a register with the composite discount strategy
        Register register = new Register(productCatalog, taxRateFactory, compositeDiscount);

        // Start a new sale
        register.startNewSale();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter product ID to add to the sale (or type 'done' to finish):");
            String userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("done")) {
                // Complete the sale
                register.completeSale();
                break;
            }

            System.out.println("Enter quantity:");
            int quantity = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter province:");
            String province = scanner.nextLine();

            // Add products to the sale
            register.addProductToSale(userInput, quantity, province);
        }

        scanner.close();
    }
}