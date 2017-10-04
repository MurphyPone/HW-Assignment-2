/**
 * Class Description: This class represents a single playing card and handles how cards should be compared to each other.
 * @author MurphyP1
 * @date 10/3/17
 */

import java.util.*;

public class Card implements Comparable<Card> {
	//Fields									0			1			2		3
	private static final String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
	private static final String[] ranks = {"Two", "Three", "Four", "Five", "Six", "Seven", 
											"Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"};
	private int suit;
	private int rank;//Each rank/suit corresponds to a static final String value
	
	/**
	 * The default constructor for a Card object which creates a random card
	 * 
	 * @author MurphyP1
	 * @date 10/3/17
	 * @method Card
	 * 
	 * @return a Card with a random rank and suit
	 */
	public Card() {
		this.suit = (int) (Math.random()*4);
		this.rank = 2 + (int) (Math.random()*ranks.length); //should return a random # 2-14
	}
	
	/**
	 * A constructor for a Card object which creates a card based on integer arguments
	 * 
	 * @author MurphyP1
	 * @date 10/3/17
	 * @method Card
	 * 
	 * @param mSuit an integer which defines the suit of the card
	 * @param mRank an integer which defines the rank of the card
	 * 
	 * @return a Card with a defined rank and suit
	 */
	public Card(int mSuit, int mRank ) {
		if(isValidSuit(mSuit))
			this.suit = mSuit;
		else 
			this.suit = 2;	//if the user passes a value that is too high or low, it defaults to a Club
		
		if(isValidRank(mRank))
			this.rank = mRank;
		else 
			this.rank = 2;	//if the user passes a value that is too high or low, it defaults to a 2
    	}
	
	/**
	 * A constructor for a Card object which creates a card based on string arguments
	 * 
	 * @author MurphyP1
	 * @date 10/3/17
	 * @method Card
	 * 
	 * @param mSuit a string which defines the suit of the card
	 * @param mRank a string which defines the rank of the card
	 * 
	 * @return a Card with a defined rank and suit
	 */
	public Card(String mSuit, String mRank) {
		if(isValidSuit(mSuit))
			this.suit = suitToInt(mSuit);
		else 
			this.suit = 2;	//if the user passes a value that is too high or low, it defaults to a Club
		
		if(isValidRank(mRank))
			this.rank = rankToInt(mRank);
		else 
			this.rank = 2;	//if the user passes a value that is too high or low, it defaults to a 2
	}
	
	/**
	 * A constructor for a Card object which creates a card based on string and integer arguments
	 * 
	 * @author MurphyP1
	 * @date 10/3/17
	 * @method Card
	 * 
	 * @param mSuit a string which defines the suit of the card
	 * @param mRank an integer which defines the rank of the card
	 * 
	 * @return a Card with a defined rank and suit
	 */
	public Card(String mSuit, int  mRank) {
		if(isValidSuit(mSuit))
			this.suit = suitToInt(mSuit);
		else 
			this.suit = 2;	//if the user passes a value that is too high or low, it defaults to a Club
		
		if(isValidRank(mRank))
			this.rank = mRank;
		else 
			this.rank = 2;	//if the user passes a value that is too high or low, it defaults to a 2
	}
	
	/**
	 * A constructor for a Card object which creates a card based on integer and string arguments
	 * 
	 * @author MurphyP1
	 * @date 10/3/17
	 * @method Card
	 * 
	 * @param mSuit an integer which defines the suit of the card
	 * @param mRank a string which defines the rank of the card
	 * 
	 * @return a Card with a defined rank and suit
	 */
	public Card(int mSuit, String  mRank) {
		if(isValidSuit(mSuit))
			this.suit = mSuit;
		else 
			this.suit = 2;	//if the user passes a value that is too high or low, it defaults to a Club
		
		if(isValidRank(mRank))
			this.rank = rankToInt(mRank);
		else 
			this.rank = 2;	//if the user passes a value that is too high or low, it defaults to a 2
	}
	
	/**
	 * A constructor for copying the values of one Card to another
	 * 
	 * @author MurphyP1
	 * @date 10/3/17
	 * @method Card
	 * 
	 * @param parent a card whose values are copied directly to the new card
	 * 
	 * @return a Card with a rank and suit defined by another Card
	 */ 
	public Card(Card parent) { 
		suit = parent.suit;
		rank = parent.rank;
	}
	
	
	//Constructor helpers---------------------------------------------------------------------------------------------------------------------
	
	/**
	 * A helper method which determines if the rank value a user passes is valid
	 * 
	 * @author MurphyP1
	 * @date 10/3/17
	 * @method isValidRank
	 * 
	 * @param r the attempted integer to set a Card's rank value to
	 * 
	 * @return true if the integer is valid
	 */ 
	private boolean isValidRank(int r) {
		return (r >= 2 && r < 15);
	}
	
	/**
	 * A helper method which determines if the rank value a user passes is valid
	 * 
	 * @author MurphyP1
	 * @date 10/3/17
	 * @method isValidRank
	 * 
	 * @param r the attempted string to set a Card's rank value to
	 * 
	 * @return true if the string is valid
	 */ 
	private boolean isValidRank(String r) {
		boolean isValid = false;
		for(int i = 0; i < ranks.length; i++) {
			if(!r.equals(ranks[i]) ) {
				isValid = true;
			}
		}
		return isValid;
	}
	
	/**
	 * A helper method which determines if the suit value a user passes is valid
	 * 
	 * @author MurphyP1
	 * @date 10/3/17
	 * @method isValidSuit
	 * 
	 * @param s the attempted integer to set a Card's suit value to
	 * 
	 * @return true if the integer is valid
	 */ 
	public boolean isValidSuit(int s) {
		return (s >= 0 && s < 4);
	}
	/**
	 * A helper method which determines if the suit value a user passes is valid
	 * 
	 * @author MurphyP1
	 * @date 10/3/17
	 * @method isValidSuit
	 * 
	 * @param s the attempted string to set a Card's suit value to
	 * 
	 * @return true if the string is valid
	 */ 
	public boolean isValidSuit(String s) {
		boolean isValid = false;
		for(int i = 0; i < suits.length; i++) {
			if((s == suits[i]) ) {
				isValid = true;
			}
		}
		return isValid;
	}
	
	/**
	 * A helper method which converts a string to its corresponding suit integer value
	 * 
	 * @author MurphyP1
	 * @date 10/3/17
	 * @method suitToInt
	 * 
	 * @param s the string to convert to an integer
	 * 
	 * @return the index of the suit within the final array of suit strings, or defaults to 0 if invalid
	 */ 
	public int suitToInt(String s) {
		for(int i = 0; i < suits.length; i++) {
			if((s == suits[i]) ) {
				return i; // returns the index within suits 
			}
		}
		return 0; //If it doesn't match any of the suits, default to Club
	}
	
	/**
	 * A helper method which converts a string to its corresponding rank integer value
	 * 
	 * @author MurphyP1
	 * @date 10/3/17
	 * @method rankToInt
	 * 
	 * @param r the string to convert to an integer
	 * 
	 * @return the index of the rank within the final array of rank strings, or defaults to 2 if invalid
	 */ 
	public int rankToInt(String r) {
		for(int i = 0; i < ranks.length; i++) {
			if(r == ranks[i] ) {
				return i; // returns the index within suits 
			}
		}
		return 2; //If it doesn't match any of the ranks, default to Two
	}
	
	//Getters----------------------------------------------------------------------------------------------------------------------------------
	
	/**
	 * A method which returns the string value of a Card's suit
	 * 
	 * @author MurphyP1
	 * @date 10/3/17
	 * @method getSuit
	 * 
	 * @return the String value which corresponds to the integer suit value
	 */ 
	public String getSuit() {	
		return suits[this.suit];	
	}
	
	/**
	 * A method which returns the integer value of a Card's rank
	 * 
	 * @author MurphyP1
	 * @date 10/3/17
	 * @method getRank
	 * 
	 * @return the integer value which corresponds to the suit value
	 */ 
	public int getRank() {
		return this.rank; 
	}
	
	//Alternative Getters------------------------------
	
	/**
	 * A method which returns the string value of a Card's rank
	 * 
	 * @author MurphyP1
	 * @date 10/3/17
	 * @method getRankStr
	 * 
	 * @return the string value which corresponds to the Card's integer value
	 */ 
	public String getRankStr() {
		return ranks[this.rank-2];	//rank = 2 --> "two" == ranks[0]
	}	
	
	/**
	 * A method which returns the integer value of a Card's suit
	 * 
	 * @author MurphyP1
	 * @date 10/3/17
	 * @method getSuitInt
	 * 
	 * @return the integer value which corresponds to the Card's suit
	 */ 
	public int getSuitInt() {
		return this.suit;
	}
	
	/**
	 * A method which returns the string value of a Card's rank and suit
	 * 
	 * @author MurphyP1
	 * @date 10/3/17
	 * @method toString
	 * 
	 * @return the string value which corresponds to the Card's rank suit
	 */ 
	//toString------------------------------
		public String toString() {
			return getRankStr() + " of " + getSuit(); //getRankStr() is causing problems
		}
	
	//Comparison------------------------------
	/**
	 * A method which compares two Cards to one another according to suit and THEN rank
	 * 
	 * @author MurphyP1
	 * @date 10/3/17
	 * @method compareTo
	 * 
	 * @param c a Card to be compared to the main Card
	 * 
	 * @return an integer according to the difference from the Card and another Card
	 */ 
	public int compareTo(Card c) {
		if( getSuitInt()  == c.getSuitInt()) {
			if(getRank() > c.getRank() ) { return 1; } 
			else if(getRank() < c.getRank()) {return -1; }
			else { return 0;}
		} 
		if( getSuitInt()  > c.getSuitInt()) {
			return 1;
		} else {
			return -1;
		}
	}
	
	/**
	 * A method which compares two Cards to one another according to suit and  rank
	 * 
	 * @author MurphyP1
	 * @date 10/3/17
	 * @method equals
	 * 
	 * @param c a Card to be compared to the main Card
	 * 
	 * @return true if both Cards' suit and rank are identical
	 */ 
	public boolean equals(Card c) {
		return (c.getRank() == this.getRank() && c.getSuit() == this.getSuit() ); 
	}
}
