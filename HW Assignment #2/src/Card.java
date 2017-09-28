import java.util.Comparator;

public class Card {
	//Fields									0			1			2		3
	private static final String[] suits = {"Clubs", "Diamonds", "Hearts", "Clubs"};
	private static final String[] ranks = {"Two", "Three", "Four", "Five", "Six", "Seven", 
											"Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"};
	private int suit;
	private int rank;//Each rank/suit corresponds to a static final String value
	
	//Default constructor creates a random  card------------------------------
	public Card() {
		this.suit = (int) (Math.random()*4);
		this.rank = 2 + (int) (Math.random()*ranks.length); //should return a random # 2-14
	}
	
	//constructor variation ii.
	public Card(int mSuit, int mRank ) {
		this.suit = mSuit;
		
		if(isValidRank(mRank))
			this.rank = mRank;
		else 
			this.rank = 2;	//if the user passes a value that is too high or low, it defaults to a 2
	}
	
	//constructor variation iii.
	public Card(String mSuit, String mRank) {
		this.suit = getSuitInt(mSuit);
		this.rank = getRankInt(mRank);
	}
	
	//constructor variation iv.
	public Card(String mSuit, int  mRank) {
		this.suit = getSuitInt(mSuit);	//Check if valid? or just send it...
		
		if(isValidRank(mRank))
			this.rank = mRank;
		else 
			this.rank = 2;
	}
	
	//constructor variation v.
	public Card(int mSuit, String  mRank) {
		this.suit = mSuit;	//Check if valid? or just send it...
		this.rank = getRankInt(mRank);
	}
	
	//Constructor helper
	public boolean isValidRank(int r) {
		return (r >= 2 && r < 15);
	}
		
	//Getters------------------------------
	public int getSuit() {
		return this.suit;
	}
	
	public int getRank() {
		return this.rank; 
	}
	
	//toString------------------------------
	public String toString() {
		return getRankStr() + " of " + suits[this.suit]; //getRankStr() is causing problems
	}
	
	//Conversion------------------------------
	public String getRankStr() {
		return ranks[this.rank-2];	//rank = 2 --> "two" == ranks[0]
	}	
	
	public int getRankInt(String str) {
		for(int i = 0; i < ranks.length; i ++) {
			if(str.toLowerCase().equals(ranks[i].toLowerCase()) ) //handles more cases
				return i+2;	//Returns the index of the corresponding rank String  "two" == ranks[0], but the value == +2
		}
		return -1;			//If input is not found, 
	}
	
	public int getSuitInt(String str) {
		for(int i = 0; i < suits.length; i ++) {
			if(str.toLowerCase().equals(suits[i].toLowerCase()) ) //handles more cases
				return i;	//Returns the index of the corresponding suit
		}
		return -1;			//If input is not found, 
	}
}
