import java.util.ArrayList;
import java.util.Scanner;

/** Deck.Java
 *
 *
 *
 *
 * Stefan Perkovic December 7 2022
 */
public class Game {
    private Player player;
    private Deck deck;

    public Game() {
        String suits[] = {"Hearts", "Clubs" , "Diamonds", "Spades"};
        String ranks[] = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        int values[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        deck = new Deck(ranks, values, suits);
        Scanner input = new Scanner(System.in);
        System.out.println("What is your name: ");
        String name = input.nextLine();
        Player user = new Player(name);
    }

//    public void printInstructions(){
//
//    }
//
//    public void playGame(){
//
//    }

    public static void main(String[] args) {
        Game g = new Game();
//        g.playGame();
    }
}

