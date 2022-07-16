package Products;

// SOLID (O) - данные класса открыты для расширения.
public interface Product {
    void print();

    String getName();

    int getPrice();

    int getRating();

    void addRating();

    void minusRating();


}
