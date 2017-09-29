import java.util.Comparator;

public class CardComparator implements Comparator<Card> {

	@Override
	public int compare(Card o1, Card o2) {
		if(o1.getRank() > o2.getRank()) 
			return 1;
		else if (o1.getRank() < o2.getRank())
			return -1;
		else 
			return 0;
	}
	
	//Checks if suit AND value are ==
	public boolean equals(Object o1, Object o2) { 
		if(o1 instanceof Card && o2 instanceof Card)
			return ((Card) o1).getRank() == ((Card) o2).getRank() && ((Card) o2).getSuit() == ((Card) o2).getSuit(); 
		else 
			return false;	//Not an instanceof a card, so not equals
				
	}
}
