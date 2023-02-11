/** Deck.Java
 * Stefan Perkovic December 8 2022
 * Creates a deck of cards specific to the game you want to create
 * You can shuffle and deal from this deck
 */
import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

public class Deck {
    private ArrayList<Card> cards;
    private int cardsLeft;
    private BlackJackViewer window;

    /**
     * Takes in the ranks, suits, and points to make 52 cards for the deck and give itself an image
     */
    public Deck(String[] ranks, int[] point, String[] suits, BlackJackViewer window) {
        cards = new ArrayList<>();
        this.window = window;
        for (int i = 0; i < suits.length; i++){
            for (int j = 0; j < ranks.length; j++) {
                int location = (i + 1) + (j * 4);
                String loc = Integer.toString(location);
                Image card = new ImageIcon("Resources/Cards/" + loc + ".png").getImage();
                /**
                 * If j is over 9 it is a face card with point value 10
                 */
                if (j > 9){
                    Card c = new Card(ranks[j], point[9], suits[i], card, window);
                    cards.add(c);
                }
                else{
                    Card c = new Card(ranks[j], point[j], suits[i], card, window);
                    cards.add(c);
                }

            }
        }
        cardsLeft = cards.size();
        shuffle();
    }

    /**
     * Checks if any cards remain in deck
     */
    public boolean isEmpty(){
        if(cardsLeft == 0){
            return true;
        }
        return false;
    }

    public int getCardsLeft() {
        return cardsLeft;
    }

    /**
     * Deals a card to the user if none remain returns null
     */
    public Card deal(){
        if (this.isEmpty()){
            return null;
        }
        cardsLeft --;
        return cards.get(cardsLeft);
    }

    /**
     * Shuffles the deck of cards by nesting through the deck
     */
    public void shuffle(){
        int length = cards.size();
        for (int i = length - 1; i >= 0; i--){
            int index =(int) (Math.random() * i);
            Card holder = cards.get(index);
            cards.set(index, cards.get(i));
            cards.set(i, holder);
        }
    }
}
