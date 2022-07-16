import Products.*;

import java.util.Scanner;

public class Main {
    static Milk milk = new Milk();
    static Bread bread = new Bread();
    static Chicken chicken = new Chicken();
    static Eggs eggs = new Eggs();
    static SunflowerOil sunflowerOil = new SunflowerOil();

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Please enter amount of money for your account.");
        int amountOfMoney = scanner.nextInt();
        Account.setBalance(amountOfMoney);

        while (true) {

            System.out.print("Your current cart: ");
            if (Cart.isEmpty())
                System.out.println("is empty.");
            else
                Cart.printCart();

            System.out.println("\nYour account balance is: " + Account.balance);
            printAllProducts();
            System.out.println("\nWould you like to buy or return product? Print \"buy\", \"return\" or \"end\" to finish.");

            String input = scanner.nextLine();

            String choice;
            int amount;

            // SOLID (I) - применен принцип разделение интерфейсов.
            switch (input) {
                case ("buy") -> {
                    System.out.println("Please choose product or print \"end\" to finish. To choose sunflower oil just print \"oil\"");
                    choice = scanner.nextLine();
                    System.out.println("Please enter amount");
                    amount = scanner.nextInt();
                    buyProduct(choice, amount);
                }
                case ("return") -> {
                    System.out.println("Please choose product or print \"end\" to finish. To choose sunflower oil just print \"oil\"");
                    choice = scanner.nextLine();
                    System.out.println("Please enter amount");
                    amount = scanner.nextInt();
                    returnProduct(choice, amount);
                }
                case ("end") -> {
                    Cart.printCart();
                    System.exit(0);
                }
            }

        }
    }

    // SOLID (I) - применен принцип разделение интерфейсов.
    public static void buyProduct(String choice, int amount) {
        int price;
        switch (choice) {
            case ("milk"):
                price = (milk.getPrice() * amount);
                Account.buy(price);
                Cart.add(milk, price);
                milk.addRating();
                break;
            case ("bread"):
                price = (bread.getPrice() * amount);
                Account.buy(price);
                Cart.add(bread, price);
                bread.addRating();
                break;
            case ("chicken"):
                price = (chicken.getPrice() * amount);
                Account.buy(price);
                Cart.add(milk, price);
                chicken.addRating();
                break;
            case ("eggs"):
                price = (eggs.getPrice() * amount);
                Account.buy(price);
                Cart.add(eggs, price);
                eggs.addRating();
                break;
            case ("oil"):
                price = (sunflowerOil.getPrice() * amount);
                Account.buy(price);
                Cart.add(sunflowerOil, price);
                sunflowerOil.addRating();
                break;
            case ("end"):
                break;
            default:
                System.out.println("Invalid input");
                break;
        }
    }

    //SOLID (S) - класс выполняет исключительно функцию возврата товара.
    public static void returnProduct(String choice, int amount) {
        int price;
        switch (choice) {
            case ("milk"):
                price = (milk.getPrice() * amount);
                Account.abort(price);
                Cart.remove(milk, price);
                milk.minusRating();
                break;
            case ("bread"):
                price = (bread.getPrice() * amount);
                Account.abort(price);
                Cart.remove(bread, price);
                bread.minusRating();
                break;
            case ("chicken"):
                price = (chicken.getPrice() * amount);
                Account.abort(price);
                Cart.remove(chicken, price);
                chicken.minusRating();
                break;
            case ("eggs"):
                price = (eggs.getPrice() * amount);
                Account.abort(price);
                Cart.remove(eggs, price);
                eggs.minusRating();
                break;
            case ("oil"):
                price = (sunflowerOil.getPrice() * amount);
                Account.abort(price);
                Cart.remove(sunflowerOil, price);
                sunflowerOil.minusRating();
                break;
            case ("end"):
                break;
            default:
                System.out.println("Invalid input");
                break;
        }
    }

    // Для реализации вывода списка продуктов мной был использован принцип DRY. Вывод был вынесен в отдельный метод.
    public static void printAllProducts() {
        System.out.println();
        milk.print();
        bread.print();
        chicken.print();
        eggs.print();
        sunflowerOil.print();
    }
}
