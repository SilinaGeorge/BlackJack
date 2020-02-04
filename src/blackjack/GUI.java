package blackjack;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.io.*;
import java.util.*;
import java.awt.Toolkit.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class GUI extends JFrame {
	
	// window width and height
	private final int vh = 600;
	private final int vw = 1000;
	private Game game;
	
	//buttons
	private JButton hitButton;
	private JButton standButton;
	private JButton yesAgainButton;
	private JButton exitButton;
	private JButton dealButton;
	private JTextField betTxtF;
	private JPanel panel;
	
	private int playerCardX = 100;
	private int dealerCardX = 100;
	private final int playerCardY = 320;
	private final int  dealerCardY = 100;
	private final int xOffset = 100;
	private JLabel dealerCardFaceDown;
	private JLabel playerTotal;
	private JLabel dealerTotal;
	
	public GUI()  {
		// set up frame 
		this.setSize(this.vw, this.vh);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //make sure jframe terminates on close
		this.setTitle("Play Blackjack");
		this.setVisible(true);
		this.setResizable(false);
		this.setLayout(null);
		
		// add panel to jframe
		this.panel = new Panel();
		this.setContentPane(this.panel);
		
		this.createLayout();
		
		this.displayStartGame();

	}
	
	private JLabel drawCard(Image image, int x, int y) {
			
		JLabel cardLabel = new JLabel();
		cardLabel.setLocation(x, y);
		cardLabel.setSize(70, 100);
		
		// resize image
		BufferedImage img = (BufferedImage) image;
		Image dimg = img.getScaledInstance(cardLabel.getWidth(), cardLabel.getHeight(),
		        Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(dimg);
		
		cardLabel.setIcon(imageIcon);
		this.panel.add(cardLabel);
		this.panel.repaint();
		
		return cardLabel;
	}
	
	private void drawPlayerHandTotal() {
		if (playerTotal != null) this.panel.remove(playerTotal);
		playerTotal = new JLabel();	
		playerTotal.setLocation(900, 300);
		playerTotal.setSize(70, 100);
		playerTotal.setText("Total:" + game.player.handTotal);
		
		
		this.panel.add(playerTotal);
		this.panel.repaint();
		
		
	}
	
	private void drawDealerHandTotal() {
		if (dealerTotal != null) this.panel.remove(dealerTotal);
		dealerTotal = new JLabel();	
		dealerTotal.setLocation(900, 100);
		dealerTotal.setSize(70, 100);
		dealerTotal.setText("Total:" + game.dealer.handTotal);
		this.panel.add(dealerTotal);
		this.panel.repaint();
		
		
	}
	
	private void startNewGame() {
		
		 displayInGame();
		  game = new Game();
		  
		  playerCardX = 100;
		  dealerCardX = 100;
		  
		  drawCard(game.dealPlayer(), playerCardX, playerCardY);
		  playerCardX += xOffset;
		  drawCard(game.dealPlayer(), playerCardX, playerCardY);
		  playerCardX += xOffset;
		  
		  
		  drawCard(game.dealDealer(), dealerCardX, dealerCardY);
		  dealerCardX += xOffset;
		  
		  drawPlayerHandTotal();
		  drawDealerHandTotal();
		  		  
		  
		  	try {
				Image cardFaceDown = ImageIO.read(new File("images/red_back.png"));
				dealerCardFaceDown = drawCard(cardFaceDown, dealerCardX, dealerCardY);
			  
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			  
		  if (game.checkPlayerBust()) {
			  
			  displayFinishGame();
		  }
		  
		  
		
	}
	private void createLayout() {
		// create buttons, textfields, labels etc. with action listeners
		
		

		
		this.dealButton = makeButton("Deal", 150, 70, new Color(5, 5, 133), Color.WHITE);		
		this.dealButton.addActionListener(
			new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				 startNewGame();
			  } 
			} );
		this.dealButton.setLocation(450, 450);
		this.panel.add(this.dealButton);
		
		//this.betTxtF = new JTextField("place your bet here", 20);
		//this.betTxtF.setSize(200, 70);
		//this.betTxtF.setLocation(300, 450);
		//this.panel.add(this.betTxtF);
		
		this.hitButton = makeButton("Hit", 150, 70, new Color(5, 5, 133), Color.WHITE);		
		this.hitButton.setLocation(300, 450);
		this.hitButton.addActionListener(
				new ActionListener() { 
				  public void actionPerformed(ActionEvent e) { 
			  
					  drawCard(game.dealPlayer(), playerCardX, playerCardY);
					  playerCardX += xOffset;
					  
					  
					  drawPlayerHandTotal();
					  
					  if (game.checkPlayerBust()) {
						  
						  
						  displayFinishGame();
					  }
					  		
					  
					  
				  } 
				} );
		this.panel.add(this.hitButton);

		this.standButton = makeButton("Stand", 150, 70, new Color(5, 5, 133), Color.WHITE);		
		this.standButton.setLocation(600, 450);
		this.standButton.addActionListener(
				new ActionListener() { 
				  public void actionPerformed(ActionEvent e) { 
					  
					  if (dealerCardFaceDown != null) {
						  panel.remove(dealerCardFaceDown);
						  dealerCardFaceDown =null;
					  } 
					  
					  while(game.shouldDealerHit()) {
						  
						  drawCard(game.dealDealer(), dealerCardX, dealerCardY);
						  dealerCardX += xOffset;
						  drawDealerHandTotal();
						
						  
					  }
					  displayFinishGame();
				  } 
				} );
		this.panel.add(this.standButton);
		
		this.yesAgainButton = makeButton("Play Again", 150, 70, new Color(5, 5, 133), Color.WHITE);		
		this.yesAgainButton.setLocation(300, 450);
		this.yesAgainButton.addActionListener(
				new ActionListener() { 
				  public void actionPerformed(ActionEvent e) { 
					panel.removeAll();
					startNewGame();
					  
				  } 
				} );
		this.panel.add(this.yesAgainButton);
		
		this.exitButton = makeButton("Exit", 150, 70, new Color(5, 5, 133), Color.WHITE);		
		this.exitButton.setLocation(600, 450);
		this.exitButton.addActionListener(
				new ActionListener() { 
				  public void actionPerformed(ActionEvent e) { 
					  closeGame();
					  
				  } 
				} );
		this.panel.add(this.exitButton);
			
	}
	
	public void closeGame() {
		this.dispose();
		
	}
	
	public void displayStartGame() {
		
		panel.remove(hitButton);
		panel.remove(standButton);
		panel.remove(yesAgainButton);
		panel.remove(exitButton);
		
		//panel.add(betTxtF);
		panel.add(dealButton);
		panel.repaint();
			
	}
	
	public void displayInGame() {
		
		panel.remove(yesAgainButton);
		panel.remove(exitButton);
		panel.remove(dealButton);
		//panel.remove(betTxtF);
		
		panel.add(hitButton);
		panel.add(standButton);
		panel.repaint();
		
	}
	
	public void displayFinishGame() {

		panel.remove(hitButton);
		panel.remove(standButton);
		panel.remove(dealButton);
		//panel.remove(betTxtF);
		
		panel.add(yesAgainButton);
		panel.add(exitButton);
		panel.repaint();
		
	}
	
	private JButton makeButton(String name, int width, int height, Color backgroundCol, Color foregroundCol) {
		JButton newButton =  new JButton(name); 
		newButton.setSize(width, height);
		newButton.setBackground(backgroundCol);
		newButton.setForeground(foregroundCol);
		
		return (newButton);	
	}
	
	public class Panel extends JPanel {
		public Image img;
		
		public void paintComponent(Graphics g) 
		{ 
			super.paintComponent(g);
			// add background image
			try {
				
				img = ImageIO.read(new File("images/background.png"));
				g.drawImage(img,0,0,this);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} 
		
	}

}

