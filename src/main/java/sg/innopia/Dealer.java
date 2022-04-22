package sg.innopia;

public class Dealer extends Person{
    public Dealer(String name) {
        super("Dealer: " + name);
    }

    public Dealer() {
        super("Dealer");
    }

    @Override
    public void strategy(Deck deck) {
        while(getValue() !=0 && getValue() <16) {
            hit(deck);
        }
    }

    @Override
    public String showFirstHand() {
        return hand.showHandCards(true);
    }
}
