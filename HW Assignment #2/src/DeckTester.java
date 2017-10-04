
public class DeckTester {

	public static void main(String[] args) {
		
	//Card Testing
		/*Card badCard = new Card(3, -8 );		//This is the control for a bad creation
		System.out.println("Bad Card:" + badCard);
		
		Card one = new Card();					//1st Constructor (random)
		System.out.println("1: " + one);
		
		Card two = new Card(0, 4);				//2nd Constructor 
		System.out.println("2: " + two);
		
		Card three = new Card("Clubs", "Ace");	//3rd Constructor 
		System.out.println("3: " + three);
		
		Card four = new Card("Diamonds", 7);		//4th Constructor 
		System.out.println("4: " + four);
		
		Card five = new Card(2, "Ace");			//5th Constructor 
		System.out.println("5: " + five);
	*/
		
		
		/*//CardComparator Testing
		CardComparator comp = new CardComparator();
		System.out.println(comp.equals(aD, aD) );
		*/
		
		//Deck Testing
		Deck sorted = new Deck();
		Deck mixedDeal = new Deck(false);
		Deck forMerge = new Deck(false);
		
		//Deal Testing				
		Deck[] texasHoldEm = mixedDeal.deal(5, 2);	//Issue with printing decks that aren't %4==0 
		Deck[] stud = mixedDeal.deal(4, 5);
		
		System.out.print("BEFORE THE SORT: \n" + forMerge.toString());
		forMerge.mergeSort(forMerge.getDeck()) ;
		System.out.print("\nAFTER THE SORT: \n" + forMerge.toString());

	}
}
