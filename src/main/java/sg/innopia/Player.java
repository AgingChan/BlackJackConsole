package sg.innopia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Player extends Person{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public Player(String name) {
        super("Player: " + name);
    }

    public Player() {
        super("Player");
    }

    @Override
    public void strategy(Deck deck) throws IOException {
        boolean hit;

        System.out.println("Would you like to Hit: [N/y]");
        String decision = br.readLine();
        hit = "y".equalsIgnoreCase(decision);

        if (hit) {
            this.hit(deck);
            if (this.getValue() > 20 || this.getValue()== 0) {
                return;
            } else {
                //allow them to decide to hit or stand again, using our same decks
                this.strategy(deck);
            }
        } else {
            //they stand if enter anything other than 1
            System.out.println("You stand.");
        }
    }
}
