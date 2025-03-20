package vasconcelos.silvio.store.offers;

import vasconcelos.silvio.store.Price;
import vasconcelos.silvio.store.Product;

import java.util.List;

public final class ApplesOffer extends Offer {

    public ApplesOffer(boolean isActive) {
        super(isActive);
    }

    @Override
    public Discount getDiscount(List<Product> products) {
        return products.stream()
                .filter(Product.APPLES::equals)
                .map(Product::getPrice)
                .map(Price::amount)
                .map(price -> price/10)
                .reduce(Integer::sum)
                .map(reduction -> new Discount("Apples 10% off", new Price(reduction)))
                .orElse(null);
    }
}
