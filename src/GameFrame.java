import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

public class GameFrame extends JFrame{
	
	String Playername;
	int Playerlevel;
	int rempoi;
	JLabel prompt;
	int round = 1;
	
	GameFrame(String name, int level){
		Playername = name;
		Playerlevel = level;
		rempoi = Playerlevel + 4;
		setLayout(null);
		
		JLabel rounddisplayer = new JLabel();
		rounddisplayer.setBounds(10,10,200,50);
		rounddisplayer.setFont(new Font("Product Sans", Font.BOLD, 50));
		rounddisplayer.setForeground(new Color(0xFAF9F6));
		rounddisplayer.setText("Round " + round);
		add(rounddisplayer);
		
		
		Playingfield pf = new Playingfield(Playername, Playerlevel);
		add(pf);
		
		if(round==1) {
			prompt = new JLabel();
			prompt.setBounds(10,70,1000,50);
			prompt.setFont(new Font("Product Sans", Font.PLAIN, 20));
			prompt.setForeground(new Color(0xFAF9F6));
			prompt.setText("Please click on the playing field below such that you create " + (Playerlevel+4) + " bubbles");
			add(prompt);
		}
		
		
		setTitle("Bubble Burst");
		setSize(1920, 1080);
		getContentPane().setBackground(new Color(0x000000));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
	
	
	
}
