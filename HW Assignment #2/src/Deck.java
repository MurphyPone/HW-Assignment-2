/**
 * Class Description: This class represents a deck of playing card and includes multiple methods emulating common card moves including:
 * 						1. Shuffling a deck of cards 
 * 						2. Picking a random card from a deck
 * 						3. Dealing several hands (smaller decks) 
 * 						
 * 					Other non traditional card manipulations include:
 * 						1. Selection sorting
 * 						2. Merge sorting
 * 						3. Array "collapsing"
 * 				
 * @author MurphyP1
 * @date 10/3/17
 */

import java.util.*;

public class Deck {
	//Fields
	private Card[] myDeck; //Array which stores individual Cards
	private int topCard;		//the index of the last non-null card within the deck
	private boolean isSorted; //No longer needed, but used for determining how to build the toString 
	private final int NUMCARDS = 52;	//No comment
	private static Card[] temp; //inefficient but necessary?
	
	/**
	 * The default constructor for a Deck object which creates a sorted deck of NUMCARDS Cards
	 * 
	 * @author MurphyP1
	 * @date 10/3/17
	 * @method Deck
	 */
	public Deck() {
		this.myDeck = new Card[NUMCARDS]; //Creates an array with room for NUMCARDS 
		sortedHelp();
		this.topCard = myDeck.length-1;	//The top card is the last card
	}
	
	/**
	 * A constructor which copies another Deck
	 * 
	 * @author MurphyP1
	 * @date 10/12/17
	 * @method Deck
	 * 
	 * @param d a Deck of Cards to copy 
	 */
	public Deck(Deck d) {
		this.myDeck = new Card[d.topCard+1];
		
		for(int i = 0; i <= d.topCard; i ++) 
			myDeck[i] = d.myDeck[i];
		
		this.topCard = myDeck.length-1;	//The top card is the last card
		this.isSorted = d.isSorted;
	}
	
	/**
	 * The premium constructor for a Deck object which creates a deck, sorted or unsorted, of NUMCARDS Cards
	 * 
	 * @author MurphyP1
	 * @date 10/3/17
	 * @method Deck
	 * 
	 * @param notShuffled a boolean value to determine whether or not the deck should be sorted
	 */
	public Deck(boolean notShuffled) {
		this.myDeck = new Card[NUMCARDS]; //Creates an array with 52 slots
		
		if(notShuffled)
			sortedHelp();
		else
			shuffledHelp();
		
		this.topCard = myDeck.length-1;	//The top card is the last card
	}
	
	/**
	 * The wimpy constructor for a Deck object which creates an empty deck, with room for a defined amount of Cards
	 * 
	 * @author MurphyP1
	 * @date 10/3/17
	 * @method Deck
	 * 
	 * @param numCards the size of the Deck 
	 */
	public Deck(int numCards) { 
		myDeck = new Card[numCards];
		this.topCard = myDeck.length-1;
		this.isSorted = false;
	}
	
	//Constructor helpers---------------------------------------------------------------------------------------------------------------------
	
	/**
	 * A method for adding Cards into the deck according to Suit and Rank hierarchy
	 * 
	 * @author MurphyP1
	 * @date 10/3/17
	 * @method sortedHelp
	 * 
	 * @return void
	 */
	public void sortedHelp() {
		int s = 0;	//Suit counter
		while (s < 4 ) {		//Do 4x 
			for(int r = 2; r <= 14; r++) {	//r = rank value	//Should run 13x4 
				this.myDeck[(13*s)+r-2] = new Card(s, r);
			}
			s++;	//Go to next suit
		}
		this.isSorted = true;
	}
	
	/**
	 * A method for adding Cards into the Deck in random order
	 * 
	 * @author MurphyP1
	 * @date 10/3/17
	 * @method shuffledHelp
	 * 
	 * @return void
	 */
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
	
	//Getters -------------------------------------------------------------------------------------------------------------------------------
	
	/**
	 * A method for fetching the array of Cards within a Deck
	 * 
	 * @author MurphyP1
	 * @date 10/3/17
	 * @method getDeck
	 * 
	 * @return Card[] the array of Cards, the principle part of the Deck
	 */
	public Card[] getDeck() {
		return myDeck;	//For accessing the cards
	}
	
	/**
	 * A method for fetching the topCard
	 * 
	 * @author MurphyP1
	 * @date 10/12/17
	 * @method getTopCard
	 * 
	 * @return an integer representing the topCard of the Deck
	 */
	public int getTopCard() {
		return topCard;	//For accessing the topCard
	}
	
	/**
	 * A method for rearranging the Cards within a Deck
	 * 
	 * @author MurphyP1
	 * @date 10/12/17
	 * @method shuffle
	 * 
	 * @return void
	 */
	public void shuffle() {
		for(int i = 0; i < topCard+1; i++) {	//Swaps cards topCard times
			Card temp = myDeck[i];
			int index = (int) (Math.random() * (topCard+1) );
			myDeck[i] = myDeck[index];
			myDeck[index] = temp;
		}
		isSorted = false;
	}
	
	/**
	 * A method for fetching a random Card from myDeck
	 * 
	 * @author MurphyP1
	 * @date 10/12/17
	 * @method pick
	 * 
	 * @param d a Deck of Cards to draw from
	 * 
	 * @return a random card from myDeck
	 */
	public Card pick() {	//Draws from myDeck 
		int index = (int) (Math.random() * (topCard+1) ) ;
		Card result = new Card(myDeck[index]);
		collapse(index);
		return result;
	}	
	
	/**
	 * A method for adjusting contents of a Deck for other interactions such as picking and dealing, but probably not good after shuffling
	 * 
	 * @author MurphyP1
	 * @date 10/12/17
	 * @method collapse
	 * 
	 * @param x the index of array of Cards to collapse from
	 * 
	 * @return void
	 */
	public void collapse(int x) {	//x = the card that has been picked
		if(x == topCard) {	//Dealt from the top card
			myDeck[topCard] = null;
			topCard--;
		} else {				//Randomly Picked card 
			for(int i = x; i < topCard; i++) { 
				myDeck[i] = myDeck[i+1];
			}
			myDeck[topCard] = null;
			topCard--;
		}
	}
	
	/**
	 * A method for creating smaller hands (Decks) from the master Deck
	 * 
	 * @author MurphyP1
	 * @date 10/3/17
	 * @method deal
	 * 
	 * @param numHands the number of new Decks to create
	 * @param cardsPer the number of Cards to be removed from the master Deck and added to each hand
	 * 
	 * @return an array of Decks (hands)
	 */
	public Deck[] deal(int numHands, int cardsPer) {
		if(numHands > 0 && cardsPer > 0) {
			Deck[] result = new Deck[numHands];
			for(int i = 0; i < numHands; i++ ) {
				result[i] = new Deck(cardsPer);	//Creates a new Deck
			}
		
			if( (numHands * cardsPer) <= topCard+1  ) {	//Checks to make sure that there are enough cards in the given deck
				for(int j = 0; j < cardsPer; j++) {	//Deals "clockwise"
					for(int i = 0; i < numHands; i++ ) {
						if(myDeck[topCard] != null) {
							result[i].myDeck[j] = new Card(myDeck[topCard]);	//Sets the value of the card to a copy of the card from the parent
							myDeck[topCard--] = null;			//Sets the topCard = null since it's been "removed"
						} //else topCard is null and something else is wrong
					}
				}
			} else {
				System.out.println("Invalid arguments");
				return null;
			}
			return result;
		} else {
			return null; 
		}
	}
	
	/**
	 * A method for printing the values of the individual Cards within a Deck whose ugliness can be attributed to "Good programming conventions"
	 * 
	 * @author MurphyP1
	 * @date 10/12/17
	 * @method toString
	 * 
	 * @return a String, of 4 sorted/unsorted columns if called by a full Deck, or one column if called by an abnormal sized Deck
	 */
	public String toString() {	
		String theShizzle = "";

		if(myDeck.length == NUMCARDS) { //Full Deck = 52 (duh)
			if(isSorted) {
				for(int i = 0; i < NUMCARDS/4; i++) {
					theShizzle = theShizzle + myDeck[i].toString() + "\t\t" + myDeck[i+NUMCARDS/4].toString() 
							+ "\t\t" + myDeck[i+(NUMCARDS/2)].toString() + "\t\t" + 
							myDeck[i+(3*(NUMCARDS/4))].toString() + "\n";
				}
			} else {	//Unsorted	
				for(int i = 0; i < myDeck.length; i++ ) {	//The assignment only asks for 1 tab, but I'm putting 2 for readability			
					theShizzle = theShizzle + myDeck[i++].toString() + "\t\t" + myDeck[i++].toString() + "\t\t" + myDeck[i++].toString() 
							+ "\t\t" + myDeck[i].toString() + "\n";	//Last card doesn't i++ boost
				}
			}		
		} else {		//Any # of Cards
			for(int i = 0; i < topCard+1; i++ )
				if(myDeck[i] != null )
					theShizzle = theShizzle + getDeck()[i].toString() + "\n";
		}
		return theShizzle;
	}
	
	/**
	 * A method for comparing Decks of Cards according to the individual cards within each
	 * 
	 * @author MurphyP1
	 * @date 10/12/17
	 * @method equals
	 * 
	 * @return true if all the cards in each are identical 
	 */
	public boolean equals(Deck other) {
		boolean same = true;
		
		if(topCard == other.topCard) {
			Deck copy = new Deck(other); //Copy other
			copy.mergeSort(); //mergeSort the copy, then use copy for comparison --order does not define equality
		
			//If they're the same size, do further investigating
			for(int i = 0; i <= topCard; i++) {
				if(!myDeck[i].equals(copy.getDeck()[i])) //Compares individual Cards
					same = false;
			}
			return same;
		}else return false;
	}
	//G A D Z O O K S  Searching and sorting time------------------------------------------------------------
	
	/**
	 * A method for sorting a Decks linearly
	 * 
	 * @author MurphyP1
	 * @date 10/12/17
	 * @method selectionSort
	 * 
	 * @return void
	 */
	public void selectionSort() {	
	  // Sorts a[0], ..., a[a.length-1] in ascending order using Selection Sort.
	    for (int n = myDeck.length; n > 1; n--) {		//Iterates backwards, stops before the last (first) element bc it should be in place by then
	    		// Find the index iMax of the largest element among a[0], ..., a[n-1]:
		    	int iMax = 0;			//"Biggest" element is the first --no competition :p
		    	for (int i = 1; i < n; i++) {
		    		if (myDeck[i].compareTo(myDeck[iMax]) == 1 ) { //Both the rank and suit are greater than the current iMax
		    			iMax = i;	//If greater, then new high score
		    		}
	
		    		// Swap a[iMax] with a[n-1]:
	
		    		Card cardTemp = myDeck[iMax];
		    		myDeck[iMax] = myDeck[n-1];
		    		myDeck[n-1] = cardTemp;
	
		     	// Decrement n (accomplished by n-- in the for loop).
		    	}
		}
	    isSorted = true;
	}
	
	//MERGE ------------------------------------------------------------
	
    /**
	 * A method for adjusting setting up calls to recursiveSort to sort Decks all speedy-like
	 * 
	 * @author MurphyP1
	 * @date 10/12/17
	 * @method mergeSort
	 * 
	 * @param a an array of Cards 
	 * 
	 * @return void
	 */
    void mergeSort() {	// sorts a[0],..., a[a.length-1] in ascending order
    		int n = topCard;
    		temp = new Card[n];//Replace with myDeck?
    		recursiveSort(0, n-1);
    		isSorted = true;
    }
    
    /**
	 * A recursive method which compares, creates, and merges subdivided arrays
	 * 
	 * @author MurphyP1
	 * @date 10/12/17
	 * @method recursiveSort
	 * 
	 * @param a an array of Cards 
	 * @param from an integer which marks the starting index of an array
	 * @param to an integer which marks the ending index of an array
	 * 
	 * @return void
	 */
    void recursiveSort(int from, int to) {	//Recursive helper: a[from]...a[to]
	    	if(to-from < 2) {	//Base case for 1 or 2 elements
	    		if(from < to && myDeck[to].compareTo(myDeck[from]) == -1) {	//Checks to make sure the two indices have not passed, and compares two cards for a swap
	    			Card aTemp = myDeck[to]; //Swap a[to] and a[from]
	    			myDeck[to] = myDeck[from];
	    			myDeck[from] = aTemp;
	    		}
	    } else { //recursive case
    			int middle = (from + to) / 2;
    			recursiveSort(from, middle);
    			recursiveSort(middle + 1, to);
    			merge(from, middle, to);
	    }	
    } 
	 
    /**
	 * A helper method for comparing and combining subdivided arrays of Cards 
	 * 
	 * @author MurphyP1
	 * @date 10/12/17
	 * @method merge
	 * 
	 * @param a an array of Cards
	 * @param from an integer representing the index of the left bound of the  deck
	 * @param middle an integer representing the index of the middle of the deck
	 * @param to and integer representing the index of the right bound of the deck
	 * 
	 * @return void
	 */
    void merge(int from, int middle, int to ) {		//merges a[from]...a[middle] and a[middle]...a[to]
	    	int i = from;
	    	int j = middle + 1;
	    int	k = from;
	    
	    while( i <= middle && j <= to) {	//While both arrays have elements left unprocessed:
	    		if(myDeck[i].compareTo(myDeck[j]) == -1 ) { 
	    			temp[k] = myDeck[i++];
	    		} else {
	    			temp[k] = myDeck[j++];
	    		}
	    		k++;
	    }
	    
	    while(i <= middle) {	//Copy the tail of the fist half, if any, into temp:
		    	temp[k++] = myDeck[i++];
	    }
	    
	    while(j<= to) {	//Copy tail of second half, if any, into temp:
		    	temp[k++] = myDeck[j++];
	    }
	    
	    for(k = from; k <= to; k++) {	//Copy temp back to a[]
	    		myDeck[k] = temp[k];
	    }
    }
}
