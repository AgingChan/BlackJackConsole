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

    public int cardNumber() {
        return hand.size();
    }

    public Card cardAt(int i) {
        if(i>= cardNumber()) {
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
        return cardNumber() == 2 && getValue() == 21;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Card card: hand) {
            str.append(card.toString());
        }
        return str.toString();
    }

    public String showHandCards(boolean coverLastCard) {
        if (coverLastCard) {
            if (hand.size() < 2) {
                throw new RuntimeException("Hand less than 2 cards cannot cover last card");
            }
            StringBuilder str = new StringBuilder();

            for (int i=0; i< hand.size()-1; i++) {
                str.append(hand.get(i).toString());
            }
            str.append("[??]");
            return str.toString();
        } else {
            return toString();
        }
    }
}
