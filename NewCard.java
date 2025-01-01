abstract class NewCard {

	private String color;
	private String value;
	
	public NewCard(String color, String value) {
		this.color = color;
		this.value = value;
	}
	
	public String getColor() {
		return color;
	}
	
	public String getValue() {
		return value;
	}
	
	public String toString() {
		return (color != null ? color + " ": "") + value;
	}
	
	// public abstract void applyEffect(Game game);
	
	
}

abstract class SpecialCard extends NewCard{
	SpecialCard(String value){
		super(null,value);
	}
}

class WildCard2 extends SpecialCard{
	WildCard2(){
		super("Wild");
	}
	
	/* @Override
	 * public void appllyEffect(Game game){
	 *   ---------------------
	 * }
	 */
	
}

class WildDrawFourCard2 extends SpecialCard{
	WildDrawFourCard2(){
		super("Wild draw four");
	}
	
	/* @Override
	 * public void appllyEffect(Game game){
	 *   ---------------------
	 * }
	 */
}
abstract class ColoredCard extends NewCard{
	ColoredCard(String color, String value){
		super(color,value);
	}
}

class SkipCard2 extends ColoredCard{
	SkipCard2(String color){
		super(color,"Skip");
	}
	
	/* @Override
	 * public void appllyEffect(Game game){
	 *   ---------------------
	 * }
	 */
}
class ReverseCard2 extends ColoredCard{
	ReverseCard2(String color){
		super(color,"Reverse");
	}
	
	/* @Override
	 * public void appllyEffect(Game game){
	 *   ---------------------
	 * }
	 */
}
class DrawTwoCard2 extends ColoredCard{
	DrawTwoCard2(String color){
		super(color,"Draw two");
	}
	
	/* @Override
	 * public void appllyEffect(Game game){
	 *   ---------------------
	 * }
	 */
}

