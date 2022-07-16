import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Window;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class TimerPanel extends JPanel{
	
	String toime = "Sec";
	int toimeX = 882;
	int toimeY = 52;
	int counter=20;
	int round;
	boolean flag  = false;
	
	TimerPanel(int R){
		
		round = R;
		counter = counter - round;
		
		setBounds(880, 50, 150, 50);
		setBackground(new Color(0x000000));
		setVisible(true);
		
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			
			@Override
			public void run() {
				
				if(counter>0) {
					if(flag==true) {
						timer.cancel();
					}
					
					String s = Integer.toString(counter) + " sec";
					toime = s;
					repaint();
					counter--;
				}
				else {
					toime = "Time Up!";
					repaint();
					timer.cancel();
					JOptionPane.showMessageDialog(null, "GAME OVER!", "GAME OVER!", JOptionPane.ERROR_MESSAGE);
					backtomain();
				}
				
			}
			
		};
		timer.scheduleAtFixedRate(task, 0, 1000);
	}
	
	public void backtomain() {
		Window x = SwingUtilities.getWindowAncestor(this);
		x.dispose();
	}
	
	public void checkflag(boolean b) {
		flag = b;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawTimer(g);
	}
	
	public void drawTimer(Graphics g) {
		g.setColor(new Color(0xEAEAE0));
		g.setFont(new Font("Product Sans", Font.BOLD, 28));
		g.drawString(toime, 40, 30);
	}

}
