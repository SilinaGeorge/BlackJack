package blackjack;

public class Player {
	
	int handTotal;
	
	public Player() {
		handTotal = 0;
	}
	
	public void addtoHandTotal(int value) {
		handTotal += value;
	}
	
	public boolean checkBust(){
		return handTotal > 21;
	}
	
}
