import java.util.Comparator;

public class CardComparator implements Comparator<Card> {

	@Override
	public int compare(Card o1, Card o2) {
		if(o1.getRank() > o2.getRank()) 
			return 1;
		else if (o1.getRank() < o2.getRank())
			return -1;
		else if(o1.getRank() == o2.getRank())
			return 0;
		return (Integer) null;	//if you get -8 it's bad
	}
	
	public boolean equals(Object o1, Object o2) { return ((Card) o1).getRank() == ((Card) o2).getRank(); }
		
	/*public int compareTo(Card o1, Card o2) {
		if(o1.getRank() > o2.getRank() ) { return 1; }	
		else if (o1.getRank() < o2.getRank() ) {return -1; }
		else if (o1.equals(o2)) {return 0;}
		else { return (Integer) null;}		//TODO SAME ISSUE WHY CAST INT?
	}

	@Override
	public int compare(Card o1, Card o2) { return (o1.getRank() - o2.getRank(); }
	*/
	
	
}
