package sg.innopia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DeckTest {

    @Test
    void dealCard() {
        Deck testDeck = new Deck();
        assertEquals(52, testDeck.left());
        for(int i=0; i<52; i++) {
            Card card = testDeck.dealCard();
            Suit expectedSuit = Suit.values()[i / 13];
            Rank expectedRank = Rank.values()[i % 13];

            assertEquals(expectedSuit, card.getSuit());
            assertEquals(expectedRank, card.getRank());
        }
        assertEquals(0, testDeck.left());
        assertThrows(
                RuntimeException.class,
                testDeck::dealCard,
                "Empty deck should throw RuntimeException"
        );
    }

    @Test
    void testShuffleAll() {
        Deck testDeck = new Deck();
        testDeck.dealCard();
        testDeck.dealCard();
        testDeck.dealCard();
        assertEquals(49, testDeck.left());
        testDeck.shuffleAll();
        assertEquals(52, testDeck.left());
    }
}