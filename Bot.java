package examtp;

import java.util.*;

public class Bot extends Player {

    public Bot(String playerName, int playerNumber) {
        super(playerName, playerNumber);
    }

    public Card playTurn(Card topCard, Game game) {
        ArrayList<Card> hand = getplayerHand();
        Card chosenCard = null;

        // Recherche d'une carte jouable
        for (Card card : hand) {
            if (card.IsCardPlayable(topCard)) {
                chosenCard = card;
                hand.remove(card); // Retirer la carte de la main du bot après l'avoir choisie
                break;
            }
        }

        if (chosenCard != null) {
            System.out.println(getplayerName() + " played: " + chosenCard);
            chosenCard.ApplyEffect(game, new Scanner(System.in));

            // Si c'est une carte spéciale (Wild Card ou Wild Draw Four)
            if (chosenCard instanceof WildCard || chosenCard instanceof WildDrawFourCard) {
                Card.Colour chosenColour = chooseRandomColour();
                chosenCard.SetColour(chosenColour);
                System.out.println(getplayerName() + " chose the color: " + chosenColour);

                // Si le bot a joué un Wild Draw Four, le joueur suivant doit tirer 4 cartes
                if (chosenCard instanceof WildDrawFourCard) {
                    game.DrawCards(4);
                }
            }

        } else {
            System.out.println(getplayerName() + " has no playable card and draws one.");
            game.ProcessInput(0, this); // Tire une carte du paquet
        }

        return chosenCard;
    }

    private Card.Colour chooseRandomColour() {
        Card.Colour[] colours = Card.Colour.values();
        Random random = new Random();
        return colours[random.nextInt(colours.length)];
    }
}
