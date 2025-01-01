import java.util.ArrayList;
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
	
	public Game (ArrayList<Player> players) {
		
		list = new CircularLinkedList();
		
		for(Player player : players) {
			list.AddPlayerToList(player);
		}
		TurnDirection =true;
	}
	
	//a method to show the current player
	public void DisplayCurrentPlayer() {
		Player player=list.GetCurrentPlayer();
		System.out.println(player);
	}
	public void UpdatePosition() {
		if(TurnDirection) {
		list.MoveTurnRight();
		}
		else {
			list.MoveTurnLeft();
		}
	}
	

}
