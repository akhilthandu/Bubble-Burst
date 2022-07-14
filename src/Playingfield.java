import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Window;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class Playingfield extends JPanel implements MouseListener{
	
	String Playername;
	int Playerlevel;
	
	static final int SCREEN_WIDTH = 1800;
	static final int SCREEN_HEIGHT = 750;
	static final int UNIT_SIZE = 50;
	static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/UNIT_SIZE;
	final int x[] = new int [GAME_UNITS];
	final int y[] = new int [GAME_UNITS];
	int bubbleX = 1*UNIT_SIZE;
	int bubbleY = 1*UNIT_SIZE;
	int round = 1;
	int rempoi;
	
	Playingfield(String name, int level){
		Playername = name;
		Playerlevel = level;
		rempoi = level+4;
		setBounds(50, 200, 1800, 750);
		setBackground(new Color(0x696969));
		addMouseListener(this);
		setVisible(true);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}
	
	public void draw(Graphics g) {
		
		for(int i=0;i<SCREEN_HEIGHT/UNIT_SIZE;i++)
			g.drawLine(0, i*UNIT_SIZE, SCREEN_WIDTH, i*UNIT_SIZE);
		for(int i=0;i<SCREEN_WIDTH/UNIT_SIZE;i++)
			g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, SCREEN_HEIGHT);
		
	}
	
	public void drawBubble(Graphics g) {
		g.setColor(new Color(0x87CEEB));
		g.fillOval(bubbleX, bubbleY, UNIT_SIZE, UNIT_SIZE);
	}
	
	public void startGame() {
		System.out.println("GAME STARTED");
		Window x = SwingUtilities.getWindowAncestor(this);
		x.dispose();
		new RoundFrame(Playername, Playerlevel,1);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(rempoi>0) {
			Point z = e.getPoint();
			z.x = (int)((z.getX())/UNIT_SIZE) * UNIT_SIZE;
			z.y = (int)((z.getY())/UNIT_SIZE) * UNIT_SIZE;
			bubbleX = (int)z.getX();
			bubbleY = (int)z.getY();
			drawBubble(getGraphics());
			rempoi--;
		}
		if(rempoi==0) {
			startGame();
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
