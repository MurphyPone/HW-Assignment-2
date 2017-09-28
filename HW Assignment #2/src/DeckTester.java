
public class DeckTester {

	public static void main(String[] args) {
		
		//Card Testing
		Card aD = new Card("Diamonds", 14);	//Ace of Diamonds
		System.out.println(aD.toString() );
		
		Card twoH = new Card(2, 2);			//2 of Hearts
		System.out.println(twoH.toString() );
		
		Card threeC = new Card(3, -8 );		//This is the control for a bad creation
		System.out.println(threeC.toString() );
		
		Card rand = new Card();				//Random Card
		System.out.println(rand.toString() );
		
		//CardComparator Testing
		CardComparator comp = new CardComparator();
		System.out.println(comp.compare(aD, aD) );
		
		//Deck Testing
		Deck sorted = new Deck();
		//Deck mixed = new Deck(false);
	}
}
