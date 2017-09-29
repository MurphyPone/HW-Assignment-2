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
	
	//TODO CREATE ANOTHER CONSTRUCTOR TO ACCEPT A DIFF SIZE DECK
	//Need to populate with cards from pick....
	public Deck(Deck selection, int size) {
		this.myDeck = new Card[size]; //Creates an array with [size] slots
		
		//move each card from selection to array list, then draw from?
		
		for(int i = 0; i < size; i++) {
			myDeck[i] = pick(selection);
		}
		
		this.topCard = this.myDeck[myDeck.length-1];	//The top card is the last card
	}
	
	//Constructor helpers----------------------------------------
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
		Deck tempDeck = new Deck();	//Creates a temporary, sorted deck to draw from
		System.out.print("TECHDECK\n\n" + tempDeck.toString() + "\n\n");	//TODO remove this later yo
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
	
	//Shuffle	//TODO maybe not in compliance with assignment...
	public void shuffle() {
		Deck tempDeck = new Deck(false);	//Creates a temporary, shuffled deck to replace
		
		for(int i = 0; i < tempDeck.getDeck().length; i++) {	//Needs a separate loop so that tempArrL gets filled
			myDeck[i] = tempDeck.getDeck()[i];		//myDeck is filled with random pick from the shrinking tempArrL
		}
	}
	
	//Pick
	public Card pick(Deck d) {
		return d.getDeck()[(int) (Math.random() * d.getDeck().length) + 1]; //TODO Check if this is acceptable
	}
	
	//Deal
	public Deck[] deal(int numHands, int cardsPer) {//numHands, cardsPerHand
		Deck[] result = new Deck[numHands];
		
		//TODO does the order in which the cards are deakt matter?
		/*while (myDeck.length.length > 0) { //Have to have cards in the deck
			for(int i = 0; i < numHands; i++) {
				result[i] = new Deck(cardsPer); 
			}
		}*/
		
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
			if(!myDeck[i].equals(other.getDeck()[i])) 
				same = false;
		}
		return same;
	}
	
}
