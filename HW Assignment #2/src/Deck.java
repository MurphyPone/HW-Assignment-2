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
	private final int THENUMBEROFCARDSWHICHAPPEARINATRADITIONALDECKOFCARDS = 52;	//There is no reason for this variable to exist 
	private static Card[] temp; //inefficient but necessary?
	
	/**
	 * The default constructor for a Deck object which creates a sorted deck of 52 Cards
	 * 
	 * @author MurphyP1
	 * @date 10/3/17
	 * @method Deck
	 * 
	 */
	public Deck() {
		this.myDeck = new Card[THENUMBEROFCARDSWHICHAPPEARINATRADITIONALDECKOFCARDS]; //Creates an array with room for 52 cards
		sortedHelp();
		this.topCard = myDeck.length-1;	//The top card is the last card
	}
	
	/**
	 * The premium constructor for a Deck object which creates a deck, sorted or unsorted, of 52 Cards
	 * 
	 * @author MurphyP1
	 * @date 10/3/17
	 * @method Deck
	 * 
	 * @param notShuffled a boolean value to determine whether or not the deck should be sorted
	 * 
	 */
	public Deck(boolean notShuffled) {
		this.myDeck = new Card[THENUMBEROFCARDSWHICHAPPEARINATRADITIONALDECKOFCARDS]; //Creates an array with 52 slots
		
		if(notShuffled)
			sortedHelp();
		else
			shuffledHelp();
		
		this.topCard = myDeck.length-1;	//The top card is the last card
	}
	
	/**
	 * The wimpy constructor for a Deck object which creates an empty deck, with room for a variable amount of Cards
	 * 
	 * @author MurphyP1
	 * @date 10/3/17
	 * @method Deck
	 * 
	 * @param numCards the size of the Deck 
	 * 
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
				this.myDeck[(13*s)+r-2] = new Card(s, r);	//easy way to convert r ????? -2? although [13x3+13] = 52... shouldn't get any IOB excpetion
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
		return myDeck;	//For accessing the the cards
	}
	
	/**
	 * A method for rearranging the Cards within a Deck
	 * 
	 * @author MurphyP1
	 * @date 10/3/17
	 * @method shuffle
	 * 
	 * @return void
	 */
	public void shuffle() {
		Deck tempDeck = new Deck(false);	//Creates a temporary, shuffled deck to replace
		
		for(int i = 0; i < myDeck.length; i++) {	//Needs a separate loop so that tempArrL gets filled
			myDeck[i] = tempDeck.getDeck()[i];		//myDeck is filled with random pick from the shrinking tempArrL
			tempDeck.collapse(i);				//Removes selected card from tempDeck so that It can't be added twice
		}
		isSorted = false;
	}
	
	/**
	 * A method for fetching a random Card within a given Deck of Cards
	 * 
	 * @author MurphyP1
	 * @date 10/3/17
	 * @method pick
	 * 
	 * @param d a Deck of Cards to draw from
	 * 
	 * @return a random card from the given array of Cards
	 */
	public Card pick(Deck d) {
		int index = (int) (Math.random() * d.getDeck().length) + 1;
		Card result = new Card(d.getDeck()[index]);
		d.collapse(index);
		return result;
	}	
	
	/**
	 * A method for adjusting contents of a Deck for other interactions such as picking and dealing, but probably not good after shuffling
	 * 
	 * @author MurphyP1
	 * @date 10/3/17
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
		} else {				//Randomly Picked card --might not even be needed..
			for(int i = x; i < topCard-1; i++) { 
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
		if(numHands > 0 && cardsPer >0) {
			Deck[] result = new Deck[numHands];
			for(int i = 0; i < numHands; i++ ) {
				result[i] = new Deck(cardsPer);	//Creates a new Deck
			}
		
			if( (numHands * cardsPer) <= myDeck.length  ) {	//Checks to make sure that there are enough cards in the given deck
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
	 * @date 10/3/17
	 * @method toString
	 * 
	 * @return a String, of 4 sorted/unsorted columns if called by a full Deck, or one column if called by an abnormal sized Deck
	 */
	public String toString() {	
		String theShizzle = "";

		if(myDeck.length == THENUMBEROFCARDSWHICHAPPEARINATRADITIONALDECKOFCARDS) { //Full Deck = 52 (duh)
			if(isSorted) {
				for(int i = 0; i < THENUMBEROFCARDSWHICHAPPEARINATRADITIONALDECKOFCARDS/4; i++) {
					theShizzle = theShizzle + myDeck[i].toString() + "\t\t" + myDeck[i+THENUMBEROFCARDSWHICHAPPEARINATRADITIONALDECKOFCARDS/4].toString() 
							+ "\t\t" + myDeck[i+(THENUMBEROFCARDSWHICHAPPEARINATRADITIONALDECKOFCARDS/2)].toString() + "\t\t" + 
							myDeck[i+(THENUMBEROFCARDSWHICHAPPEARINATRADITIONALDECKOFCARDS/2)+
							       (THENUMBEROFCARDSWHICHAPPEARINATRADITIONALDECKOFCARDS/4)].toString() + "\n";
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
	 * @date 10/3/17
	 * @method equals
	 * 
	 * @return true if all the cards in each are identical 
	 */
	public boolean equals(Deck other) {
		boolean same = true;
		if(myDeck.length == other.getDeck().length) {	//If they're the same size, do further investigating
			for(int i = 0; i < myDeck.length; i++) {
				if(!myDeck[i].equals(other.getDeck()[i])) //Compares individual Cards
					same = false;
			}
			return same;
		}else return false;
	}
	//G A D Z O O K S  Searching and sorting time------------------------------------------------------------
	/* SIGNIFICANT HELP FROM TEXTBOOK */
	
	/**
	 * A method for sorting a Decks linearly
	 * 
	 * @author MurphyP1
	 * @date 10/3/17
	 * @method selectionSort
	 * 
	 * @return void
	 */
	public void selectionSort() {	//TODO this thing TODO learn it
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
	}
	
	//MERGE ------------------------------------------------------------
	
    /**
	 * A method for adjusting setting up calls to recursiveSort to sort Decks all speedy-like
	 * 
	 * @author MurphyP1
	 * @date 10/3/17
	 * @method mergeSort
	 * 
	 * @param a an array of Cards 
	 * 
	 * @return void
	 */
    void mergeSort(Card[] a ) {	// sorts a[0],..., a[a.length-1] in ascending order
    		int n = a.length;
    		temp = new Card[n];//Replace with myDeck?
    		recursiveSort(a, 0, n-1);
    		isSorted = true;
    }
    
    /**
	 * A recursive method which compares, creates, and merges subdivided arrays
	 * 
	 * @author MurphyP1
	 * @date 10/3/17
	 * @method recursiveSort
	 * 
	 * @param a an array of Cards 
	 * @param from an integer which marks the starting index of an array
	 * @param to an integer which marks the ending index of an array
	 * 
	 * @return void
	 */
    void recursiveSort(Card[] a, int from, int to) {	//Recursive helper: a[from]...a[to]
	    	if(to-from < 2) {	//Base case for 1 or 2 elements
	    		if(from < to && a[to].compareTo(a[from]) == -1) {	//Checks to make sure the two indices have not passed, and compares two cards for a swap
	    			Card aTemp = a[to]; //Swap a[to] and a[from]
	    			a[to] = a[from];
	    			a[from] = aTemp;
	    		}
	    } else { //recursive case
    			int middle = (from + to) / 2;
    			recursiveSort(a, from, middle);
    			recursiveSort(a, middle + 1, to);
    			merge(a,from, middle, to);
	    }	
    } 
	 
    /**
	 * A helper method for comparing and combining subdivided arrays of Cards 
	 * 
	 * @author MurphyP1
	 * @date 10/3/17
	 * @method merge
	 * 
	 * @param a an array of Cards
	 * @param from an integer representing the index of the left bound of the  deck
	 * @param middle an integer representing the index of the middle of the deck
	 * @param to and integer representing the index of the right bound of the deck
	 * 
	 * @return void
	 */
    void merge(Card[] a, int from, int middle, int to ) {		//merges a[from]...a[middle] and a[middle]...a[to]
	    	int i = from;
	    	int j = middle + 1;
	    int	k = from;
	    
	    while( i <= middle && j <= to) {	//While both arrays have elements left unprocessed:
	    		if(a[i].compareTo(a[j]) == -1 ) { 
	    			temp[k] = a[i++];	//WHAT IS TEMP
	    		} else {
	    			temp[k] = a[j++];
	    		}
	    		k++;
	    }
	    
	    while(i <= middle) {	//Copy the tail of the fist half, if any, into temp:
		    	temp[k++] = a[i++];
	    }
	    
	    while(j<= to) {	//Copy tail of second hald, if any, into temp:
		    	temp[k++] = a[j++];
	    }
	    
	    for(k = from; k <= to; k++) {	//Copy temp back to a[]
	    		a[k] = temp[k];
	    }
    }
}
