import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class RoundFrame extends JFrame{
	
	String Playername;
	int Playerlevel;
	int round;
	TimerPanel tp;
	boolean flag = false;
	
	RoundFrame(String name, int level, int R){
		Playername = name;
		Playerlevel = level;
		round = R;
		setLayout(null);
		
		JLabel rounddisplayer = new JLabel();
		rounddisplayer.setBounds(50,50,800,50);
		rounddisplayer.setFont(new Font("Product Sans", Font.BOLD, 50));
		rounddisplayer.setForeground(new Color(0xFAF9F6));
		rounddisplayer.setText(Playername + " - " + " Round " + round);
		add(rounddisplayer);
		
		RoundPanel rp = new RoundPanel(Playername, Playerlevel, round);
		add(rp);
		
		tp = new TimerPanel(round);
		add(tp);
		
		setTitle("Bubble Burst Round 1");
		setSize(1920, 1080);
		getContentPane().setBackground(new Color(0x000000));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {

			@Override
			public void run() {
				if(rp.isCompleted) {
					//System.out.println("bro it worked!");
					//cancel the fuckin timer
					tp.checkflag(true);
					
					timer.cancel();
				}
			}
			
		};
		timer.scheduleAtFixedRate(task, 0, 500);
	}
	
}
