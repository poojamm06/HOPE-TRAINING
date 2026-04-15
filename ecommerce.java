import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class InvalidProductException extends Exception {
    public InvalidProductException(String message) {
        super(message);
    }
}

class InvalidQuantityException extends Exception {
    public InvalidQuantityException(String message) {
        super(message);
    }
}

class OutOfStockException extends Exception {
    public OutOfStockException(String message) {
        super(message);
    }
}

class PaymentException extends Exception {
    public PaymentException(String message) {
        super(message);
    }
}

class Product {
    private String name;
    private double price;
    private int stock;

    public Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void reduceStock(int quantity) {
        this.stock -= quantity;
    }
}

public class ecommerce {
    private static final Map<String, Product> inventory = new HashMap<>();

    static {
        inventory.put("phone", new Product("Phone", 499.99, 10));
        inventory.put("laptop", new Product("Laptop", 999.99, 5));
        inventory.put("headphones", new Product("Headphones", 149.99, 20));
        inventory.put("book", new Product("Book", 29.99, 50));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Ecommerce Product Order System");
        System.out.println("Available products:");
        inventory.values().forEach(product -> System.out.printf(" - %s: $%.2f (%d in stock)%n", product.getName(), product.getPrice(), product.getStock()));

        try {
            System.out.print("Enter the product name you want to order: ");
            String productName = scanner.nextLine().trim().toLowerCase();

            System.out.print("Enter quantity: ");
            int quantity = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Enter payment amount: ");
            double payment = Double.parseDouble(scanner.nextLine().trim());

            placeOrder(productName, quantity, payment);
            System.out.println("Order completed successfully!");
        } catch (InvalidProductException | InvalidQuantityException | OutOfStockException | PaymentException e) {
            System.out.println("Order failed: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Order failed: Please enter a valid number for quantity and payment.");
        } catch (Exception e) {
            System.out.println("Order failed: Unexpected error occurred.");
        } finally {
            scanner.close();
            System.out.println("Thank you for using the system.");
        }
    }

    private static void placeOrder(String productName, int quantity, double payment)
            throws InvalidProductException, InvalidQuantityException, OutOfStockException, PaymentException {
        if (!inventory.containsKey(productName)) {
            throw new InvalidProductException("Product '" + productName + "' is not available.");
        }

        if (quantity <= 0) {
            throw new InvalidQuantityException("Quantity must be at least 1.");
        }

        Product product = inventory.get(productName);
        if (quantity > product.getStock()) {
            throw new OutOfStockException("Requested quantity exceeds available stock.");
        }

        double totalCost = product.getPrice() * quantity;
        if (payment < totalCost) {
            throw new PaymentException(String.format("Insufficient payment. Total cost is $%.2f.", totalCost));
        }

        product.reduceStock(quantity);
        double change = payment - totalCost;
        System.out.printf("You ordered %d %s(s). Total cost: $%.2f. Change: $%.2f.%n", quantity, product.getName(), totalCost, change);
    }
}

