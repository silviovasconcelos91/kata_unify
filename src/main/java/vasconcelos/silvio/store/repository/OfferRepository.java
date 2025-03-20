package vasconcelos.silvio.store.repository;

import vasconcelos.silvio.store.offers.Offer;

import java.util.Set;

// should be a repository that will retrieve offer on database
public interface OfferRepository {
    Set<Offer> getOffers();
}
