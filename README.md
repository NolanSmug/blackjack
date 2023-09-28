# Blackjack

This Java program simulates a simple game of Blackjack. It consists of several classes:

## Card

The `Card` class represents a standard playing card. It has methods to get the value, suit, and string representation of a card.

- `getValue()`: Returns the value of the card.
- `getSuit()`: Returns the suit of the card.
- `suitToString()`: Returns the suit of the card as a string.
- `valueToString()`: Returns the value of the card as a string.
- `greaterThan(Object otherCard)`: Compares this card to another card and returns `true` if this card is greater.

## Hand

The `Hand` class represents a player's hand in the game.

- `addCardToHand()`: Adds a card to the hand.
- `sortHand()`: Sorts the hand.
- `getHandScore()`: Returns the score of the hand.
- `getTopCard()`: Returns the top card of the hand.
- `toString()`: Returns a string representation of the hand.

## Deck

The `Deck` class represents a standard deck of playing cards.

- `getNumCards()`: Returns the number of cards in the deck.
- `shuffle()`: Shuffles the deck.
- `dealCard()`: Deals a card from the deck.
- `getCard(int n)`: Returns the card at index `n` in the deck.
- `toString()`: Returns a string representation of the deck.

## Player

The `Player` class represents a player in the game.

- `addCard()`: Adds a card to the player's hand.
- `removeChips(int n)`: Removes `n` chips from the player's balance.
- `addChips(int n)`: Adds `n` chips to the player's balance.
- `getChips()`: Returns the player's chip balance.
- `hasBlackJack()`: Boolean for if the player has Blackjack.
- `getScore()`: Returns the score of the player's hand.
- `getName()`: Returns the player's name.
- `toString()`: Returns a string representation of the player.

## Dealer

The `Dealer` class manages the dealer's hand in the game.

- `addCard()`: Adds a card to the dealer's hand.
- `getScore()`: Returns the score of the dealer's hand.
- `getHand()`: Returns the dealer's hand.
- `hasBlackJack()`: Boolean for if the dealer has Blackjack.
- `showTopCard()`: Returns a string representation of the dealer's top card.
- `toString()`: Returns a string representation of the dealer's hand.

## Game

The `Game` class manages the overall flow of the game.

- `playGame()`: Starts and manages logic in the game of Blackjack.
> Note: Some rules such as splitting and doubling down are not implemented in my version of Blackjack. Logic for advanced rules will be added soon.

## Driver

The `Driver` class contains the main method to start the game.

## How to Play

1. Run the `Driver` class to start the game.
2. Enter the player's name when prompted.
3. Place a bet using the provided instructions.
4. Follow the prompts to play the game.
5. The game will continue until the player runs out of chips.

## Future Implementations

- **Error Handling**:
   Add robust error handling to handle unexpected inputs from users.

- **Multiplayer Support**:
   Extend the game to support multiple players, allowing them to take turns.

- **Advanced Rules**:
   Some examples:
      - Insurance bets
      - Surrendering
      - Doubling down
      - Splitting
      - Five Card Charlie

- **Stat Tracking**:
   Keep track of statistics such as win/loss ratio, total chips won/lost, etc.

- **Save/Load Game**:
   Implement functionality to save a game in progress and resume it later.

## Contact

For any inquiries or issues, please contact [Nolan Cyr](mailto:nolangcyr@gmail.com). Have fun playing!
