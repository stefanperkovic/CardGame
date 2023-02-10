import javax.swing.*;
import java.awt.*;

public class BlackJackViewer extends JFrame {
    private final int WINDOW_WIDTH = 1400;
    private final int WINDOW_HEIGHT = 800;
    private Game game;
    private Image background;
    private Image backsideCard;

    public BlackJackViewer(Game game){
        this.game = game;
        background = new ImageIcon("Resources/background.jpeg").getImage();
        backsideCard = new ImageIcon("Resources/Cards/back.png").getImage();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("BlackJack");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

    public void paint(Graphics g) {
        g.drawString("Welcome to the game of Blackjack");
        "The goal is to have your cards add up as close to 21");
        "However if you exceed 21 you will bust");
        "You will start with two cards and draw more if you want");
        "You are against a computer who also wants to win");
        "The computer will draw a card when under 17 points");
        "Whoever is closer to 21 points will win")
        g.drawImage(background, 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, this);
        g.drawImage(backsideCard, 200, 400, 100, 200, this);
        if (game.getUser() != null){
            for (int i = 0; i < game.getUser().getHand().size(); i++){
                game.getUser().getHand().get(i).draw(g, i * 125, Game.playerCord);
            }
            for (int i = 0; i < game.getComputer().getHand().size(); i++){
                game.getComputer().getHand().get(i).draw(g, i * 125, game.computerCord);
            }
            g.setFont(new Font("Serif", Font.PLAIN, 25));
            g.drawString(game.getUser().getName(), 300, game.playerCord + 100);
            g.drawString(Integer.toString(game.getUser().getPoints()) + " points", 300, game.playerCord + 120);
            g.drawString("Computer", 300, game.computerCord + 100);
            g.drawString(Integer.toString(game.getComputer().getPoints()) + " points", 300, game.computerCord + 120);
        }

        if (game.getWinner() != null){
            g.setFont(new Font("Serif", Font.PLAIN, 75));
            g.drawString(game.getWinner() + " Wins!!!", 500, 500);
        }

    }









}
