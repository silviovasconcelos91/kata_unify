package vasconcelos.silvio.store.offers;

import org.junit.jupiter.api.Test;
import vasconcelos.silvio.store.Product;
import vasconcelos.silvio.store.repository.FakeOfferRepository;
import vasconcelos.silvio.store.repository.OfferRepository;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class OfferServiceTest {

    @Test
    void should_get_apple_discount_when_apple_offer_is_active() {
        OfferService offerService = new OfferService(new FakeOfferRepository(Set.of(new ApplesOffer(true))));
        List<Discount> discounts = offerService.getDiscounts(List.of(Product.APPLES, Product.APPLES));
        assertThat(discounts.size()).isEqualTo(1);
        assertThat(discounts.getFirst()).isNotNull();
        assertThat(discounts.getFirst().printReduction()).isEqualTo("Apples 10% off: -20p");
    }

    @Test
    void should_get_apple_discount_when_apple_offer_is_active_and_soup_offer_not() {
        OfferService offerService = new OfferService(new FakeOfferRepository(Set.of(new ApplesOffer(true), new SoupOffer(false))));
        List<Discount> discounts = offerService.getDiscounts(List.of(Product.APPLES, Product.APPLES, Product.SOUP, Product.SOUP, Product.BREAD));
        assertThat(discounts.size()).isEqualTo(1);
        assertThat(discounts.getFirst()).isNotNull();
        assertThat(discounts.getFirst().printReduction()).isEqualTo("Apples 10% off: -20p");
    }

}