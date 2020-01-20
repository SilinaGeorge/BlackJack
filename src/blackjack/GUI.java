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

public class GUI extends JFrame {
	
	// window width and height
	private final int vh = 600;
	private final int vw = 1000;
	
	//buttons
	private JButton hitButton;
	private JButton standButton;
	private JButton yesAgainButton;
	private JButton exitButton;
	private JButton dealButton;
	private JTextField betTxtF;
	private JPanel panel;
	
	
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
		 
	private void createLayout() {
		
		this.dealButton = makeButton("Deal", 150, 70, new Color(5, 5, 133), Color.WHITE);		
		this.dealButton.addActionListener(
			new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  displayInGame();
			  } 
			} );
		this.dealButton.setLocation(500, 450);
		this.panel.add(this.dealButton);
		
		this.betTxtF = new JTextField("place your bet here", 20);
		this.betTxtF.setSize(200, 70);
		this.betTxtF.setLocation(300, 450);
		this.panel.add(this.betTxtF);
		
		this.hitButton = makeButton("Hit", 150, 70, new Color(5, 5, 133), Color.WHITE);		
		this.hitButton.setLocation(300, 450);
		this.panel.add(this.hitButton);

		this.standButton = makeButton("Stand", 150, 70, new Color(5, 5, 133), Color.WHITE);		
		this.standButton.setLocation(600, 450);
		this.panel.add(this.standButton);
		
		this.yesAgainButton = makeButton("Play Again", 150, 70, new Color(5, 5, 133), Color.WHITE);		
		this.yesAgainButton.setLocation(300, 450);
		this.panel.add(this.yesAgainButton);
		
		this.exitButton = makeButton("Exit", 150, 70, new Color(5, 5, 133), Color.WHITE);		
		this.exitButton.setLocation(600, 450);
		this.panel.add(this.exitButton);
			
	}
	
	public void displayStartGame() {
		
		panel.remove(hitButton);
		panel.remove(standButton);
		panel.remove(yesAgainButton);
		panel.remove(exitButton);
		
		panel.add(betTxtF);
		panel.add(dealButton);
		panel.repaint();
			
	}
	
	public void displayInGame() {
		
		panel.remove(yesAgainButton);
		panel.remove(exitButton);
		panel.remove(dealButton);
		panel.remove(betTxtF);
		
		panel.add(hitButton);
		panel.add(standButton);
		panel.repaint();
		
	}
	
	public void displayFinishGame() {

		panel.remove(hitButton);
		panel.remove(standButton);
		panel.remove(dealButton);
		panel.remove(betTxtF);
		
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

