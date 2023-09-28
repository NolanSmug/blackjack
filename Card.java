public class Card {
    public final static int JACK = 11;
    public final static int QUEEN = 12;
    public final static int KING = 13;
    public final static int ACE = 1;

    private int value;
    private int suit;

    public Card(int value, int suit) {
        this.value = value;
        this.suit = suit;
    }

    public int getValue() {
        if (value == 11 || value == 12 || value == 13)
            return 10;
        return value;
    }

    public int getSuit() {
        return suit;
    }

    public String suitToString() {
        if (suit == 0)
            return "Spades";
        else if (suit == 1)
            return "Hearts";
        else if (suit == 2)
            return "Diamonds";
        else if (suit == 3)
            return "Clubs";
        return null;
    }

    public String valueToString() {
        if (value == ACE)
            return "Ace";
        else if (value == 2)
            return "2";
        else if (value == 3)
            return "3";
        else if (value == 4)
            return "4";
        else if (value == 5)
            return "5";
        else if (value == 6)
            return "6";
        else if (value == 7)
            return "7";
        else if (value == 8)
            return "8";
        else if (value == 9)
            return "9";
        else if (value == 10)
            return "10";
        else if (value == JACK)
            return "Jack";
        else if (value == QUEEN)
            return "Queen";
        else if (value == KING)
            return "King";
        return null;
    }

    // returns true if card object is greater than other card object passed in
    public boolean greaterThan(Object otherCard) {
        Card cOther = (Card)otherCard;

        if (value == cOther.value) {
            return suit < cOther.suit;
        }
        return value > cOther.value;
    }

    @Override
    public String toString() {
        return String.format("|%s of %s|", valueToString(), suitToString());
    }
}