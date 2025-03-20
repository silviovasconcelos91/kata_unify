package vasconcelos.silvio.store.repository;

import vasconcelos.silvio.store.offers.Offer;

import java.util.Set;

public class FakeOfferRepository implements OfferRepository {

    private final Set<Offer> offers;

    public FakeOfferRepository(Set<Offer> offers) {
        this.offers = offers;
    }

    public Set<Offer> getOffers() {
        return this.offers;
    }
}
