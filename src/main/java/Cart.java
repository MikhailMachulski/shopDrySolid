import Products.Product;

import java.util.HashMap;

public class Cart {

    public static HashMap<Product, Integer> shoppingCart = new HashMap<>();

    public static void add(Product choice, int price) {
        shoppingCart.put(choice, price);
    }

    public static void remove(Product choice, int price) {
        int newAmount = shoppingCart.get(choice) - price;
        shoppingCart.put(choice, newAmount);
    }

    public static void printCart() {
        int totalPrice = 0;
        for (Product product : shoppingCart.keySet()) {
            int value = shoppingCart.get(product);
            totalPrice = totalPrice + value;
            System.out.println("[" + product.getName() + ": "
                    + (value / product.getPrice()) + "pcs. | " + "total for product: " + value + " | "
                    + "rating: " + product.getRating() + "]");
        }
        System.out.println("Total price is: " + totalPrice);
    }

    public static boolean isEmpty() {
        return shoppingCart.isEmpty();
    }
}
