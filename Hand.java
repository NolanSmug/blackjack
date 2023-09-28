import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> hand;
    private Deck deck;

    public Hand() {
        deck = new Deck();
        hand = new ArrayList<Card>();

        hand.add(deck.dealCard());
        hand.add(deck.dealCard());
    }

    public void addCardToHand() {
        hand.add(deck.dealCard());
    }

    public void sortHand() {
        Card card1 = hand.get(0);
        Card card2 = hand.get(1);

        if (card1.greaterThan(card2)) {
            hand.clear();
            hand.add(card2);
            hand.add(card1);
        }
    }

    public int getHandScore() {
        int sum = 0;
        boolean hasAce = false;

        for (Card card : hand) {
            if (card.getValue() == Card.ACE) {
                hasAce = true;
            }
            sum += card.getValue();
        }
        if (hasAce && sum <= 11) {
            sum += 10;
        }
        return sum;
    }

    public Card getTopCard() {
        return hand.get(0);
    }

    @Override
    public String toString() {
        String s = "";

        for (Card card : hand) {
            s += String.format("%s  ", card);
        }
        return s;
    }
}
