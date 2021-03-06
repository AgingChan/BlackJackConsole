package sg.innopia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {
    private final List<Card> deck;
    private int front;

    public Deck() {
        deck = new ArrayList<>();
        front = 0;

        for (Suit suit: Suit.values()) {
            for (Rank rank: Rank.values()) {
                deck.add(new Card(suit, rank));
            }
        }
    }

    public Deck(boolean shuffle) {
        this();

        if(shuffle) {
            shuffleAll();
        }
    }

    public Card dealCard() {
        if (front >= 52) {
            throw new RuntimeException("Deck is empty");
        }
        return deck.get(front++);
    }

    public int left() {
        return 52 - front;
    }

    public void shuffleAll() {
        front = 0;
        Collections.shuffle(deck, new Random());
    }

    public Card recallLastCard() {
        return front == 0 ? null : deck.get(front - 1);
    }


}
