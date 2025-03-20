package vasconcelos.silvio.store;

public record Price(int amount) {
    public String printAmount() {
        if (amount >= 100) {
            int numberOfLivre = amount / 100;
            int pennies = amount % 100;
            return String.format("£%d.%02d",numberOfLivre, pennies);
        }
        return amount + "p";
    }
}
