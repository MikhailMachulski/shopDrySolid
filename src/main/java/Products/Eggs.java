package Products;

public class Eggs implements Product {

    protected String name = "Eggs";
    protected int price = 110;
    protected int rating = 0;

    @Override
    public void print() {
        System.out.println(name +
                " price: " + price + " |" +
                " rating: " + rating);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public int getRating() {
        return rating;
    }

    @Override
    public void addRating() {
        rating = rating + 1;
    }

    @Override
    public void minusRating() {
        rating = rating - 1;
    }
}
