
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {

 protected List<Card> cards; 
 
 Deck(){
  cards = new ArrayList<>();
  initializeDeck(); // the deck is initialized as soon as it's instantiated
 }
 
 public void initializeDeck() {
  
  for(Card.Colour color : Card.Colour.values()) { // for every card colour in the card colour values (color is an index color(1)=red .....)
   // add number cards for each color
   for(int i=0; i<=9; i++) {
    cards.add(new ColoredCard(color,Integer.toString(i))); // add one card for each color and value   
    if(i!=0) {
     cards.add(new ColoredCard(color,Integer.toString(i))); // add a second card for values 1 to 9
    }
   }
  }
  
  // add two special cards for each color and type
  for(Card.Colour color : Card.Colour.values()) {
   for(int i=0; i<2; i++) {
    cards.add(new SkipCard(color));    
    cards.add(new ReverseCard(color));
    cards.add(new DrawTwoCard(color));
   }
  }
  
  // add wild cards
  for (int i = 0; i < 4; i++) {
         cards.add(new WildCard());
         cards.add(new WildDrawFourCard());
     }  
 }   
 Random random = new Random();
 
 public void ShuffleDeck() {
  for(int i=0; i< cards.size(); i++) {
   int j = i + random.nextInt(cards.size() - i); // j is random index selected from the interval [i - cards.size() - 1]
   
   // swapping the card from index i with the card from index j 
   Card temp = cards.get(i);
   cards.set(i, cards.get(j));
   cards.set(j, temp);
  }
 }
 
 public boolean IsDeckEmpty() {
	 return cards.isEmpty();
 }
 
 public Card DrawCard() {
  if(cards.isEmpty()) {
   System.out.println("the deck is empty");
  }
  return cards.remove(0); // return the card at index 0 (the top card) and removing it from the deck
 }
 
 
 public void ResetDeck() {
  cards.clear(); // clear the deck if there are cards left
  // resetting the deck and shuffling it
  initializeDeck();
  ShuffleDeck();
 }
 public void displayDeck() {
  for(Card card : cards) {
   System.out.println(card); // for each card from the deck display the cards
  }
 }
}

class DiscardPile extends Deck{
	
	public DiscardPile() {
		super(); // calls the parent constructor to initalize the deck (the pile)
		clearPile(); // the discard pile starts empty
	}
	
	private void clearPile() {
		while(!IsDeckEmpty()) {
			DrawCard(); // clear discard pile by drawing all the cards without returning them to anything
		}
	}
	
	public Card getTopCard() {
		if(IsDeckEmpty()) {
			System.out.println("discard pile is empty ! ");
		}
		else {
			return cards.get(0); // return the top card of the discard pile
		}
		return null;
	}
	
	public void displayPile() {
		if(IsDeckEmpty()) {
			System.out.println("discard pile is empty ! ");
		}
		else {
			// display discard pile as a stack
			System.out.println(" Discard Pile ");
			System.out.println("--------------");
			for(int i=0; i< cards.size(); i++) {
				System.out.println((i + 1) + ": " + cards.get(i));
			}
		}
	}

    public void addCard(Card card) {
		cards.add(0, card); // add the card to the top of the pile
	}
}
