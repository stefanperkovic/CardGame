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

    /**
     * Initializes the deck instance variable with 52 cards
     * Initializes both the user and computer instance variables
     * Gets the input of the name for the player
     */
    public Game() {
        String suits[] = {"Hearts", "Clubs" , "Diamonds", "Spades"};
        String ranks[] = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        int values[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        deck = new Deck(ranks, values, suits);
        Scanner input = new Scanner(System.in);
        System.out.print("What is your name: ");
        String name = input.nextLine();
        user = new Player(name);
        computer = new Player("Computer");
    }

    /**
     * Prints the Instructions that are fundamental to playing the game
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
     * Lets the user choose if they want to draw a card when under 21 points
     * The computer always will draw if it is under 17 points and never if it's over
     */
    public void playGame(){
        printInstructions();
        setupGame();
        Scanner input = new Scanner(System.in);
        /**
         * While the user has less than 21 points they have the option to draw more cards
         */
        while (user.getPoints() < 21){
            System.out.println("Hit or Stay?");
            /**
             * If the user chooses to draw they will get a card and then it checks if they have busted
             */
            if (input.nextLine().equals("Hit")){
                drawCard(user);
                if (checkBust() == true) {
                    return;
                }
                /**
                 * After the user draws a card the computer will draw one if points are less than 17
                 */
                if (computer.getPoints() < 17){
                    drawCard(computer);
                    if (checkBust() == true){
                        return;
                    }
                }
            }
            /**
             * If the user chooses not to draw then the computer will draw until it has over 17 points
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
     * Checks if either the computer or user has gone over 21 and is busted meaning the game is lost
     * Returns a bool of true if either has lost and false if the game should continue
     */
    public boolean checkBust(){
        if (user.getPoints() > 21){
            System.out.println("Computer Wins");
            return true;
        }
        else if (computer.getPoints() > 21){
            System.out.println(user.getName() + " Wins");
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
        }
        else if (computer.getPoints() == user.getPoints()){
            System.out.println("Its a tie");
        }
        else{
            System.out.println(user.getName() + " wins");
        }
    }


    /**
     * Gives both the user and computer two cards, finds their points, and prints them both
     */
    public void setupGame(){
        user.addCard(deck.deal());
        user.addCard(deck.deal());
        computer.addCard(deck.deal());
        computer.addCard(deck.deal());
        user.addPoint(user.getHand().get(0).getPoint());
        user.addPoint(user.getHand().get(1).getPoint());
        computer.addPoint(computer.getHand().get(0).getPoint());
        computer.addPoint(computer.getHand().get(1).getPoint());
        System.out.println(computer);
        System.out.println(user);
    }

    /**
     * Gives the player a card, updates their points, and prints out their new hand
     */
    public void drawCard(Player player){
      Card extra = deck.deal();
      player.addCard(extra);
      player.addPoint(extra.getPoint());
      System.out.println(player);
    }


    /**
     * Runs the playGame function which intializes the game
     */
    public static void main(String[] args) {
        Game g = new Game();
        g.playGame();
    }
}

