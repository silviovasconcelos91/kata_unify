package vasconcelos.silvio.store.offers;

import vasconcelos.silvio.store.Product;

import java.util.List;

public sealed abstract class Offer permits ApplesOffer, SoupOffer {

    private final boolean isActive;

    protected Offer(boolean isActive) {
        this.isActive = isActive;
    }


    abstract Discount getDiscount(List<Product> products);

    public boolean isActive() {
        return isActive;
    }
}
