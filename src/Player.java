import java.util.ArrayList;

/** Deck.Java
 * Stefan Perkovic December 7 2022
 */
public class Player {
    private ArrayList<Card> hand = new ArrayList<>();
    private int points;
    private String name;


    public Player(String name) {
        this.name = name;
        points = 0;
    }

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

    public void addPoint(int points){
        this.points += points;
    }

    public void addCard(Card card){
        hand.add(card);
    }

    @Override
    public String toString() {
        return name + " has " + points + " points" +
                name + "'s cards: " + hand;
    }
}
