
public class Card {
package examtp;

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

    public Card(Colour couleur) {
        this.couleur = couleur;
    }

    public Colour getCouleur() {
        return couleur;
    }

    @Override
    public String toString() {
        return "Card: " + (couleur != null ? couleur.getNom() : "wild");
    }
}

}
