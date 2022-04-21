package sg.innopia;

import static org.junit.jupiter.api.Assertions.*;

import java.io.PrintWriter;

import org.junit.jupiter.api.Test;

class CardTest {

    @Test
    void testToString() {
        PrintWriter printWriter = new PrintWriter(System.out, true);
        Card spadeA = new Card(Suit.SPADE, Rank.ACE);
        printWriter.println(spadeA);

        Card diamondK = new Card(Suit.DIAMOND, Rank.KING);
        printWriter.println(diamondK);

        Card clubQ = new Card(Suit.CLUB, Rank.QUEEN);
        printWriter.println(clubQ);

        Card heartJ = new Card(Suit.HEART, Rank.JACK);
        printWriter.println(heartJ);
    }
}