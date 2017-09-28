import java.util.Comparator;

public class CardComparator implements Comparator<Card> {
	
	public int compareTo(Card o1, Card o2) {
		if(o1.getRank() > o2.getRank() ) { return 1; }	
		else if (o1.getRank() < o2.getRank() ) {return -1; }
		else if (o1.equals(o2)) {return 0;}
		else { return (Integer) null;}		//SAME ISSUE WHY CAST INT?
	}
	
	public boolean equals(Card o1, Card o2) { return o1.getRank() == o2.getRank(); }

	@Override
	public int compare(Card o1, Card o2) { return o1.getRank() - o2.getRank(); }

}
