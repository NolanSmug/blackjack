import java.util.Scanner;

public class Game {
    private String input = "";
    private int bet = 0;
    private int chips = 10000;

    public void playGame() {
        Scanner name = new Scanner(System.in);

        // ask for player and dealer name and make objects
        System.out.print("Enter player name: ");
        String username = name.nextLine();

        Scanner keyboard = new Scanner(System.in);

        // START TURN
        while (chips > 0) {
            Player player = new Player(chips, username);
            Dealer dealer = new Dealer();

            // asking user how much they want to bet
            boolean valid = false;
            System.out.printf("\nCurrent amount of chips: %d", player.getChips());
            while (!valid) {
                System.out.print("\nEnter number of chips to bet: ");

                bet = keyboard.nextInt();
                if (bet <= player.getChips() && bet > 0) {
                    player.removeChips(bet);
                    valid = true;
                } else {
                    System.out.print("\nInvalid number of chips");
                }
            }

            // printing cards
            System.out.println("\n" + dealer.showTopCard());
            System.out.println("\n" + player);

            // don't initially ask if either player or dealer has blackjack on first deal
            if (!player.hasBlackJack() && !dealer.hasBlackJack()) {
                System.out.println("\nType 'hit' to hit, or 'stay' to stay");
            }
            while (player.getScore() < 21 && !(input.equalsIgnoreCase("stay")) && !dealer.hasBlackJack()) {
                input = keyboard.nextLine();

                // if user hits
                if (input.equalsIgnoreCase("hit")) {
                    player.addCard();
                    System.out.println("\n" + player);
                    // don't ask again if player busts or has blackjack
                    if (!player.hasBlackJack() && player.getScore() < 21) {
                        System.out.println("\nType 'hit' to hit, or 'stay' to stay");
                    }
                }
            }

            // player blackjack
            if (player.hasBlackJack() && !dealer.hasBlackJack()) {
                wait(1000);
                System.out.printf("\nBLACKJACK!\n%s Wins!", player.getName());
                // calculate winnings and add it
                int winnings = bet + (bet * 3 / 2);
                player.addChips(winnings);
                wait(1000);
                System.out.printf("\nYou win %d chips!\nNew chip balance: %d\n", winnings, player.getChips());
            }

            // dealer blackjack
            else if (dealer.hasBlackJack() && !player.hasBlackJack()) {
                wait(1000);
                System.out.println("\n\nDealer has BLACKJACK!");
                System.out.println(dealer);
                wait(1000);
                System.out.printf("\n\nYou lost %d chips!\nNew chip balance: %d\n", bet, player.getChips());
            }

            // both have blackjack
            else if (player.hasBlackJack() && dealer.hasBlackJack()) {
                wait(1000);
                System.out.println("\nStand off (tie)");
                player.addChips(bet);
                wait(1000);
                System.out.printf("\n\nYou earned back your %d chips!\nCurrent chip balance: %d\n", bet, player.getChips());
            }

            // player busts
            else if (player.getScore() > 21) {
                System.out.println("\nBUST\nDealer Wins");
                wait(1000);
                System.out.printf("\n\nYou lost %d chips!\nNew chip balance: %d\n", bet, player.getChips());
            }

            // start dealers' turn
            else {
                System.out.println("\nPlayer turn over, it is now the dealer's turn\n");
                System.out.println(dealer);

                if (dealer.getScore() < 17) {
                    System.out.println("Dealer must hit until they have 17 or more\n");
                }
                wait(1000);

                while (dealer.getScore() < 17 && dealer.getScore() < player.getScore()) {
                    wait(2000);
                    System.out.println("\nDealer hits:");
                    dealer.addCard();
                    System.out.println(dealer);
                }

                // dealer busts, player wins twice bet back
                if (dealer.getScore() > 21) {
                    wait(1000);
                    System.out.println("\nDealer BUSTS\n");
                    int winnings = bet * 2;
                    player.addChips(winnings);
                    wait(1000);
                    System.out.printf("\n%s wins %d chips!\nNew chip balance: %d\n", player.getName(), winnings, player.getChips());
                } else if (dealer.getScore() < player.getScore()) {
                    int winnings = bet * 2;
                    player.addChips(winnings);
                    wait(1000);
                    System.out.printf("\n%s wins %d chips!\nNew chip balance: %d\n", player.getName(), winnings, player.getChips());
                } else if (dealer.hasBlackJack()) {
                    wait(1000);
                    System.out.println("\n\nDealer has BLACKJACK!");
                    wait(1000);
                    System.out.printf("\n\nYou lost %d chips!\nNew chip balance: %d\n", bet, player.getChips());
                } else if (dealer.getScore() > player.getScore()) {
                    wait(1000);
                    System.out.print("\nDealer WINS!");
                    wait(1000);
                    System.out.printf("\n\nYou lost %d chips!\nNew chip balance: %d\n", bet, player.getChips());
                } else {
                    wait(1000);
                    System.out.println("\nStand off (tie)");
                    player.addChips(bet);
                    wait(1000);
                    System.out.printf("\n\nYou earned back your %d chips!\nCurrent chip balance: %d\n", bet, player.getChips());
                }
            }
            chips = player.getChips();
            input = "";
            wait(1500);
            if (chips > 0) {
                System.out.print("\n\n*********************** NEW ROUND ***********************\n\n");
            }
        }

        System.out.print("\nYou ran out of chips. Come back later after your next paycheck!\n");
    }

    // wait function that takes in int for milliseconds to wait
    public static void wait(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
