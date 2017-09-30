import java.util.ArrayList;

public class Deck {
	//Fields
	private Card[] myDeck; 
	private Card topCard;
	private boolean isSorted; //Worth keeping track of this state for the toString()?
	
	//Constructor Lite
	public Deck() {
		this.myDeck = new Card[52]; //Creates an array with room for 52 cards
		
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
	
	//Need to populate with cards from pick....
	public Deck(Card[] selection, int size) {
		this.myDeck = new Card[size]; //Creates an array with [size] slots
		
		ArrayList<Card> tempArrL = new ArrayList<Card>();
		
		for(int i = 0; i < selection.length; i++) {		//Moves cards from selection to an ArrayList
			tempArrL.add(selection[i]);	
		}
		
		for(int i = 0; i < size; i++) {
			Card selectedCard = pick(selection);	//pickedCard var
			myDeck[i] = selectedCard;		//Puts selected card into new deck
			//TODO TODO TODO TODO REMOVE selectedCard from myDeck and Collapse myDeck accordingly 
		}
				
		this.topCard = this.myDeck[myDeck.length-1];	//The top card is the last card
	}
	
	//Constructor helpers----------------------------------------
	public void sortedHelp() {
		int s = 0;	//Suit counter
		while (s < 4 ) {		//Do 4x 
			for(int r = 2; r <= 14; r++) {	//r = rank value	//Should run 13x4 
				this.myDeck[(13*s)+r-2] = new Card(s, r);	//easy way to convert r ????? -2? although [13x3+13] = 52... shouldn't get any IOB excpetion
			}
			s++;	//Go to next suit
		}
		this.isSorted = true;
	}
	
	public void shuffledHelp() {
		Deck tempDeck = new Deck();	//Creates a temporary, sorted deck to draw from
		ArrayList<Card> tempArrL = new ArrayList<Card>();
	
		for(int i = 0; i < tempDeck.getDeck().length; i++) {
			tempArrL.add(tempDeck.getDeck()[i]);				//Inserts each of the cards into an arraylist for ez pickins
		}
		
		for(int i = 0; i < tempDeck.getDeck().length; i++) {	//Needs a separate loop so that tempArrL gets filled
			int r = (int) (Math.random() * tempArrL.size());	//Gets a random valid index of tempArrL
			myDeck[i] = tempArrL.get(r);		//myDeck is filled with random pick from the shrinking tempArrL
			tempArrL.remove(r);		//Removes that card from the tempArrL
		}
		
		this.isSorted = false;
	}
	
	//Getters
	public Card[] getDeck() {
		return myDeck;	//For accessing the the cards
	}
	//a getCard method would be smart....
	
	//Shuffle
	public void shuffle() {
		Deck tempDeck = new Deck(false);	//Creates a temporary, shuffled deck to replace
		
		for(int i = 0; i < tempDeck.getDeck().length; i++) {	//Needs a separate loop so that tempArrL gets filled
			myDeck[i] = tempDeck.getDeck()[i];		//myDeck is filled with random pick from the shrinking tempArrL
		}
	}
	
	//Pick
	public Card pick(Card[] d) {
		//WHEN SHOULD I COLLAPSE??? IN PICK, IN THE CONSTRUCTOR FOR HANDS, OR IN THETESTER...
		return d[(int) (Math.random() * d.length) + 1]; 	//!!Issue with +1?
	}
	
	//Collapse
	public Card[] collapse(Card[] given, int x) {
		Card[] result = new Card[given.length-1]; //Creates a sorted[I NEED IT TO BE EMPTY) array 1 card smaller than the given
		//How to get the index of the removed card if it's a random # contained within pick? use .equals()!?
		for(int i = 0; i < x; i ++) {
			result[i] = given[i];	//Copies all the cards up to the xth card 
		}
		for(int i = x+1; i < given.length; i++) { //Skips the given[x]th card which is being "removed"
			result[i] = given[i];	//Copies all the cards after the xth card
		}
		return result;
	}
	
	//Deal
	public Deck[] deal(int numHands, int cardsPer) {//numHands, cardsPerHand
		Deck[] result = new Deck[numHands];
		
		//TODO does the order in which the cards are dealt matter?
		if( (numHands * cardsPer) < myDeck.length ) {	//Checks to make sure that there are enough cards in the given deck
			//while (myDeck.length > 0) { //Have to have cards in the deck	
				for(int i = 0; i < numHands; i++) {
					result[i] = new Deck(myDeck, cardsPer); //Does not remove cards from selection...
				//}
			} 
		} else 
			System.out.println("That's too many cards hombre!!!");
		return result;
	}
	
	//toString
	public String toString() {		//TODO Lookup format specifiers %12s or something
		String theShizzle = "";
		if(isSorted) {
			for(int i = 0; i < 13; i++) {
				theShizzle = theShizzle + myDeck[i].toString() + "\t\t" + myDeck[i+13].toString() + "\t\t" + myDeck[i+26].toString()
						+ "\t\t" + myDeck[i+39].toString() + "\n";
			}
		} else {	//Unsorted	//TODO ISSUE, WHAT IF I ONLY HAVE 2 CARDS PER "DECK" LIKE IN HOLD'EM
			for(int i = 0; i < myDeck.length; i++ ) {	//The assignment only asks for 1 tab, but I'm putting 2 for readability			
				theShizzle = theShizzle + myDeck[i++].toString() + "\t\t" + myDeck[i++].toString() + "\t\t" + myDeck[i++].toString() 
						+ "\t\t" + myDeck[i].toString() + "\n";	//Last card doesn't i++ boost
			}
		}		
		return theShizzle;
	}
	
	//.equals
	public boolean equals(Deck other) {
		boolean same = true;
		for(int i = 0; i < myDeck.length; i++) {
			if(!myDeck[i].equals(other.getDeck()[i])) 
				same = false;
		}
		return same;
	}
	
}
