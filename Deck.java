import java.util.*;

public class Deck {
    private ArrayList<Card> deck;
    private final static int NUM_CARDS_IN_DECK = 52;

    public Deck() {
        deck = new ArrayList<Card>(NUM_CARDS_IN_DECK);

        for (int i = 1; i <= 13; i++) {
            for (int j = 0; j <= 3; j++) {
                // i is card value, j is card suit
                Card card = new Card(i, j);
                deck.add(card);
            }
        }
        shuffle();
    }

    public int getNumCards() {
        return deck.size();
    }

    public void shuffle() {
        Random r = new Random();

        for (int i = 0; i < deck.size(); i++) {
            Card randomCard = deck.get(i);
            int randomNum = r.nextInt(deck.size());
            // set index i to random card in deck
            deck.set(i, deck.get(randomNum));
            deck.set(randomNum, randomCard);
        }
    }


    public Card dealCard() {
        return deck.remove(0);
    }

    public Card getCard(int n) {
        return deck.get(n);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Card card : deck) {
            sb.append(String.format("%s\n", card));
        }
        return sb.toString();
    }
}