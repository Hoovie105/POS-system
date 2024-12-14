import java.util.Scanner;

public class POSUI {
    public static void main(String[] args) {
        // Create a product catalog
        ProductCatalog productCatalog = new ProductCatalog();
        productCatalog.addProduct(new ProductSpecification("A1", "Apple", 1.0));
        productCatalog.addProduct(new ProductSpecification("B1", "Banana", 2.0));
        productCatalog.addProduct(new ProductSpecification("O1", "Orange", 3.4));

        // Create a register with tax rates for Ontario and Quebec
        Register register = new Register(productCatalog, 0.13, 0.14);

        // Start a new sale
        register.startNewSale();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter product ID to add to the sale (or type 'done' to finish):");
            String userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("done")) {
                // Ask for the province
                System.out.println("Enter the province (Ontario/Quebec):");
                String province = scanner.nextLine();
                register.completeSale(province);
                break;
            }

            System.out.println("Enter quantity:");
            int quantity = scanner.nextInt();
            scanner.nextLine(); 
            // Add products to the sale
            register.addProductToSale(userInput, quantity);
        }
        scanner.close();
    }
}
