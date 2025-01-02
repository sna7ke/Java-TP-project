import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		ArrayList<Player> players = new ArrayList<Player>();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("enter 4 players please : ");
		
		for(int i=0;i<4;i++) {
			players.add(new Player("PLAYER",i));
		}
		
		Game game = new Game(players);
		
		while (game.GetGameState()) {
			game.UpdateGame(scan);
		}
		System.out.println("GAME ENDED");
	}

}
