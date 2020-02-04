package blackjack;

import java.awt.Image;

public class Game {
	private Deck deck;
	Player player = new Player();
	Player dealer = new Player();

	public Game () {
		deck = new Deck();
	}
	
	public Image dealPlayer() {
		Card c = deal(player);
		return c.getImage();
	}
	
	public Image dealDealer() {
		Card c = deal(dealer);
		return c.getImage();
	}
	
	public Card deal(Player p){
		Card card = deck.drawCard(p.handTotal);
		p.addtoHandTotal(card.getValue());
		return card;
	}
	
	public boolean checkPlayerBust() {
		return player.checkBust();
	}
	
	public boolean checkDealerBust() {
		return dealer.checkBust();
	}
	
	public boolean shouldDealerHit() {
		return (!checkDealerBust() && player.handTotal >= dealer.handTotal);
	}
		
	
}
