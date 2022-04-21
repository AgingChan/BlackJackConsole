package sg.innopia;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Card {
    Suit suit;
    Rank rank;

    public int getValue() {
        return rank.value;
    }

    public Character getSuit() {
        return suit.unicode;
    }

}
