
public class DeckTester {

	public static void main(String[] args) {
		
	//Card Testing
		Card badCard = new Card(3, -8 );		//This is the control for a bad creation
		System.out.println("Bad Card:" + badCard);
		
		Card one = new Card();					//1st Constructor (random)
		System.out.println("1: " + one);
		
		Card two = new Card(0, 4);				//2nd Constructor 
		System.out.println("2: " + two);
		
		Card three = new Card("Spades", "Jack");	//3rd Constructor 
		System.out.println("3: " + three);
		
		Card four = new Card("Diamonds", 7);		//4th Constructor 
		System.out.println("4: " + four);
		
		Card five = new Card(2, "Ace");			//5th Constructor 
		System.out.println("5: " + five);
		
		System.out.println("");
		
	//CardComparator Testing
		CardComparator comp = new CardComparator();
		System.out.println(one + " = " + one + " ... " + comp.equals(one, one) );
		System.out.println(one + " = " + two + " ... " + comp.equals(one, two) );
		System.out.println(one + " compared to " + two + " ... " + comp.compare(one, two) );
		
		System.out.println("");

		
	//Deck Testing
		Deck sorted = new Deck();
		Deck mixedDeal = new Deck(false);
		Deck smallDeck = new Deck(26);//This constructor creates an empty array
		Deck mergeMe = new Deck(false);
		
		System.out.print("SORTED\n\n" + sorted);
		System.out.print("MIXED\n\n" + mixedDeal);
		System.out.print("SMALL DECK\n\n" + smallDeck);
		System.out.print("MERGEME\n\n" + mergeMe);
		
		System.out.println("");

	//Deal Testing				
		Deck[] texasHoldEm = sorted.deal(5, 2);	
		for(int i = 0; i < texasHoldEm.length; i ++) 
			System.out.print("Hand[" + i + "] = " + texasHoldEm[i]);
		
		System.out.println("");

	//Sorting Testing
		System.out.print("BEFORE THE SORT: \n" + mergeMe.toString());
		mergeMe.mergeSort(mergeMe.getDeck()) ;
		System.out.print("\nAFTER THE SORT: \n" + mergeMe.toString());
		
	}
}
