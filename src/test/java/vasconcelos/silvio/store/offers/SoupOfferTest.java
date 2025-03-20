package vasconcelos.silvio.store.offers;

import org.junit.jupiter.api.Test;
import vasconcelos.silvio.store.Product;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SoupOfferTest {

    private final SoupOffer soupOffer = new SoupOffer(true);

    @Test
    void should_return_reduction_of_40p_for_2_soups_and_1_bread() {
        Discount discount = soupOffer.getDiscount(List.of(Product.SOUP, Product.SOUP, Product.BREAD));
        assertThat(discount.printReduction()).isEqualTo("Buy 2 tins of soup and get a loaf of bread for half price: -40p");
    }

    @Test
    void should_return_reduction_of_80p_for_4_soups_and_2_bread() {
        SoupOffer soupOffer = this.soupOffer;
        Discount discount = soupOffer.getDiscount(List.of(Product.SOUP, Product.SOUP, Product.SOUP, Product.SOUP, Product.BREAD, Product.BREAD));
        assertThat(discount.printReduction()).isEqualTo("Buy 2 tins of soup and get a loaf of bread for half price: -80p");
    }

    @Test
    void should_return_reduction_of_40p_for_3_soups_and_2_bread() {
        SoupOffer soupOffer = this.soupOffer;
        Discount discount = soupOffer.getDiscount(List.of(Product.SOUP, Product.SOUP, Product.SOUP, Product.BREAD, Product.BREAD));
        assertThat(discount.printReduction()).isEqualTo("Buy 2 tins of soup and get a loaf of bread for half price: -40p");
    }

    @Test
    void should_return_reduction_of_40p_for_4_soups_and_1_bread() {
        SoupOffer soupOffer = this.soupOffer;
        Discount discount = soupOffer.getDiscount(List.of(Product.SOUP, Product.SOUP, Product.SOUP, Product.SOUP, Product.BREAD));
        assertThat(discount.printReduction()).isEqualTo("Buy 2 tins of soup and get a loaf of bread for half price: -40p");
    }
}