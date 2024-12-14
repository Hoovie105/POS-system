class Register {
    private Sale currentSale;
    private ProductCatalog productCatalog;
    private double ontarioTaxRate;
    private double quebecTaxRate;

    public Register(ProductCatalog productCatalog, double ontarioTaxRate, double quebecTaxRate) {
        this.productCatalog = productCatalog;
        this.ontarioTaxRate = ontarioTaxRate;
        this.quebecTaxRate = quebecTaxRate;
    }

    public void startNewSale() {
        currentSale = new Sale();
    }

    public void addProductToSale(String productId, int quantity) {
        ProductSpecification product = productCatalog.getProduct(productId);
        if (product != null) {
            currentSale.addLineItem(product, quantity);
        } else {
            System.out.println("Product not found!");
        }
    }

    public void completeSale(String province) {
        double subtotal = currentSale.getTotal();
        double taxRate;

        if ("Ontario".equalsIgnoreCase(province)) {
            taxRate = ontarioTaxRate;
        } else if ("Quebec".equalsIgnoreCase(province)) {
            taxRate = quebecTaxRate;
        } else {
            System.out.println("Invalid province specified");
            return;
        }

        double taxAmount = subtotal * taxRate;
        double totalAmount = subtotal + taxAmount;

        currentSale.displayReceipt();
        System.out.println("Subtotal: " + subtotal);
        System.out.println("Tax: " + taxAmount);
        System.out.println("Total: " + totalAmount);
    }
}
