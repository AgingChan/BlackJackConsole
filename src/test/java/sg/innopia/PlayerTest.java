package sg.innopia;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlayerTest {
    Deck deck;
    Player player;
    @BeforeEach
    void setUp() {
        deck = new Deck();
    }

    @Test
    void strategy() throws IOException {
        InputStream stdin = System.in;
        try{
            System.setIn(new ByteArrayInputStream("y\nY\nn".getBytes()));
            player = new Player("John");
            player.strategy(deck);
            assertEquals(13, player.getValue());
            assertEquals(2, player.getHand().cardNumber());
        } finally {
            System.setIn(stdin);
        }

    }
}