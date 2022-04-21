package sg.innopia;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Card {
    Suit suit;
    Rank rank;

    @Override
    public String toString() {
        return "[" + suit.unicode + " " + rank.rank + "]";
    }

}
