
public class DeckTester {

	public static void main(String[] args) {
		
		//Card Testing
		/*Card aD = new Card("Diamonds", 14);	//Ace of Diamonds
		System.out.println(aD.toString() );
		
		Card twoH = new Card(2, 2);			//2 of Hearts
		System.out.println(twoH.toString() );
		
		Card threeC = new Card(3, -8 );		//This is the control for a bad creation
		System.out.println(threeC.toString() );
		
		Card rand = new Card();				//Random Card
		System.out.println(rand.toString() );
		*/
		
		/*//CardComparator Testing
		CardComparator comp = new CardComparator();
		System.out.println(comp.equals(aD, aD) );
		*/
		
		//Deck Testing
		Deck sorted = new Deck();
		Deck mixedDeal = new Deck(false);
		Deck mixed = new Deck(false);

		System.out.println(sorted);
		
		//Deal Testing				
		Deck[] texasHoldEm = mixedDeal.deal(5, 2);	//Issue with printing decks that aren't %4==0 
		Deck[] stud = mixedDeal.deal(4, 5);
		
		System.out.print("BEFORE THE SORT: \n" + mixed.toString());
		mixed.selectionSort();
		System.out.print("\nAFTER THE SORT: \n" + mixed.toString());

	}
}
