   
public class Deck {
	//Fields
	private Card[] myDeck; 
	private Card topCard;
	private boolean isSorted; //Worth keeping track of this state for the toString()?
	
	//Constructor Lite
	public Deck() {
		this.myDeck = new Card[52]; //Creates an array with room for 52 cards
		
		//TODO Obfuscate sorted/shuffled to their own methods... ugh
		sortedHelp();
		this.topCard = this.myDeck[myDeck.length-1];	//The top card is the last card
	}
	
	//Constructor Premium+
	public Deck(boolean notShuffled) {
		this.myDeck = new Card[52]; //Creates an array with 52 slots
		
		if(notShuffled)
			sortedHelp();
		else
			shuffledHelp();
		
		this.topCard = this.myDeck[myDeck.length-1];	//The top card is the last card
	}
	
	//Constructor helpers
	public void sortedHelp() {
		int s = 0;	//Suit counter
		while (s < 4 ) {		//Do 4x 
			for(int r = 2; r <= 14; r++) {	//r = rank value	//Should run 13x4 
				this.myDeck[(13*s)+r-2] = new Card(s, r);	//TODO easy way to convert r ????? -2? although [13x3+13] = 52... shouldn't get any IOB excpetion
			}
			s++;	//Go to next suit
		}
		this.isSorted = true;
	}
	
	public void shuffledHelp() {
		for(int i = 0; i < 52; i++ ) {	//Need 52 cards
			Card tryC = new Card();	//Creates a random card
			
			for(int c = 0; c < myDeck.length; c ++) {
				if( (myDeck[c] == null) || !(tryC.equals(myDeck[c]))  ) {	//TODO If they don't match or the value is null (empty)
					myDeck[c] = tryC;
				} else {
					tryC = new Card(); //If it matches any other cards, redefine it's value with new RNG
					c = 0; //reset the loop to re-check
				}
			}
		}
		
		this.isSorted = false;
	}
	
	//Getters
	public Card[] getDeck() {
		return myDeck;
	}
	//Shuffle
	public void shuffle() {
		//Cha cha real smooth
	}
	
	public String toString() {		//TODO Lookup format specifiers %12s or something
		String theShizzle = "";
		if(isSorted) {
			for(int i = 0; i < 13; i++) {
				theShizzle = theShizzle + myDeck[i].toString() + "\t\t" + myDeck[i+13].toString() + "\t\t" + myDeck[i+26].toString()
						+ "\t\t" + myDeck[i+39].toString() + "\n";
			}
		} else {	//Unsorted
			for(int i = 0; i < myDeck.length; i++ ) {	//The assignment only asks for 1 tab, but I'm putting 2 for readability			//This one doesn't i++ boost
				theShizzle = theShizzle + myDeck[i++].toString() + "\t\t" + myDeck[i++].toString() + "\t\t" + myDeck[i++].toString() 
						+ "\t\t" + myDeck[i].toString() + "\n";
			}
		}		
		return theShizzle;
	}
	
	//.equals
	public boolean equals(Deck other) {
		boolean same = true;
		for(int i = 0; i < myDeck.length; i++) {
			if(myDeck[i].equals(other.getDeck()[i])) 
				same = false;
		}
		return same;
	}
	
}
