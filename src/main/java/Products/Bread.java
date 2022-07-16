package Products;

// SOLID (D) - классы и их применение зависит от имплементируемого интерфейса.
public class Bread implements Product {

    protected String name = "Bread";
    protected int price = 50;
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
