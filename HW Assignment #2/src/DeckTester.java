
public class DeckTester {

	public static void main(String[] args) {
		Card aD = new Card("Diamonds", 14);	//Ace of Diamonds
		System.out.println(aD.toString() );
		
		Card twoH = new Card(2, 2);			//2 of Hearts
		System.out.println(twoH.toString() );
		
		Card rand = new Card();				//Random Card
		System.out.println(rand.toString() );
		
		

	}

}
