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
		rounddisplayer.setBounds(30,20,200,30);
		rounddisplayer.setFont(new Font("Product Sans", Font.BOLD, 35));
		rounddisplayer.setForeground(new Color(0x1DC690));
		rounddisplayer.setText("Round " + round);
		add(rounddisplayer);
		
		
		Playingfield pf = new Playingfield(Playername, Playerlevel);
		add(pf);
		
		if(round==1) {
			prompt = new JLabel();
			prompt.setBounds(30,50,600,30);
			prompt.setFont(new Font("Product Sans", Font.PLAIN, 15));
			prompt.setForeground(new Color(0x1C4670));
			prompt.setText("Please click on the playing field below such that you create " + (Playerlevel+4) + " bubbles");
			add(prompt);
		}
		
		
		setTitle("Bubble Burst");
		setSize(1080, 720);
		getContentPane().setBackground(new Color(0xEAEAE0));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
	
	
	
}
