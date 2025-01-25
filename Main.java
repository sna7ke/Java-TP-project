import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		ArrayList<Player> players = new ArrayList<Player>();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("how many players do you want in your game?");
		int NumOfPlayers;
		String name;
		
		do {
		NumOfPlayers = scan.nextInt();
		}while(NumOfPlayers<=0 || NumOfPlayers>5);//maximum number of players is 5 
		
		for(int i=0;i<NumOfPlayers;i++) {
			System.out.println("enter the player " + Integer.toString(i+1) + "'s name");
			name = scan.next();
			players.add(new Player(name,i));
		}
		
		Game game = new Game(players);
		
		boolean Play = true;
		
		while (Play) {
			
		while (game.GetGameState()) {
			game.UpdateGame(scan);
		}
		System.out.println("GAME ENDED");
		
		System.out.println("Do you want to replay ? 1. YES , 2. NO");
		
		int choice = scan.nextInt();
		if (choice !=1) {
			Play = false;
		}
		
		
		}
		
	}

}
