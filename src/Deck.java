/** Deck.Java
 * Stefan Perkovic December 8 2022
 * Creates a deck of cards specific to the game you want to create
 * You can shuffle and deal from this deck
 */

import java.util.ArrayList;

public class Deck {
    private ArrayList<Card> cards;
    private int cardsLeft;

    /**
     * Takes in the ranks, points, and suits for all cards that will make up the deck
     * Goes through and makes 52 cards with their ranks, suits and point value
     */
    public Deck(String[] ranks, int[] point, String[] suits) {
        cards = new ArrayList<>();
        /**
         * Makes 52 cards based on the suits and rank as well as the point value it represents
         */
        for (int i = 0; i < suits.length; i++){
            for (int j = 0; j < ranks.length; j++) {
                /**
                 * When j is over 9 it is a face card meaning that the point value should be 10
                 * Preventing a index out of bounds error by stopping at the last point value
                 */
                if (j > 9){
                    Card c = new Card(ranks[j], point[9], suits[i]);
                    /**
                     * Using card.add() displays my ability to use ArrayList methods
                     */
                    cards.add(c);
                }
                else{
                    Card c = new Card(ranks[j], point[j], suits[i]);
                    cards.add(c);
                }

            }
        }
        /**
         * Using cards.size() displays my ability to use ArrayList methods
         */
        cardsLeft = cards.size();
        shuffle();
    }

    /**
     * Checks if the number of cards left or not yet deal is zero
     * Returns true if so and false otherwise
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
     * Returns a card to the user if there are any remaining if not return null
     * Decreases the amount of cards left due to one being dealt
     */
    public Card deal(){
        if (this.isEmpty()){
            return null;
        }
        cardsLeft --;
        /**
         * Using cards.get() displays my ability to use ArrayList Methods
         */
        return cards.get(cardsLeft);
    }

    /**
     * Shuffles the deck of cards by nesting through the deck
     * Starts from the back and then switches the current card with another random one
     * This ultimately leaves the entire deck completely shuffled
     */
    public void shuffle(){
        int length = cards.size();
        for (int i = length - 1; i >= 0; i--){
            int index =(int) (Math.random() * length);
            Card holder = cards.get(index);
            /**
             * Using card.set() displays my ability to use ArrayLit Methods
             */
            cards.set(index, cards.get(i));
            cards.set(i, holder);
        }
    }
}
