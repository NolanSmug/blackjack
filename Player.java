public class Player {
    private String playerName;
    private Hand playerHand;

    private int chips;
    private final static int MAX_CHIPS = 10000;

    public Player(String name) {
        this.playerName = name;
        this.playerHand = new Hand();
        chips = MAX_CHIPS;
    }

    public Player(int numChips, String name) {
        playerHand = new Hand();
        playerName = name;
        chips = numChips;
    }

    public void addCard() {
        playerHand.addCardToHand();
    }

    public void removeChips(int n) {
        chips -= n;
    }

    public void addChips(int n) {
        chips += n;
    }

    public int getChips() {
        return chips;
    }


    public boolean hasBlackJack() {
        return playerHand.getHandScore() == 21;
    }

    public int getScore() {
        return playerHand.getHandScore();
    }


    public String getName() {
        return playerName;
    }


    public String toString() {
        return String.format("%s's Cards:\n%s\nScore: %d", playerName, playerHand, getScore());
    }
}
