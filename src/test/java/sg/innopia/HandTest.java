package sg.innopia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HandTest {

    @Test
    void getNextCard() {
        Deck deck = new Deck(true);
        Hand hand = new Hand();

        hand.getNextCard(deck);
        Card card1 = deck.recallLastCard();
        hand.getNextCard(deck);
        Card card2 = deck.recallLastCard();

        assertEquals(2, hand.cardNumber());
        assertEquals(card1, hand.cardAt(0));
        assertEquals(card2, hand.cardAt(1));

        assertEquals(50, deck.left());
    }

    @Test
    void discardCards() {
        Deck deck = new Deck(true);
        Hand hand = new Hand();

        hand.getNextCard(deck);
        hand.getNextCard(deck);

        assertEquals(2, hand.cardNumber());
        assertEquals(50, deck.left());
        hand.discardCards();
        assertEquals(0, hand.cardNumber());
        assertEquals(50, deck.left());
    }

    @Test
    void getValue() {
        Hand hand = new Hand();

        // A+J = 21
        hand.getNextCard(new Card(Suit.SPADE, Rank.ACE));
        hand.getNextCard(new Card(Suit.SPADE, Rank.JACK));
        assertEquals( 21, hand.getValue());
        hand.discardCards();

        // A+A = 12
        hand.getNextCard(new Card(Suit.SPADE, Rank.ACE));
        hand.getNextCard(new Card(Suit.SPADE, Rank.ACE));
        assertEquals( 12, hand.getValue());
        hand.discardCards();

        // A+5+5 = 21
        hand.getNextCard(new Card(Suit.SPADE, Rank.ACE));
        hand.getNextCard(new Card(Suit.SPADE, Rank.FIVE));
        hand.getNextCard(new Card(Suit.SPADE, Rank.FIVE));
        assertEquals( 21, hand.getValue());
        hand.discardCards();

        // A+A+8 = 20
        hand.getNextCard(new Card(Suit.SPADE, Rank.ACE));
        hand.getNextCard(new Card(Suit.SPADE, Rank.ACE));
        hand.getNextCard(new Card(Suit.SPADE, Rank.EIGHT));
        assertEquals( 20, hand.getValue());
        hand.discardCards();

        // A+A + A+8  = 21
        hand.getNextCard(new Card(Suit.SPADE, Rank.ACE));
        hand.getNextCard(new Card(Suit.SPADE, Rank.ACE));
        hand.getNextCard(new Card(Suit.SPADE, Rank.ACE));
        hand.getNextCard(new Card(Suit.SPADE, Rank.EIGHT));
        assertEquals( 21, hand.getValue());
        hand.discardCards();

        // 2+ K + Q  = 0
        hand.getNextCard(new Card(Suit.SPADE, Rank.TWO));
        hand.getNextCard(new Card(Suit.SPADE, Rank.KING));
        hand.getNextCard(new Card(Suit.SPADE, Rank.QUEEN));
        assertEquals( 0, hand.getValue());
        hand.discardCards();
    }


    @Test
    void testBlackJackHand() {
        Hand hand = new Hand();

        // A+J = 21
        hand.getNextCard(new Card(Suit.SPADE, Rank.ACE));
        hand.getNextCard(new Card(Suit.SPADE, Rank.JACK));
        assertTrue( hand.isBlackJack());
        hand.discardCards();

        // A+J = 21
        hand.getNextCard(new Card(Suit.SPADE, Rank.ACE));
        hand.getNextCard(new Card(Suit.SPADE, Rank.TEN));
        assertTrue( hand.isBlackJack());
        hand.discardCards();

        // A+A + A+8  = 21
        hand.getNextCard(new Card(Suit.SPADE, Rank.ACE));
        hand.getNextCard(new Card(Suit.SPADE, Rank.ACE));
        hand.getNextCard(new Card(Suit.SPADE, Rank.ACE));
        hand.getNextCard(new Card(Suit.SPADE, Rank.EIGHT));
        assertFalse( hand.isBlackJack());
        hand.discardCards();

        // A+9 = 20
        hand.getNextCard(new Card(Suit.SPADE, Rank.ACE));
        hand.getNextCard(new Card(Suit.SPADE, Rank.NINE));
        assertFalse( hand.isBlackJack());
        hand.discardCards();

    }
}