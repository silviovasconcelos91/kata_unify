package vasconcelos.silvio.store;

import vasconcelos.silvio.store.offers.Discount;
import vasconcelos.silvio.store.repository.FakeOfferRepository;
import vasconcelos.silvio.store.offers.OfferService;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StoreService {

    private final OfferService offerService;

    public StoreService() {
        this.offerService = new OfferService(new FakeOfferRepository(Collections.emptySet()));
    }

    public StoreService(OfferService offerService) {
        this.offerService = offerService;
    }

    public String buy(String command) {
        List<Product> products = splitCommandStringIntoProductList(command);
        Cart cart = new Cart(products);
        List<Discount> discounts = offerService.getDiscounts(products);
        return String.format("""
                Subtotal: %s
                %s
                Total: %s""", cart.getTotal().printAmount(), printDiscount(discounts), printTotalPrice(discounts, cart.getTotal()));
    }

    private String printDiscount(List<Discount> discounts) {
        if (discounts.isEmpty()) {
            return "(No offers available)";
        }
        return discounts.stream().map(Discount::printReduction).collect(Collectors.joining("\n"));
    }

    private String printTotalPrice(List<Discount> discounts, Price cartTotalPrice) {
        return discounts.stream()
                .map(Discount::reduction)
                .map(Price::amount
                ).reduce(Integer::sum)
                .map(reduction -> cartTotalPrice.amount() - reduction)
                .map(Price::new)
                .map(Price::printAmount)
                .orElse(cartTotalPrice.printAmount());
    }

    private List<Product> splitCommandStringIntoProductList(String command) {
        return Arrays.stream(command.split(" ")).filter(splittedCommand -> !"PriceBasket".equals(splittedCommand))
                .map(Product::getProductByName).collect(Collectors.toList());
    }
}
