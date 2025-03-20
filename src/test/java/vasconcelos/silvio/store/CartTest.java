package vasconcelos.silvio.store;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CartTest {

    @Test
    void should_add_1_product_in_cart() {
        Cart cart = new Cart(List.of(Product.APPLES));
        assertThat(cart.getProduct()).hasSize(1);
        assertThat(cart.getProduct()).containsOnly(Product.APPLES);
    }

    @Test
    void should_add_2_product_in_cart() {
        Cart cart = new Cart(List.of(Product.APPLES, Product.MILK));
        assertThat(cart.getProduct()).hasSize(2);
        assertThat(cart.getProduct()).containsOnly(Product.APPLES, Product.MILK);
    }

    @Test
    void should_add_2_apples_in_cart() {
        Cart cart = new Cart(List.of(Product.APPLES, Product.APPLES));
        assertThat(cart.getProduct()).hasSize(2);
        assertThat(cart.getProduct()).containsOnly(Product.APPLES, Product.APPLES);
    }

    @Test
    void should_return_an_amount_of_products_in_the_cart() {
        Cart cart = new Cart(List.of(Product.APPLES, Product.MILK, Product.APPLES));
        assertThat(cart.getTotal()).isEqualTo(new Price(330));
    }
}
