package punit;
import java.util.Scanner;
class Product {
    int id;
    String name;
    float price;

    public Product(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
public class Product {

    private static final int MAX_PRODUCTS = 100;
    private static Product[] products = new Product[MAX_PRODUCTS];
    private static int productCount = 0;
@SuppressWarnings("resource")
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String password = "Punit@856";
    String input, confirm;

    System.out.print("Enter the password: ");
    input = scanner.nextLine();
    System.out.print("Confirm the password: ");
    confirm = scanner.nextLine();

    if (input.equals(password) && input.equals(confirm)) {
        System.out.println("Password is correct and confirmed!");
    } else {
        System.out.println("Access denied. Incorrect password");
        return;
    }

    while (true) {
        System.out.println("\nMarket Management System");
        System.out.println("1. Add Product");
        System.out.println("2. Update Product");
        System.out.println("3. Delete Product");
        System.out.println("4. Search Product");
        System.out.println("5. View Products");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                addProduct(scanner);
                break;
            case 2:
                System.out.print("Enter the product ID to update: ");
                int updateId = scanner.nextInt();
                updateProduct(scanner, updateId);
                break;
            case 3:
                System.out.print("Enter the product ID to delete: ");
                int deleteId = scanner.nextInt();
                deleteProduct(deleteId);
                break;
            case 4:
                System.out.print("Enter the product ID to search: ");
                int searchId = scanner.nextInt();
                searchProduct(searchId);
                break;
            case 5:
                viewProducts();
                break;
            case 6:
                scanner.close();
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}

private static void addProduct(Scanner scanner) {
    System.out.print("Please enter the number of products to add: ");
    int n = scanner.nextInt();
    scanner.nextLine(); // Consume newline

    for (int i = 0; i < n; i++) {
        System.out.print("Enter product ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter product price: ");
        float price = scanner.nextFloat();
        products[productCount++] = new Product(id, name, price);
    }
    System.out.println("Product(s) added successfully.");
}

private static int findProductIndex(int id) {
    for (int i = 0; i < productCount; i++) {
        if (products[i].id == id) {
            return i;
        }
    }
    return -1;
}

private static void updateProduct(Scanner scanner, int id) {
    int index = findProductIndex(id);
    if (index != -1) {
        System.out.print("Enter the updated product name: ");
        products[index].name = scanner.nextLine();
        System.out.print("Enter the updated product price: ");
        products[index].price = scanner.nextFloat();
        System.out.println("Product updated successfully.");
    } else {
        System.out.println("Product with ID " + id + " not found.");
    }
}

private static void deleteProduct(int id) {
    int index = findProductIndex(id);
    if (index != -1) {
        for (int i = index; i < productCount - 1; i++) {
            products[i] = products[i + 1];
        }
        productCount--;
        System.out.println("Product with ID " + id + " deleted successfully.");
    } else {
        System.out.println("Product with ID " + id + " not found.");
    }
}

private static void searchProduct(int id) {
    int index = findProductIndex(id);
    if (index != -1) {
        System.out.println("Product found:");
        System.out.println("Product ID: " + products[index].id);
        System.out.println("Product Name: " + products[index].name);
        System.out.printf("Product Price: %.2f\n", products[index].price);
    } else {
        System.out.println("Product with ID " + id + " not found.");
    }
}

private static void viewProducts() {
    System.out.println("Product List:");
    System.out.println("ID\tName\tPrice");
    for (int i = 0; i < productCount; i++) {
        System.out.printf("%d\t%s\t%.2f\n", products[i].id, products[i].name, products[i].price);
    }
}
}
/*

    
*/