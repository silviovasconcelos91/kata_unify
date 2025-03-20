package vasconcelos.silvio.store.offers;

import vasconcelos.silvio.store.Product;
import vasconcelos.silvio.store.repository.OfferRepository;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class OfferService {

    private final OfferRepository offerRepository;


    public OfferService(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    public List<Discount> getDiscounts(List<Product> products) {
        Set<Offer> offers = offerRepository.getOffers();
        return offers.stream()
                .filter(Offer::isActive)
                .map(offer -> offer.getDiscount(products))
                .filter(Objects::nonNull)
                .toList();
    }
}
