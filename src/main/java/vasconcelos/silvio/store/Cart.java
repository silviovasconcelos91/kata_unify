package vasconcelos.silvio.store;

import java.util.List;

public final class Cart {
    private final List<Product> product;

    public Cart(List<Product> products) {
        this.product = products;
    }

    public List<Product> getProduct() {
        return product;
    }

    public Price getTotal() {
        return new Price(product.stream().map(Product::getPrice).map(Price::amount).reduce(Integer::sum).orElse(0));
    }

}
