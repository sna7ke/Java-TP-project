package unogame;

public class Card {

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

	    private Colour couleur;
	    private int valeur;

	    public Card(Colour couleur, int valeur) {
	        this.couleur = couleur;
	        this.valeur = valeur;
	    }
	    
	    public Card(Colour couleur) {
	     this.couleur = couleur;
	     this.valeur = -1;
	    }

	    public Colour getCouleur() {
	        return couleur;
	    }
	    

	    @Override
	    public String toString() {
	     if(valeur != -1) {
	       return "Card: " + couleur.getNom() + " " + valeur;
	     } else {
	             return "Card: " + (couleur != null ? couleur.getNom() : "card");
	    }
	    }
	}

	class SkipCard extends Card {

	 
	    public SkipCard(Colour couleur) {
	        super(couleur);
	    }

	    public void skipCard() {
	        System.out.println("Passe ton tour");
	    }

	    @Override
	    public String toString() {
	        return super.toString() + " - Passe ton tour";
	    }
	}

	class ReverseCard extends Card {
	 
	    public ReverseCard(Colour couleur) {
	        super(couleur);
	    }

	    public void reverseCard() {
	        System.out.println("Inverser le sens du jeu");
	    }

	    @Override
	    public String toString() {
	        return super.toString() + " - Inverser";
	    }
	}

	class DrawTwoCard extends Card {
	 
	    public DrawTwoCard(Colour couleur) {
	        super(couleur);
	    }

	    public void drawTwoCard() {
	        System.out.println("L'adversaire pioche 2 cartes");
	    }

	    @Override
	    public String toString() {
	        return super.toString() + " - Plus 2";
	    }
	}

	class WildCard extends Card {
	 
	    public WildCard() {
	        super(null); 
	    }

	    public void wildCard() {
	        System.out.println("Choisissez une nouvelle couleur");
	    }

	    @Override
	    public String toString() {
	        return "Carte Joker - Choisissez une couleur"; 
	    }
	}

	class WildDrawFourCard extends Card {
	    public WildDrawFourCard() {
	        super(null); 
	    }

	    public void wildDrawFourCard() {
	        System.out.println("Choisissez une nouvelle couleur et l'adversaire pioche 4 cartes");
	    }

	    @Override
	    public String toString() {
	        return "Carte Joker +4 - Choisissez une couleur";
	    }
	}