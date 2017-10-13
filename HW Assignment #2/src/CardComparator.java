/**
 * Class Description: This class handles rank comparisons between two Cards
 * 				
 * @author MurphyP1
 * @date 10/3/17
 */

import java.util.Comparator;

public class CardComparator implements Comparator<Card> {

	/**
	 * Compares two Cards' ranks 
	 * 
	 * @author MurphyP1
	 * @date 10/12/17
	 * @method compare
	 * 
	 * @return an integer representing the difference between two cards
	 */
	@Override
	public int compare(Card o1, Card o2) {
		if( o1.getSuitInt()  == o2.getSuitInt()) {
			if(o1.getRank() > o2.getRank() ) { return 1; } 
			else if( o1.getRank() < o2.getRank()) {return -1; }
			else { return 0;}
		} 
		
		if( o1.getSuitInt()  > o2.getSuitInt()) {
			return 1;
		} else {
			return -1;
		}
	}
	
	
	/**
	 * checks if two Cards are of equal ranks and value
	 * 
	 * @author MurphyP1
	 * @date 10/3/17
	 * @method equals
	 * 
	 * @return true if both the rank and suit of each card are identical
	 */
	public boolean equals(Object o1, Object o2) { 	//Checks if suit AND value are ==
		if(o1 instanceof Card && o2 instanceof Card)
			return ((Card) o1).getRank() == ((Card) o2).getRank() && ((Card) o2).getSuit() == ((Card) o2).getSuit(); 
		else 
			return false;	//Not an instanceof a card, so not equals
				
	}
}
