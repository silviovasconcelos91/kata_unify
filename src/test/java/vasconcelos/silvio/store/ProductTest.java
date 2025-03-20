package vasconcelos.silvio.store;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class ProductTest {

    @Test
    void should_get_apple_when_getProductByName_with_value_apple() {
        assertThat(Product.getProductByName("apples")).isEqualTo(Product.APPLES);
    }


    @Test
    void should_get_apple_when_getProductByName_with_value_Apple() {
        assertThat(Product.getProductByName("Apples")).isEqualTo(Product.APPLES);
    }


    @Test
    void should_throw_exception_when_getProductByName_with_value_not_found() {
        assertThatExceptionOfType(NoSuchElementException.class).isThrownBy(() -> Product.getProductByName("silvio"));
    }
}