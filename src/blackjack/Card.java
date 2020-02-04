package blackjack;

import java.awt.*;

public class Card {
	private Image img; 
	private int value;
	private Suit suit;
	private Rank rank;
	
	public Card(Image img, Suit suit, Rank rank) {
		this.img = img;
		this.suit = suit;
		this.rank = rank;
		
		setValue();

	}
	
	private void setValue() {
		
		switch(rank) {
		case ACE:
			this.value = 1;
			break;
		case EIGHT:
			this.value = 8;
			break;
		case FIVE:
			this.value = 5;
			break;
		case FOUR:
			this.value = 4;
			break;
		case JACK:
			this.value = 10;
			break;
		case KING:
			this.value = 10;
			break;
		case NINE:
			this.value = 9;
			break;
		case QUEEN:
			this.value = 10;
			break;
		case SEVEN:
			this.value = 7;
			break;
		case SIX:
			this.value = 6;
			break;
		case TEN:
			this.value = 10;
			break;
		case THREE:
			this.value = 3;
			break;
		case TWO:
			this.value = 2;
			break;
		default:
			break;
			
		}
		
	}
	
	// value of ace can either be 1 or 11 depending on which one is more suitable
	public void setBestAceValue(int handTotal) {
		if (rank == Rank.ACE) {
			if (handTotal <= 10) this.value = 11;
			else this.value = 1;
		}
	}
	
	public int getValue() {
		
		return this.value;
	}
	
	public Rank getRank() {
		return rank;
	}
	
	public Image getImage() {
		return img;
	}
	
	
}
