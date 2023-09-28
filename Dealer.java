public class Dealer {
    private Hand dealerHand;

    public Dealer() {
        dealerHand = new Hand();
        dealerHand.sortHand();
    }


    public void addCard() {
        dealerHand.addCardToHand();
    }

    public int getScore() {
        return dealerHand.getHandScore();
    }

    public Hand getHand() {
        return dealerHand;
    }

    public boolean hasBlackJack() {
        return dealerHand.getHandScore() == 21;
    }

    public String showTopCard() {
        String s = String.format("Dealers' Cards:\n%s |* * * * * *|\nScore: %d", dealerHand.getTopCard(), dealerHand.getTopCard().getValue());
        return s;
    }

    public String toString() {
        return String.format("Dealers' Cards:\n%s\nScore: %d", dealerHand, getScore());
    }
}
