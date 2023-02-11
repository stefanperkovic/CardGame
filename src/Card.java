/** Card.Java
 * Stefan Perkovic December 8 2022
 * Creates a Card with its given attributes of rank and suit as well as its point value in Blackjack
 */
import java.awt.*;
public class Card {
    private BlackJackViewer window;
    private String rank;
    private int point;
    private String suit;
    private Image card;
    public static final int cardWidth = 125;
    public static final int cardHeight = 200;

    /**
     * Initializes the card with attributes of rank, point, and suit
     */
    public Card(String rank, int point, String suit, Image card, BlackJackViewer window) {
        this.window = window;
        this.rank = rank;
        this.point = point;
        this.suit = suit;
        this.card = card;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public Image getCard() {
        return card;
    }

    public void setCard(Image card) {
        this.card = card;
    }

    public void draw(Graphics g, int x, int y){
        g.drawImage(card, x + 400 , y, cardWidth, cardHeight, window);
    }



    /**
     * Returns a string with the cards rank and suit
     */
    public String toString() {
        return rank + " + of " + suit;
    }
}