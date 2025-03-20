package vasconcelos.silvio.store;

import java.util.stream.Stream;

public enum Product {
    APPLES("apples", new Price(100)),
    SOUP("soup", new Price(65)),
    BREAD("bread", new Price(80)),
    MILK("milk", new Price(130));

    private final String name;
    private final Price price;


    Product(String name, Price price) {
        this.name = name;
        this.price = price;
    }

    public static Product getProductByName(String name) {
        return Stream.of(Product.values())
                .filter(product -> product.name.equals(name.toLowerCase()))
                .findFirst()
                .orElseThrow();
    }

    public Price getPrice() {
        return price;
    }
}
