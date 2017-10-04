import java.util.ArrayList;

public class Deck {
	//Fields
	private Card[] myDeck; 
	private int topCard;
	private boolean isSorted; //Worth keeping track of this state for the toString()?
	private final int THENUMBEROFCARDSWHICHAPPEARINATRADITIONALDECKOFCARDS = 52;
	
	//Constructor Lite
	public Deck() {
		this.myDeck = new Card[THENUMBEROFCARDSWHICHAPPEARINATRADITIONALDECKOFCARDS]; //Creates an array with room for 52 cards
		
		sortedHelp();
		this.topCard = myDeck.length-1;	//The top card is the last card
	}
	
	//Constructor Premium+
	public Deck(boolean notShuffled) {
		this.myDeck = new Card[THENUMBEROFCARDSWHICHAPPEARINATRADITIONALDECKOFCARDS]; //Creates an array with 52 slots
		
		if(notShuffled)
			sortedHelp();
		else
			shuffledHelp();
		
		this.topCard = myDeck.length-1;	//The top card is the last card
	}
	
	//Constructor for Deal
	public Deck(int numCards) { 
		myDeck = new Card[numCards];
		this.topCard = myDeck.length-1;
		this.isSorted = false;
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
		
		for(int i = 0; i < myDeck.length; i++) {	//Needs a separate loop so that tempArrL gets filled
			myDeck[i] = tempDeck.getDeck()[i];		//myDeck is filled with random pick from the shrinking tempArrL
			tempDeck.collapse(i);				//Removes selected card from tempDeck so that It can't be added twice
		}
	}
	
	//Pick
	public Card pick(Card[] d) {
		return d[(int) (Math.random() * d.length) + 1]; 	//!!Issue with +1?
		//COLLAPSE() HERE
	}
	
	//Collapse
	public void collapse(int x) {	//x = the card that has been picked
		if(x == topCard) {	//Dealt from the top card
			myDeck[topCard] = null;
			topCard--;
		} else {				//Randomly Picked card
			for(int i = x; i < topCard-1; i++) { 
				myDeck[i] = myDeck[i+1];
			}
			myDeck[topCard] = null;
			topCard--;
		}
	}
	
	//Deal
	public Deck[] deal(int numHands, int cardsPer) {//numHands, cardsPerHand
		Deck[] result = new Deck[numHands];
		for(int i = 0; i < numHands; i++ ) {
			result[i] = new Deck(cardsPer);	//Creates a new Deck
		}
		
		if( (numHands * cardsPer) <= myDeck.length ) {	//Checks to make sure that there are enough cards in the given deck
			for(int j = 0; j < cardsPer; j++) {	//Deals "clockwise"
				for(int i = 0; i < numHands; i++ ) {
					result[i].myDeck[j] = new Card(myDeck[topCard]);	//Sets the value of the card to a copy of the card from the parent
					myDeck[topCard--] = null;			//Sets the topCard = null since it's been "removed"
				}
			}
		} else {
			System.out.println("That's too many cards hombre!!!");
			return null;
		}
	
		return result;
	}
	
	//toString
	public String toString() {	
		String theShizzle = "";
		
		if(myDeck.length == THENUMBEROFCARDSWHICHAPPEARINATRADITIONALDECKOFCARDS) { //Full Deck
			if(isSorted) {
				for(int i = 0; i < THENUMBEROFCARDSWHICHAPPEARINATRADITIONALDECKOFCARDS/4; i++) {
					theShizzle = theShizzle + myDeck[i].toString() + "\t\t" + myDeck[i+THENUMBEROFCARDSWHICHAPPEARINATRADITIONALDECKOFCARDS/4].toString() 
							+ "\t\t" + myDeck[i+THENUMBEROFCARDSWHICHAPPEARINATRADITIONALDECKOFCARDS/2].toString() + "\t\t" + 
							myDeck[i+(THENUMBEROFCARDSWHICHAPPEARINATRADITIONALDECKOFCARDS/2)+
							       (THENUMBEROFCARDSWHICHAPPEARINATRADITIONALDECKOFCARDS/4)].toString() + "\n";
				}
			} else {	//Unsorted	
				for(int i = 0; i < myDeck.length; i++ ) {	//The assignment only asks for 1 tab, but I'm putting 2 for readability			
					theShizzle = theShizzle + myDeck[i++].toString() + "\t\t" + myDeck[i++].toString() + "\t\t" + myDeck[i++].toString() 
							+ "\t\t" + myDeck[i].toString() + "\n";	//Last card doesn't i++ boost
				}
			}		
		} else {		//Any # of Hands
			for(int i = 0; i < topCard; i++ )
				if(myDeck[i] != null )
					theShizzle = theShizzle + getDeck()[i].toString() + "\n";
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
	//W E W L A D Searching and sorting time------------------------------------------------------------
	
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
	    //TODO FOR WHATEVER REASON, IF I CHANGE THIS TO TRUE, IT PRINTS WACKASF
	}
	
	//------------------------------------------------------------
	
	// Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    void merge(Card[] deck, int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int size1 = m - l + 1;
        int size2 = r - m;
 
        /* Create temp arrays */
        Card[] left = new Card[size1];
        Card[] right = new Card[size2];
 
        /*Copy data to temp arrays*/
        for (int i = 0; i < size1; ++i) {
        //	System.out.println("Deck[" + i +"] = " + deck[l + i]);
            left[i] = deck[l + i];
        }
        for (int j = 0; j < size2; ++j) {
        //	System.out.println("Deck[" + j +"] = " + deck[m + 1 + j]);
            right[j] = deck[m + 1 + j];	//TODO ERROR HERE		
        }
 
        /* Merge the temp arrays */
        int i = 0, j = 0; 	// Initial indexes of first and second subarrays

        //Compares each index of each sorted array L and R, 
        //then incrememnts the index of which array has the higher card, and inserts it into deck[]
    
        int k = l;  // Initial index of merged subarry array
        while (i < size1 && j < size2) {
            if (left[i].compareTo(right[j]) <= 1) {//(left[i] <= right[j]
                deck[k] = left[i];
                i++;
            } else {
                deck[k] = right[j];
                j++;
            }
            k++;
        }
 
        /* Copy remaining elements of L[] if any */
        while (i < size1) {
            deck[k] = left[i];
            i++;
            k++;
        }
 
        /* Copy remaining elements of R[] if any */
        while (j < size2) {
            deck[k] = right[j];
            j++;
            k++;
        }
    }
 
    // Main function that sorts arr[l..r] using
    // merge()
    void mergeSort(Card[] deck, int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = (l+r)/2;
 
            // Sort first and second halves
            mergeSort(deck, l, m);
            mergeSort(deck, m+1, r);
 
            // Merge the sorted halves
            merge(deck, l, m, r);
        }
    }
	 
}
