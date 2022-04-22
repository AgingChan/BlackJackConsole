package sg.innopia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersonTest {

    Deck deck;
    Player player;
    Dealer dealer;

    @BeforeEach
    void setUp() {
        deck = new Deck();
        player = new Player();
        dealer = new Dealer();
    }

    @Test
    void showFirstHand() {
        player.hit(deck);
        dealer.hit(deck);
        player.hit(deck);
        dealer.hit(deck);

        String playerCard = player.showFirstHand();
        String dealerCard = dealer.showFirstHand();
        assertEquals(new Card(Suit.SPADE, Rank.ACE).toString() + new Card(Suit.SPADE, Rank.THREE), playerCard);
        assertEquals(new Card(Suit.SPADE, Rank.TWO) + "[??]", dealerCard);
    }

    @Test
    void showCards() {
        player.hit(deck);
        dealer.hit(deck);
        player.hit(deck);
        dealer.hit(deck);

        String playerCard = player.showCards();
        String dealerCard = dealer.showCards();
        assertEquals(new Card(Suit.SPADE, Rank.ACE).toString() + new Card(Suit.SPADE, Rank.THREE), playerCard);
        assertEquals(new Card(Suit.SPADE, Rank.TWO).toString() + new Card(Suit.SPADE, Rank.FOUR), dealerCard);
    }

    @Test
    void getValue() {
        player.hit(deck);
        dealer.hit(deck);
        player.hit(deck);
        dealer.hit(deck);

        assertEquals(14, player.getValue());
        assertEquals(6, dealer.getValue());
    }

    @Test
    void hasBlackJack() {
        player.getHand().getNextCard(new Card(Suit.HEART, Rank.ACE));
        player.getHand().getNextCard(new Card(Suit.CLUB, Rank.JACK));

        dealer.getHand().getNextCard(new Card(Suit.HEART, Rank.TWO));
        dealer.getHand().getNextCard(new Card(Suit.CLUB, Rank.KING));

        assertFalse(dealer.hasBlackJack());
        assertTrue(player.hasBlackJack());
    }

    @Test
    void winAndLose() {
        dealer.lose(player.win(true));
        assertEquals(0, dealer.getPoint() + player.getPoint());
        assertEquals(15, player.getPoint());
        assertEquals(-15, dealer.getPoint());


        player.lose(dealer.win(false));
        assertEquals(0, dealer.getPoint() + player.getPoint());
        assertEquals(5, player.getPoint());
        assertEquals(-5, dealer.getPoint());


        player.lose(dealer.win(true));
        assertEquals(0, dealer.getPoint() + player.getPoint());
        assertEquals(-10, player.getPoint());
        assertEquals(10, dealer.getPoint());

    }



}