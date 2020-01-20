package blackjack;

import java.awt.*;

enum Suits{
	DIAMOND,
	CLUB,
	HEART,
	SPADE
	
}

public class Card {
	private Image img; 
	int value;
	Suits suit;
	
	public Card(Image img, int value, Suits suit) {
		this.img = img;
		this.value = value;
		this.suit = suit;
	}

}
