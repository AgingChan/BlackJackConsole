package sg.innopia;


import java.io.IOException;

import lombok.Getter;

@Getter
public abstract class Person {
    protected final Hand hand;
    private final String name;
    protected int point;

    public Person(String name) {
        this.hand = new Hand();
        this.name = name;
        this.point = 0;
    }

    public abstract void strategy(Deck deck) throws IOException;

    public String showFirstHand() {
        return showCards();
    }

    public String showCards() {
        return hand.toString();
    }

    public int getValue() {
        return hand.getValue();
    }

    public int hit (Deck deck) {
        hand.getNextCard(deck);
        return hand.getValue();
    }

    public boolean hasBlackJack() {
        return hand.isBlackJack();
    }

    public int win(boolean hasBlackJack) {
        int bonus = hasBlackJack ? 15 : 10;
        point += bonus;
        return bonus;
    }

    public int win() {
        return win(hasBlackJack());
    }

    public void lose(int loss) {
        point -= loss;
    }

}
