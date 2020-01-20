package blackjack;

import java.awt.*;

public class Card {
	Image img; 
	int value;
	Suit suit;
	Rank rank;
	
	public Card(Image img, int value, Suit suit, Rank rank) {
		this.img = img;
		this.value = value;
		this.suit = suit;
		this.rank = rank;

	}
	
}
