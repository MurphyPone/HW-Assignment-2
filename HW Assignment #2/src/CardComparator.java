import java.util.Comparator;

public class CardComparator implements Comparator<Object> {	//<Object?>
	
	public int compareTo(Object o1, Object o2) {
		Card c1 = (Card) o1;
		Card c2 = (Card) o2;
		
		if(c1.getRank() > c2.getRank() ) { return 1; }	
		else if (c1.getRank() < c2.getRank() ) {return -1; }
		else if (c1.equals(c2)) {return 0;}
		else { return (Integer) null;}		//TODO SAME ISSUE WHY CAST INT?
	}

	@Override
	public int compare(Object o1, Object o2) { return ((Card) o1).getRank() - ((Card) o2).getRank(); }
	
	public boolean equals(Object o1, Object o2) { return ((Card) o1).getRank() == ((Card) o2).getRank(); }
}
