package sg.innopia;

import java.io.IOException;
import java.io.PrintWriter;

public class Game {
    Deck deck;
    Dealer dealer;
    Player player;

    PrintWriter printWriter = new PrintWriter(System.out, true);

    public Game() {
        deck = new Deck();
        dealer = new Dealer();
        player = new Player();
        deck.shuffleAll();
    }

    public Game(Dealer dealer, Player player) {
        deck = new Deck();
        this.dealer = dealer;
        this.player = player;
        deck.shuffleAll();
    }

    public void startGame() throws IOException {
        dealFirstHands();
        printWriter.println("Time for " + player.getName() + " take action");
        player.strategy(deck);

        if(player.getValue() == 0) {
            printWriter.println(player.getName() + " bust, Lose");
            displayHands();
            player.lose(dealer.win());
        } else {
            printWriter.println("Time for " + dealer.getName() + " take action");
            dealer.strategy(deck);

            displayHands();

            if (player.getValue() > dealer.getValue()) {
                dealer.lose(player.win());
                printWriter.println("Player win!");
            }else if(player.getValue() < dealer.getValue()) {
                player.lose(dealer.win());
                printWriter.println("Dealer win!");
            }
        }
    }

    public void newGame() throws IOException {
        if (deck.left() <= 15) {
            deck.shuffleAll();
        }

        player.clearCards();
        dealer.clearCards();

        startGame();
    }

    public void displayPoints() {
        printWriter.println(dealer.getName() + "'s Point: " + dealer.getPoint() + " v.s. "+player.getName() + "'s Point: " + player.getPoint());
    }

    public void displayHands() {
        printWriter.println("");
        printWriter.println(dealer.getName() + "'s Hand: " + dealer.showCards() + " Value: "+ dealer.getValue());
        printWriter.println(player.getName() + "'s Hand: " + player.showCards() + " Value: "+ player.getValue());
    }

    public void dealFirstHands() {
        player.hit(deck);
        dealer.hit(deck);
        player.hit(deck);
        dealer.hit(deck);

        printWriter.println(dealer.getName() + "'s Hand: " + dealer.showFirstHand());
        printWriter.println(player.getName() + "'s Hand: " + player.showFirstHand());
    }
}
