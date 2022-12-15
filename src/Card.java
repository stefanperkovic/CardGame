/** Card.Java
 * Stefan Perkovic December 8 2022
 * Creates a Card with its given attributes of rank and suit as well as its point value in Blackjack
 */
public class Card {
    private String rank;
    private int point;
    private String suit;

    /**
     * Constructor initializes the card with the given attributes of rank, point, and suit
     */
    public Card(String rank, int point, String suit) {
        this.rank = rank;
        this.point = point;
        this.suit = suit;
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

    /**
     * Returns a string with the description of the card in terms of its rank and suit
     */
    public String toString() {
        return rank + " + of " + suit;
    }
}