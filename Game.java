import java.util.ArrayList;
import java.util.Scanner;
public class Game {
	
	//defining the node class which is going to represent a player on a bidirectional list
	private class Node {
		private Player player;
		Node next;
		Node prev;
		
		public Node (Player player) {
			this.player= player;
			this.next=null;
			this.prev=null;
		}
	}
	//defining the circular linked list which is going to have methods to handle the turns of the players
	private class CircularLinkedList{
		private Node head;
		//private Node tail;
		
		public CircularLinkedList() {
			head=null;
			//tail=null;
		}
		
		public void AddPlayerToList(Player player) {
			
			Node NewNode = new Node(player);
			if(head==null) {
				head=NewNode;
				NewNode.next=head;
				NewNode.prev=head;
			}
			else {	
				Node temp = head.prev;
				temp.next=NewNode;
				NewNode.prev=temp;
				NewNode.next=head;
				head.prev=NewNode;
			}
		}
		public void MoveTurnRight() {
			head=head.next;
		}
		public void MoveTurnLeft() {
			head=head.prev;
		}
		//getter
		public Player GetCurrentPlayer() {
			return head.player;
		}
	}
	
	private CircularLinkedList list;
	private Deck CardDeck;
	private boolean TurnDirection;
	private boolean GameState;
	private Card DiscardPile;
	
	public Game (ArrayList<Player> players) {
		
		CardDeck = new Deck();
		CardDeck.ShuffleDeck();
		
		list = new CircularLinkedList();
		
		for(Player player : players) {
			
			//we give each player 5 cards at the start
			for(int i=0;i<5;i++) {
				player.playerDraw(CardDeck);
			}
			
			list.AddPlayerToList(player);
		}
		TurnDirection =true;
		GameState = true;
	}
	
	//a method to show the current player
	public Player DisplayCurrentPlayer() {
		Player player=list.GetCurrentPlayer();
		//System.out.println(player);
		player.showHand();
		return player;
	}
	
	public Card ProcessInput(int Index,Player player) {		
		return player.PlayCard(Index);
	}
	
	public void UpdatePosition() {
		if(TurnDirection) {
		list.MoveTurnRight();
		}
		else {
			list.MoveTurnLeft();
		}
	}
	private void UpdateGameState() {
		Player player =list.GetCurrentPlayer();
		if (player.playerWon() || CardDeck.IsDeckEmpty()) {
			GameState = false;
		}
		else {
			GameState= true;
		}
	}
	public void UpdateGame(Scanner scan) {
		Player CurrentPlayer = DisplayCurrentPlayer();
		int index;
		Card PlayedCard;
		System.out.println("choose a card");
		
		do {
		index = scan.nextInt();
		PlayedCard = ProcessInput(index, CurrentPlayer);
		
		}while(PlayedCard==null);
		
		DiscardPile = PlayedCard;
		UpdateGameState();
		UpdatePosition();
		System.out.println(DiscardPile);
	}
	public boolean GetGameState() {
		return GameState;
	}
}
