package vasconcelos.silvio.store;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PriceTest {

    @Test
    void should_display_90p_when_amount_is_90() {
        Price price = new Price(90);
        assertThat(price.printAmount()).isEqualTo("90p");
    }

    @Test
    void should_display_70p_when_amount_is_70() {
        Price price = new Price(70);
        assertThat(price.printAmount()).isEqualTo("70p");
    }

    @Test
    void should_display_50p_when_amount_is_50() {
        Price price = new Price(50);
        assertThat(price.printAmount()).isEqualTo("50p");
    }

    @Test
    void should_display_£1_when_amount_is_100() {
        Price price = new Price(100);
        assertThat(price.printAmount()).isEqualTo("£1.00");
    }

    @Test
    void should_display_£2_30_when_amount_is_100() {
        Price price = new Price(230);
        assertThat(price.printAmount()).isEqualTo("£2.30");
    }
}
