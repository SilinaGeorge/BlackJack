package blackjack;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;


public class Deck {

  private Hashtable<Integer, Card> deck;
  private List<Integer> deckMap;
  private static int index;
  
  public Deck() {
	  deck = new Hashtable<Integer, Card>();
	  
	  // each element corresponds with a hashtable deck key
	  deckMap = new ArrayList<Integer>(Arrays.asList(
			  0, 1, 2,3,4,5,6,7,8,9,10,
			  11,12,13,14,15,16,17,18,19,20,
			  21,22,23,24,25,26,27,28,29,30,
			  31,32,33,34,35,36,37,38,39,40,
			  41,42,43,44,45,46,47,48,49,50,51)); 
	  
	// used to make Card objects for each card
	Hashtable<String,Rank> ranks = new Hashtable<String,Rank>();
	ranks.put("1", Rank.ACE);
	ranks.put("2", Rank.TWO);
	ranks.put("3", Rank.THREE);
	ranks.put("4", Rank.FOUR);
	ranks.put("5", Rank.FIVE);
	ranks.put("6", Rank.SIX);
	ranks.put("7", Rank.SEVEN);
	ranks.put("8", Rank.EIGHT);
	ranks.put("9", Rank.NINE);
	ranks.put("10", Rank.TEN);
	ranks.put("A", Rank.ACE);
	ranks.put("J", Rank.JACK);
	ranks.put("K", Rank.KING);
	ranks.put("Q", Rank.QUEEN);
	
	Hashtable<String,Suit> suits = new Hashtable<String,Suit>();
	suits.put("C", Suit.CLUBS);
	suits.put("H", Suit.HEARTS);
	suits.put("D", Suit.DIAMONDS);
	suits.put("S", Suit.SPADES);
	
	
	index = 0;
	
	// make card objects and put them in the deck
	ranks.forEach((strRank, rank) -> {
		suits.forEach((strSuit, suit) ->{
			try {
				Image img = ImageIO.read(new File("images/" +strRank +strSuit+".png"));
				deck.put(index, new Card(img,suit, rank));
				index++;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
		});
		
	});
	shuffleDeck();
	
  }
  
	// randomly shuffles the deck
	private void shuffleDeck() {
		Random rand = new Random();

		// swap each element with another element at a random index
	    for (int i = 0 ; i< deckMap.size() ; i++){
		    int index = rand.nextInt(deckMap.size());
		    int temp = deckMap.get(i);
		    deckMap.set(i, deckMap.get(index));
		    deckMap.set(index, temp);

	    }
	    		
	}
	
	// returns the first card in the deckmap and remove it from deckmap
	public Card drawCard(){
		if (deckMap.size() != 0) {
			Card c = deck.get(deckMap.get(0));
			deckMap.remove(0);
			return c;
		}
		
		return null;
		
	}
	     
  
}
