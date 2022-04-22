package sg.innopia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DealerTest {
    Deck deck;
    Dealer dealer;

    @BeforeEach
    void setUp() {
        deck = new Deck();
        dealer = new Dealer("Lisa");
    }

    @Test
    void strategy() {
        for(int i=0; i<10; i++){
            dealer.strategy(deck);
            assertTrue(dealer.getValue()==0 || dealer.getValue() >= 16);
            dealer.clearCards();
        }
    }
}