import javax.swing.*;
import java.awt.*;

public class BlackJackViewer extends JFrame {
    private final int WINDOW_WIDTH = 1400;
    private final int WINDOW_HEIGHT = 800;
    private Game game;
    private Image background;
    private Image backsideCard;

    /**
     * Initializes the window and background images
     */
    public BlackJackViewer(Game game){
        this.game = game;
        background = new ImageIcon("Resources/background.jpeg").getImage();
        backsideCard = new ImageIcon("Resources/Cards/back.png").getImage();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("BlackJack");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

    /**
     * Draws the winner of the game
     */
    public void printWinner(Graphics g){
        if (game.getWinner() != null){
            g.setColor(Color.BLACK);
            g.setFont(new Font("Serif", Font.PLAIN, 75));
            if (game.getWinner().equals("Tie")){
                g.drawString("Its a Tie!", 500, 500);
            }
            g.drawString(game.getWinner() + " Wins!!!", 500, 500);
        }
    }

    /**
     * Draws all of the players cards
     */
    public void printHand(Player p, int y, Graphics g){
        for (int i = 0; i < p.getHand().size(); i++){
            p.getHand().get(i).draw(g, i * Card.cardWidth, y);
        }
    }



    /**
     * Draws instructions
     */
    public void drawInstructions(Graphics g){
        g.setColor(Color.WHITE);
        g.drawString("Welcome to the game of Blackjack", 1000, 100);
        g.drawString("The goal is to have your cards add up as close to 21", 1000, 115);
        g.drawString("However if you exceed 21 you will bust", 1000, 130);
        g.drawString("You will start with two cards and draw more if you want", 1000, 145);
        g.drawString("You are against a computer who also wants to win", 1000, 160);
        g.drawString("The computer will draw a card when under 17 points", 1000, 175);
        g.drawString("Whoever is closer to 21 points will win \n", 1000, 190);
    }

    /**
     * Draws the BlackJack board and updates each turn
     * @param g the specified Graphics window
     */
    public void paint(Graphics g) {
        g.drawImage(background, 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, this);
        g.drawImage(backsideCard, 200, 400, Card.cardWidth, Card.cardHeight, this);
        this.drawInstructions(g);
        if (game.getUser() != null){
            printHand(game.getUser(), game.playerCord, g);
            printHand(game.getComputer(), game.computerCord, g);
            g.setFont(new Font("Serif", Font.PLAIN, 25));
            g.drawString(game.getUser().getName(), 280, game.playerCord + 100);
            g.drawString(Integer.toString(game.getUser().getPoints()) + " points", 280, game.playerCord + 120);
            g.drawString("Computer", 295, game.computerCord + 100);
            g.drawString(Integer.toString(game.getComputer().getPoints()) + " points", 295, game.computerCord + 120);
        }
        this.printWinner(g);
    }
}
