   
public class Deck {
	//Fields
	private Card[] myDeck; 
	private Card topCard;
	
	//Constructors
	public Deck() {
		this.myDeck = new Card[52]; //Creates an array with room for 52 cards
		
		//Creates cards
		/*for(int s = 1; s < 5; s ++)
			for(int r = 2; r < 14; r++ ) {	//TODO this loop is bad...
				this.myDeck[s*r] = new Card(s-1, r);	//[s*r] is whack
			}
		*/ //Neat idea. but doesn't work
		
		int s = 0;	//Suit counter
		while (s < 4 ) {		//Do 4x 
			for(int r = 2; r < 14; r++) {	//r = rank value
				this.myDeck[(14*s)+r] = new Card(s, r);	//TODO easy way to convert r ?????
			}
			s++;	//Go to next suit
		}
		
		this.topCard = this.myDeck[myDeck.length];	//The top card is the last card
	}
	
	public Deck(boolean notShuffled) {
		this.myDeck = new Card[52]; //Creates an array with 52 slots
		
		if(notShuffled) 
			System.out.print("AFASFASF");
			//Deck();  //Can I just call the default constructor here?
		else {	// need to give each card a random order
			for(int i = 0; i < 52; i++ ) {	//Need 52 cards
				Card tryC = new Card();	//Creates a random card
				for(int c = 0; c < myDeck.length; c ++) {
					if( !tryC.equals(myDeck[c]) ) {	//If they don't match
						myDeck[c] = tryC;
					}	//Else need a new card?
				}
			}
		}
		
		this.myDeck = new Card[52]; //Creates an array of 52 cards
		
		this.topCard = this.myDeck[myDeck.length];	//The top card is the last card
	}
}
