
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class DeckTester {

	public static void main(String[] args) {

		File file = new File("Output.txt");
		PrintWriter output = null;

		try {	
			output = new PrintWriter(file);	
		} catch (FileNotFoundException ex) {}
		  
		Card tComp1 = new Card(0, 2);
		Card tComp2 = new Card(2, 3);
		
		CardComparator compy = new CardComparator();
		
		output.println("=============Comparator test=============");
		output.println(tComp1);
		output.println("Should be greater than:");
		output.println(tComp2);
		output.println("The results");
		output.println(compy.compare(tComp1, tComp2));
		output.println();
		output.println("key: 1 = 1st greater than 2nd");
		output.println("     0 = they equal");
		output.println("    -1 = 1st less than 2nd");
		output.println();
		output.println();
		Deck breakThisCode = new Deck(false);
		output.println("-------Pick Method Test-------");
		output.println("Initial Deck");
		output.println(breakThisCode);
		output.println();
		output.println("This is the card that was dealt from the Deck:");
		output.println(breakThisCode.pick(breakThisCode.getDeck()));
		output.println("Now it should be missing from the deck because it was pulled out");
		output.println("Results:");
		output.println(breakThisCode);
		output.println();
		output.println();
		
		
		output.println("-------Deal Method Test-------");
		output.println("Initial Deck");
		output.println(breakThisCode);
		output.println();
		output.println("Now We ask it to deal out -2 hands with 3 cards in each");
		output.println("Results:");
		try {
			breakThisCode.deal(-2, 3);
		} catch (NegativeArraySizeException e) {
			output.println("NegativeArraySizeException "+ e.getMessage());
		}
		output.println();
		output.println();

		
		
		
             
		output.close();
		
	}
}
