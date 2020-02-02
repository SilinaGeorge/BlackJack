package blackjack;

import java.awt.*;

public class Card {
	Image img; 
	int value;
	Suit suit;
	Rank rank;
	
	public Card(Image img, Suit suit, Rank rank) {
		this.img = img;
		this.suit = suit;
		this.rank = rank;
		
		setValue();

	}
	
	private void setValue() {
		switch(rank) {
		case ACE:
			value = 1;
		case EIGHT:
			value = 8;
		case FIVE:
			value = 5;
		case FOUR:
			value = 4;
		case JACK:
			value = 10;
		case KING:
			value = 10;
		case NINE:
			value = 9;
		case QUEEN:
			value = 10;
		case SEVEN:
			value = 7;
		case SIX:
			value = 6;
		case TEN:
			value = 10;
		case THREE:
			value = 3;
		case TWO:
			value = 2;
		default:
			break;
			
		}
	}
	
}
