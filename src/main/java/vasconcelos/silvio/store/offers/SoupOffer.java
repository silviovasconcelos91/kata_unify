package vasconcelos.silvio.store.offers;

import vasconcelos.silvio.store.Price;
import vasconcelos.silvio.store.Product;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class SoupOffer extends Offer {

    private final static int PRICE_BREAD_REDUCTION = Product.BREAD.getPrice().amount() / 2;

    protected SoupOffer(boolean isActive) {
        super(isActive);
    }

    @Override
    public Discount getDiscount(List<Product> products) {
        //Possiblement utiliser l'api gatherer
        Map<Boolean, List<Product>> collect = products.stream()
                .filter(List.of(Product.SOUP, Product.BREAD)::contains)
                .collect(Collectors.partitioningBy(product -> product.equals(Product.SOUP)));
        List<Product> soups = collect.get(true);
        List<Product> breads = collect.get(false);

        int numberOfPromotions = getNumberOfBreadReductions(soups, breads);
        if (numberOfPromotions > 0) {
            return new Discount("Buy 2 tins of soup and get a loaf of bread for half price",
                    new Price(numberOfPromotions * PRICE_BREAD_REDUCTION));
        }
        return null;
    }

    private int getNumberOfBreadReductions(List<Product> soups, List<Product> breads) {
        return Math.min(soups.size() / 2, breads.size());
    }
}
