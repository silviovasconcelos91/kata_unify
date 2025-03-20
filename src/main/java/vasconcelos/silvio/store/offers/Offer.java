package vasconcelos.silvio.store.offers;

import vasconcelos.silvio.store.Product;

import java.util.List;

public sealed abstract class Offer permits ApplesOffer, SoupOffer {

    private boolean isActive;

    protected Offer(boolean isActive) {
        this.isActive = isActive;
    }


    abstract Discount getDiscount(List<Product> products);

    public boolean isActive() {
        return isActive;
    }

    public void activate() {
        isActive = true;
    }

    public void deactivate() {
        isActive = false;
    }
}
