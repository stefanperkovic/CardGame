/** Deck.Java
 * Stefan Perkovic December 7 2022
 */

import java.util.ArrayList;

public class Deck {
    private ArrayList<Card> cards;
    private int cardsLeft;

    public Deck(String[] ranks, int[] point, String[] suits) {
        cards = new ArrayList<>();
        for (int i = 0; i < suits.length; i++){
            for (int j = 0; j < ranks.length; j++) {
                if (j > 9){
                    Card c = new Card(ranks[j], point[9], suits[i]);
                    cards.add(c);
                }
                else{
                    Card c = new Card(ranks[j], point[j], suits[i]);
                    cards.add(c);
                }

            }
        }
        cardsLeft = cards.size();
        shuffle();
    }

    public boolean isEmpty(){
        if(cardsLeft == 0){
            return true;
        }
        return false;
    }

    public int getCardsLeft() {
        return cardsLeft;
    }

    public Card deal(){
        if (this.isEmpty()){
            return null;
        }
        cardsLeft --;
        return cards.get(cardsLeft);
    }
    public void shuffle(){
        for (int i = cards.size() - 1; i >= 0; i--){
            int index =(int) Math.random() * cards.size();
            Card holder = cards.get(index);
            cards.set(index, cards.get(i));
            cards.set(i, holder);
        }
    }
}
