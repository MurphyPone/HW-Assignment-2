import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class DeckTester {

	public static void main(String[] args) {
		
	//Creates a PrintWriter for outputting 
		File file = new File("Output.txt");
		PrintWriter output = null;

		try {	//Check to see if the requested file exists/can be opened
			output = new PrintWriter(file);	//If so, create a new PrintWriter to modify the contents of the file
		} catch (FileNotFoundException ex) {	//Should not be necessary to include some error output to file bc the PrintWriter should not get created if the file does not exist
			System.out.println("Failed to be able to write to Output.txt bc of " + ex.toString());
		}
		
	//Card Testing
		output.println("------------CARD TESTING------------");

		Card badCard = new Card(3, -8 );		//This is the control for a bad creation
		output.println("Bad Card:" + badCard);
		
		Card one = new Card();					//1st Constructor (random)
		output.println("1: " + one);
		
		Card two = new Card(0, 4);				//2nd Constructor 
		output.println("2: " + two);
		
		Card three = new Card("Spades", "Jack");	//3rd Constructor 
		output.println("3: " + three);
		
		Card four = new Card("Diamonds", 7);		//4th Constructor 
		output.println("4: " + four);
		
		Card five = new Card(2, "Ace");			//5th Constructor 
		output.println("5: " + five);
		
		output.println("");
		
	//CardComparator Testing
		output.println("------------COMPARATOR TESTING------------");

		CardComparator comp = new CardComparator();
		output.println(one + " = " + one + " ... " + comp.equals(one, one) );
		output.println(one + " = " + two + " ... " + comp.equals(one, two) );
		output.println(one + " compared to " + two + " ... " + comp.compare(one, two) );
		
		output.println("");

		
	//Deck Testing
		output.println("------------DECK TESTING------------");
		
		Deck sorted = new Deck();
		Deck mixedDeal = new Deck(false);
		Deck smallDeck = new Deck(26);//This constructor creates an empty array
		Deck mergeMe = new Deck(false);
		
		output.print("SORTED\n\n" + sorted);
		output.print("MIXED\n\n" + mixedDeal);
		output.print("SMALL DECK\n\n" + smallDeck);
		output.print("MERGEME\n\n" + mergeMe);
		
		output.println("");

	//Deal Testing		
		output.println("------------DEAL TESTING------------");

		Deck[] texasHoldEm = sorted.deal(5, 2);	
		for(int i = 0; i < texasHoldEm.length; i ++) 	//TODO Error here bc hold has no length
			output.print("Hand[" + i + "] = " + texasHoldEm[i]);
		
		output.println("");
	//Pick and Shuffle Testing
		output.println("------------PICK AND SHUFFLE TESTING------------");
		
		texasHoldEm[0].shuffle();
		output.println("post Shuffle on holdEm[0] : " + texasHoldEm[0]);

		output.println("Pick from holdEm[0] : " + texasHoldEm[0].pick()); 
		output.println("AFTER PICKING from holdEm[0] : " +texasHoldEm[0]);
		
	//Sorting Testing
		output.print("BEFORE THE SORT: \n" + mergeMe.toString());
		mergeMe.mergeSort(mergeMe.getDeck()) ;
		output.print("\nAFTER THE SORT: \n" + mergeMe.toString());
		
	//Housekeeping
		output.close();
		
	}
}
