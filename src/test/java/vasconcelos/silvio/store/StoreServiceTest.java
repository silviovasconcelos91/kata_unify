package vasconcelos.silvio.store;

import org.junit.jupiter.api.Test;
import vasconcelos.silvio.store.offers.ApplesOffer;
import vasconcelos.silvio.store.offers.OfferService;
import vasconcelos.silvio.store.repository.FakeOfferRepository;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class StoreServiceTest {

    private StoreService storeService = new StoreService();

    @Test
    public void should_display_product_receipt_with_one_apples_price() {
        String actualReceipt = storeService.buy("PriceBasket Apples");
        String expected = """
                Subtotal: £1.00
                (No offers available)
                Total: £1.00""";
        assertThat(actualReceipt).isEqualTo(expected);
    }

    @Test
    public void should_display_product_receipt_with_one_soup() {
        String actualReceipt = storeService.buy("PriceBasket Soup");
        String expected = """
                Subtotal: 65p
                (No offers available)
                Total: 65p""";
        assertThat(actualReceipt).isEqualTo(expected);
    }


    @Test
    public void should_display_product_receipt_with_two_apples_and_one_soup() {
        String actualReceipt = storeService.buy("PriceBasket Soup Apples Apples");
        String expected = """
                Subtotal: £2.65
                (No offers available)
                Total: £2.65""";
        assertThat(actualReceipt).isEqualTo(expected);
    }

    @Test
    public void should_display_product_receipt_with_discount_when_discount() {
        storeService = new StoreService(new OfferService(new FakeOfferRepository(Set.of(new ApplesOffer(true)))));
        String actualReceipt = storeService.buy("PriceBasket Apples Apples");
        String expected = """
                Subtotal: £2.00
                Apples 10% off: -20p
                Total: £1.80""";
        assertThat(actualReceipt).isEqualTo(expected);
    }

    @Test
    public void should_display_expected_kata_value() {
        storeService = new StoreService(new OfferService(new FakeOfferRepository(Set.of(new ApplesOffer(true)))));
        String actualReceipt = storeService.buy("PriceBasket Apples Milk Bread");
        String expected = """
                Subtotal: £3.10
                Apples 10% off: -10p
                Total: £3.00""";
        assertThat(actualReceipt).isEqualTo(expected);
    }


}
