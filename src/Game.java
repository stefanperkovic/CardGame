import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

/** Game.Java
 * Stefan Perkovic December 8 2022
 * The game class runs a round of BlackJack with the base set of 52 cards
 * The user has the ability to draw cards based on their choice
 * The computer only draw if it has less than 17 points
 * The winner is the one closest to 21 point who doesn't go over
 */
public class Game {
    private Player user;
    private Player computer;
    private Deck deck;
    private BlackJackViewer window;
    public static final int playerCord = 600;
    public static final int computerCord = 200;
    private String winner;

    /**
     * Initializes the deck, player, and computer
     */
    public Game() {
        window = new BlackJackViewer(this);
        String suits[] = {"Spades", "Hearts" , "Diamonds", "Clubs"};
        String ranks[] = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        int values[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        deck = new Deck(ranks, values, suits, window);
        Scanner input = new Scanner(System.in);
        System.out.print("What is your name: ");
        String name = input.nextLine();
        user = new Player(name);
        computer = new Player("Computer");
        winner = null;
    }

    /**
     * Prints the Instructions to the game
     */
    public void printInstructions(){
        System.out.println("Welcome to the game of Blackjack");
        System.out.println("The goal is to have your cards add up as close to 21");
        System.out.println("However if you exceed 21 you will bust");
        System.out.println("You will start with two cards and draw more if you want");
        System.out.println("You are against a computer who also wants to win");
        System.out.println("The computer will draw a card when under 17 points");
        System.out.println("Whoever is closer to 21 points will win");
    }


    /**
     * Runs one round of the game until there is a winner
     */
    public void playGame(){
        printInstructions();
        setupGame();
        Scanner input = new Scanner(System.in);
        /**
         * If user has less than 21 points they can draw more cards
         */
        while (user.getPoints() < 21){
            System.out.println("Hit or Stay?");
            if (input.nextLine().equals("Hit")){
                drawCard(user);
                if (checkBust() == true) {
                    return;
                }
                /**
                 * Computer draws card if its points are less than 17
                 */
                if (computer.getPoints() < 17){
                    drawCard(computer);
                    if (checkBust() == true){
                        return;
                    }
                }
            }
            /**
             * Computer draws until it has over 17 points
             */
            else{
                while (computer.getPoints() < 17){
                    drawCard(computer);
                }
                if (checkBust() == true){
                    return;
                }
                break;
            }
        }
        checkWin();
    }

    /**
     * @return true if either computer or user busted
     * @return false if game continues
     */
    public boolean checkBust(){
        if (user.getPoints() > 21){
            System.out.println("Computer Wins");
            winner = "Computer";
            return true;
        }
        else if (computer.getPoints() > 21){
            System.out.println(user.getName() + " Wins");
            winner = user.getName();
            return true;
        }
        return false;
    }


    /**
     * Checks if the user or the computer has won the game
     */
    public void checkWin(){
        if (computer.getPoints() > user.getPoints()){
            System.out.println("Computer Wins");
            winner = "Computer";
        }
        else if (computer.getPoints() == user.getPoints()){
            System.out.println("Its a tie");
            winner =  "Tie";

        }
        else{
            System.out.println(user.getName() + " wins");
            winner = user.getName();
        }
    }


    /**
     * Gives both the user and computer two cards, finds their points, and prints them both
     */
    public void setupGame(){
        user.addCard(deck.deal());
        user.addCard(deck.deal());
        user.addPoint(user.getHand().get(0).getPoint());
        user.addPoint(user.getHand().get(1).getPoint());

        computer.addCard(deck.deal());
        computer.addCard(deck.deal());
        computer.addPoint(computer.getHand().get(0).getPoint());
        computer.addPoint(computer.getHand().get(1).getPoint());

        System.out.println(user);
        System.out.println(computer);
        window.repaint();
    }

    /**
     * Deals the player a card, updates their points, and prints out their new hand
     */
    public void drawCard(Player player){
      Card extra = deck.deal();
      player.addCard(extra);
      player.addPoint(extra.getPoint());

      System.out.println(player);
      window.repaint();
    }

    public Player getUser() {
        return user;
    }

    public Player getComputer() {
        return computer;
    }

    public String getWinner() {
        return winner;
    }

    /**
     * Initializes the game
     */
    public static void main(String[] args) {
        Game g = new Game();
        g.playGame();
    }
}

