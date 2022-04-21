package sg.innopia;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private final List<Card> hand;

    public Hand() {
        hand = new ArrayList<>();
    }

    public void getNextCard(Deck deck) {
        hand.add(deck.dealCard());
    }

    public void getNextCard(Card card) {
        hand.add(card);
    }

    public void discardCards() {
        hand.clear();
    }

    public int cards() {
        return hand.size();
    }

    public Card cardAt(int i) {
        if(i>= cards()) {
            throw new RuntimeException("Illegal card index at hand");
        }
        return hand.get(i);
    }

    public int getValue() {
        int value = 0;
        int aceCount = 0;

        for (Card card: hand) {
            value += card.getRank().value;
            if (Rank.ACE.equals(card.getRank())) {
                aceCount += 1;
            }
        }

        while(aceCount > 0 && value > 21){
            aceCount --;
            value -= 10;
        }
        return value >21 ? 0 : value ;
    }

    public boolean isBlackJack() {
        return cards() == 2 && getValue() == 21;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Card card: hand) {
            str.append(card.toString());
        }
        return str.toString();
    }
}
