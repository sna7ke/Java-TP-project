package unogame;
import java.util.ArrayList;
public class Player {

	private ArrayList<Card> playerHand ; // every player has a list of cards stocked in an ArrayList 
	private boolean playerTurn;          // true if it's the player's turn, false otherwise
	
	private String playerName ;  // player name
	private int playerNumber ; // player hand
	
	public Player() {
		playerHand = new ArrayList<>(); // initialise the cards player in a list 
	}
	
	public Player(ArrayList<Card> playerHand,boolean playerTurn,String playerName,int playerNumber) {
		this.playerHand = playerHand ;
		this.playerTurn = playerTurn;
		this.playerName = playerName;
		this.playerNumber = playerNumber;
	}
	
	//getters
	public String getplayerName() {
		return this.playerName;
	}
	
	public int getplayerNumber() {
		return this.playerNumber;
	}
	
	public ArrayList<Card> getplayerHand(){
		return this.playerHand;
	}
	
	public boolean getplayerTurn() {
		return this.playerTurn;
	}
	
	// methodes
	
	public void playerDraw(ArrayList<Card> deck) { //  draw Card From Deck
	    if (!deck.isEmpty()) {
	        Card drawnCard = deck.remove(deck.size() - 1); // Draw the last card from the deck (-1 ? start by 0)
	        playerHand.add(0,drawnCard); // Adds the card to the front of the list (is good to complexity )
	    }
	}
	
	public void playCard(Card card) { //when the player play a card we should remove it from the player hand list
		playerHand.remove(card);
	}
	
	public void showHand() { // show all the cards in player hand
		System.out.println("player name is :" + this.playerName + " Hand = " + this.playerHand);
	}
	

	@Override
	public String toString() {
		
		return super.toString() + "player name is :" + this.playerName + " Hand = " + this.playerHand;
	}
	
	public void switchTurn() { // call this procedure for the player who has skiped & for the player who must play 
	    this.playerTurn = !this.playerTurn; // if the player has skiped (Turn = false) and for the player you must play (Turn = true )
	}
	
	public boolean playerWon() {
		if (playerHand.isEmpty()) // Player wins if hand is empty
			return true;
	    else 
		    return false;
    }
	
	
	public int numberOfCards() { // in case of the palyer can't play and there is no cards in deck (all the cards are in the palyers hand ) 
		return playerHand.size(); // Return the number of cards in the player's hand (player who has less number of card win)
	}
	
	
}
