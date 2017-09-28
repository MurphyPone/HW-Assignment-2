   
public class Deck {
	//Fields
	private Card[] myDeck; 
	private Card topCard;
	
	//Constructors
	public Deck() {
		this.myDeck = new Card[52]; //Creates an array with room for 52 cards
		
		int s = 0;	//Suit counter
		while (s < 4 ) {		//Do 4x 
			for(int r = 2; r <= 14; r++) {	//r = rank value	//Should run 13x4 
				this.myDeck[(13*s)+r-2] = new Card(s, r);	//TODO easy way to convert r ????? -2? although [13x3+13] = 52... shouldn't get any IOB excpetion
			}
			s++;	//Go to next suit
		}
		this.topCard = this.myDeck[myDeck.length-1];	//The top card is the last card
	}
	
	public Deck(boolean notShuffled) {
		this.myDeck = new Card[52]; //Creates an array with 52 slots
		
		if(notShuffled) {
			System.out.println("This is where I'd put my sorted Decks If I had the power to make them");
			//Deck();  //TODO Can I just call the default constructor here?
		}else {	// need to give each card a random order
			for(int i = 0; i < 52; i++ ) {	//Need 52 cards
				Card tryC = new Card();	//Creates a random card
				for(int c = 0; c < myDeck.length; c ++) {
					if( !tryC.equals(myDeck[c]) ) {	//If they don't match
						myDeck[c] = tryC;
					}	//Else need a new card?
				}
			}
		}		
		this.topCard = this.myDeck[myDeck.length];	//The top card is the last card
	}
}
