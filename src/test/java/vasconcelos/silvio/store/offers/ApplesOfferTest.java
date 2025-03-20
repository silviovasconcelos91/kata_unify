package vasconcelos.silvio.store.offers;

import org.junit.jupiter.api.Test;
import vasconcelos.silvio.store.Product;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ApplesOfferTest {

    @Test
    void should_return_reduction_of_10p_for_1_apple() {
        ApplesOffer applesOffer = new ApplesOffer(true);
        Discount discount = applesOffer.getDiscount(List.of(Product.APPLES));
        assertThat(discount.printReduction()).isEqualTo("Apples 10% off: -10p");
    }

    @Test
    void should_return_reduction_of_10p_for_1_apple_1_milk() {
        ApplesOffer applesOffer = new ApplesOffer(true);
        Discount discount = applesOffer.getDiscount(List.of(Product.APPLES, Product.MILK));
        assertThat(discount.printReduction()).isEqualTo("Apples 10% off: -10p");
    }

    @Test
    void should_return_reduction_of_20p_for_2_apple_1_milk() {
        ApplesOffer applesOffer = new ApplesOffer(true);
        Discount discount = applesOffer.getDiscount(List.of(Product.APPLES, Product.APPLES, Product.MILK));
        assertThat(discount.printReduction()).isEqualTo("Apples 10% off: -20p");
    }
}