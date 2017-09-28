   
public class Deck {
	//Fields
	private Card[] myDeck; 
	private Card topCard;
	
	//Constructors
	public Deck() {
		this.myDeck = new Card[52]; //Creates an array of 52 cards
		
		//Creates cards
		/*for(int s = 1; s < 5; s ++)
			for(int r = 2; r < 14; r++ ) {	//TODO this loop is bad...
				this.myDeck[s*r] = new Card(s-1, r);	//[s*r] is whack
			}
		*/ //Neat idea. but doesn't work
		
		int s = 0;
		while (s < 4 ) {
			for(int r = 2; r < 14; r++) {
				this.myDeck[r] = new Card(s, r);
			}
			s++;
		}
		
		this.topCard = this.myDeck[myDeck.length];	//The top card is the last card
	}
	
	public Deck(boolean notShuffled) {
		this.myDeck = new Card[52]; //Creates an array of 52 cards
		
		this.topCard = this.myDeck[myDeck.length];	//The top card is the last card
	}
}
