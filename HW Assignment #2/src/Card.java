
public class Card implements Comparable<CardComparator>{
	//Fields									0			1			2		3
	private static final String[] suits = {"Clubs", "Diamonds", "Hearts", "Clubs"};
	private static final String[] ranks = {"Two", "Three", "Four", "Five", "Six", "Seven", 
											"Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"};
	private int suit;
	private int rank;//Each rank/suit corresponds to a static final String value
	
	//Default constructor creates a random card------------------------------
	public Card() {
		this.suit = (int) (Math.random()*4);
		this.rank = (int) (Math.random()*14); //should return a random # 1-14
	}
	
	//constructor variation ii.
	public Card(int mSuit, int mRank ) {
		this.suit = mSuit;
		this.rank = mRank;	//-2 to adjust for where decks start
	}
	
	//constructor variation iii.
	public Card(String mSuit, String mRank) {
		this.suit = getSuitInt(mSuit);
		this.rank = getRankInt(mRank);
	}
	
	//constructor variation iv.
	public Card(String mSuit, int  mRank) {
		this.suit = getSuitInt(mSuit);	//Check if valid? or just send it...
		this.rank = mRank;
	}
	
	//constructor variation v.
	public Card(int mSuit, String  mRank) {
		this.suit = mSuit;	//Check if valid? or just send it...
		this.rank = getRankInt(mRank);
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
		return getRankStr() + " of " + suits[this.suit];
	}
	
	//Conversion------------------------------
	public String getRankStr() {
		return ranks[this.rank-2];	//rank = 2 --> "two" == ranks[0]		//TODO Does not currently checkout
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

	@Override
	public int compareTo(CardComparator o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
