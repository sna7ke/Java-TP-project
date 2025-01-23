package examtp;

import java.util.*;

public class Bot extends Player {

    public Bot(String playerName, int playerNumber) {
        super(playerName, playerNumber);
    }

    public Card playTurn(Card topCard, Game game) {
        ArrayList<Card> hand = getplayerHand();
        Card chosenCard = null;

        for (Card card : hand) {
            if (card.IsCardPlayable(topCard)) {
                chosenCard = card;
                hand.remove(card);
                break;
            }
        }

        if (chosenCard != null) {
            System.out.println(getplayerName() + " played: " + chosenCard);
            chosenCard.ApplyEffect(game, new Scanner(System.in));

            if (chosenCard instanceof WildCard) {
                Card.Colour chosenColour = chooseRandomColour();
                chosenCard.SetColour(chosenColour);
                System.out.println(getplayerName() + " chose the color: " + chosenColour);
            }
        } else {
            System.out.println(getplayerName() + " has no playable card and draws one.");
            
        }

        return chosenCard;
    }

    private Card.Colour chooseRandomColour() {
        Card.Colour[] colours = Card.Colour.values();
        Random random = new Random();
        return colours[random.nextInt(colours.length)];
    }
}
