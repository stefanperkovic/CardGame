import java.util.ArrayList;

/** Player.Java
 * Stefan Perkovic December 8 2022
 * The player class creates a player with a given name as well as a fluid amount of cards and points
 */
public class Player {
    private ArrayList<Card> hand = new ArrayList<>();
    private int points;
    private String name;

    /**
     * @param name of player
     */
    public Player(String name) {
        this.name = name;
        points = 0;
    }

    /**
     * @param hand dealt to player
     * @param name of player
     */
    public Player(ArrayList<Card> hand, String name) {
        this.hand = hand;
        this.name = name;
        points = 0;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public int getPoints() {
        return points;
    }

    public String getName() {
        return name;
    }

    /**
     * Adds points from the user to the points instance variable
     */
    public void addPoint(int points){
        this.points += points;
    }

    /**
     * Adds a card to the user hand
     */
    public void addCard(Card card){
        hand.add(card);
    }

    /**
     * Returns a string with the users name, hand, and points
     */
    public String toString() {
        return name + " has " + points + " points " +
                name + "'s cards: " + hand;
    }
}
