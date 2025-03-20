package vasconcelos.silvio.store.offers;

import vasconcelos.silvio.store.Price;

public record Discount(String name, Price reduction) {

    public String printReduction(){
        return String.format("%s: -%s", name, reduction.printAmount());
    }
}
