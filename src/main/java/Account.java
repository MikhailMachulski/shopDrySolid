public class Account {
    protected static int balance;

    public static void buy(int price) {
        balance = balance - price;
    }

    public static void abort(int price) {
        balance = balance + price;
    }

    public static void setBalance(int amount) {
        balance = amount;
    }

}
