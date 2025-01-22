import java.util.*;
abstract class Card {
	
	 public enum Colour {
	        rouge("rouge"), blue("blue"), vert("vert"), jaune("jaune");

	        final private String nom;

	        private Colour(String nom) { 
	            this.nom = nom;
	        }

	        public String getNom() {
	            return nom;
	        }
	    }
	//private String color;
	private String value;
	private Colour couleur;
	
	public Card(Colour color, String value) {
		this.couleur = color;
		this.value = value;
	}
	
	public Card (Colour couleur) {
		this.couleur=couleur;
	}
	
	public Card(String value) {
		this.value=value;
	}
	
	abstract public boolean IsCardPlayable(Card TopCard);
	abstract void ApplyEffect(Game game,Scanner scan);
	
	public String getValue() {
		return value;
	}
	public Colour getColour() {
		return couleur;
	}
	
	public void SetColour(Colour couleur) {
		this.couleur = couleur;
	}
	 
	public String toString() {
		return (couleur != null ? couleur + " ": "") + value; //if the colour is null (which is the case for wild cards) we only write the value BUT after the wild cards get a colour it writes the colour
	}
	
	
}

abstract class SpecialCard extends Card{
	SpecialCard(String value){
		super(null,value);
	}
	
	@Override
	public boolean IsCardPlayable(Card TopCard) {
		return true;
	}
}

class WildCard extends SpecialCard{
	WildCard(){
		super("Wild");
	}
	WildCard(String value){
		super(value);
	}
	
	 @Override
	  public void ApplyEffect(Game game,Scanner scan){
	    System.out.println("choose a color : 1.rouge , 2.blue , 3.vert , 4.jaune");
	    int choice = scan.nextInt();
	    SetColour(Card.Colour.values()[choice-1]); //this sets the colour of the wild colour to the choice of the player
	    
	  }
}


class WildDrawFourCard extends WildCard{
	WildDrawFourCard(){
		super("wild draw four");
	}
	
	@Override
	public void ApplyEffect(Game game, Scanner scan) {
		super.ApplyEffect(game, scan);
		System.out.println("DRAW FOUR ");
		game.DrawCards(4);
	}
}



class ColoredCard extends Card{
	
	ColoredCard(Colour color, String value){
		super(color, value);
	}
	
	@Override
	public boolean IsCardPlayable(Card TopCard) {
		return (TopCard.getColour()==this.getColour() || TopCard.getValue()==this.getValue());
	}
	
	@Override
	public void ApplyEffect(Game game, Scanner scan) {
		//empty implementation because colored cards do nothing
	}
}

class SkipCard extends ColoredCard{
	SkipCard(Colour color){
		super(color,"Skip");
	}
	
	 @Override
	  public void ApplyEffect(Game game,Scanner scan){
	    System.out.println("SKIP");
	    game.UpdatePosition();
	  }
	 
}


class ReverseCard extends ColoredCard{
	ReverseCard(Colour color){
		super(color,"Reverse");
	}
	
	public void ApplyEffect(Game game,Scanner scan) {
		game.InvertDirection();
	}
}


class DrawTwoCard extends ColoredCard{
	DrawTwoCard(Colour color){
		super(color,"Draw two");
	}
	
	@Override
	public void ApplyEffect(Game game,Scanner scan) {
		System.out.println("DRAWN TWO");
		game.DrawCards(2);
	}
}

