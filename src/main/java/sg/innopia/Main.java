package sg.innopia;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Dealer dealer = new Dealer("Amanda");
        Player player = new Player("Chandler");

        Game blackjack = new Game(dealer, player);
        Scanner scanner = new Scanner(System.in);
        PrintWriter printWriter = new PrintWriter(System.out, true);
        boolean anotherGame = true;
        printWriter.println("Welcome to sg.innopia BlackJack Game Console!\n");

        do {
            blackjack.newGame();
            blackjack.displayPoints();

            System.out.println("One more game: [Y/n]");
            String decision = scanner.nextLine();
            anotherGame = !"n".equalsIgnoreCase(decision);
        } while (anotherGame);

        printWriter.println("Thanks and Have a good day!");
    }
}