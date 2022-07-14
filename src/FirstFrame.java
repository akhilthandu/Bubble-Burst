import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class FirstFrame extends JFrame implements ActionListener, ChangeListener{
	
	JButton startbutton;
	JTextField inputbox;
	JButton restartbutton;
	JSlider difficulty;
	int level=0;
	
	FirstFrame(){
		
		setLayout(null);
		
		JLabel title = new JLabel("BUBBLE BURST");
		title.setBounds(350,20,400,80);
		title.setFont(new Font("Product Sans", Font.BOLD, 50));
		title.setForeground(new Color(0xFAF9F6));
		add(title);
		
		JLabel enter = new JLabel("Enter Player Name");
		enter.setBounds(400, 150, 400, 80);
		enter.setFont(new Font("Product Sans", Font.PLAIN, 30));
		enter.setForeground(new Color(0xFAF9F6));
		add(enter);
		
		inputbox = new JTextField();
		inputbox.setBounds(400, 250, 250, 50);
		inputbox.setText("NoobMaster69");
		inputbox.setBackground(new Color(0x696969));
		inputbox.setForeground(new Color(0xFAF9F6));
		inputbox.setFont(new Font("Product Sans", Font.ITALIC, 30));
		inputbox.setHorizontalAlignment(JTextField.CENTER);
		add(inputbox);
		
		difficulty = new JSlider(0,2,0);
		difficulty.setBounds(350, 350, 350, 50);
		difficulty.setBackground(Color.black);
		Hashtable<Integer, JLabel> labelTable = 
			      new Hashtable<Integer, JLabel>();
			      labelTable.put(0, new JLabel("Easy") );
			      labelTable.put(1, new JLabel("Medium") );
			      labelTable.put(2, new JLabel("Hard") );
		difficulty.setLabelTable(labelTable);
		difficulty.setPaintLabels(true); 
		difficulty.addChangeListener(this);
		add(difficulty);
		
		
		startbutton = new JButton("Start Game");
		startbutton.setBounds(250, 450, 250, 50);
		startbutton.setFont(new Font("Product Sans", Font.PLAIN, 22));
		startbutton.setFocusable(false);
		startbutton.addActionListener(this);
		add(startbutton);
		
		restartbutton = new JButton("Restart Game");
		restartbutton.setBounds(550, 450, 250, 50);
		restartbutton.setFont(new Font("Product Sans", Font.PLAIN, 22));
		restartbutton.setFocusable(false);
		restartbutton.addActionListener(this);
		add(restartbutton);
		
		
		setTitle("Bubble Burst");
		setSize(1080, 720);
		getContentPane().setBackground(Color.black);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==startbutton) {
			String name = inputbox.getText();
			
			inputbox.setEditable(false);
			startbutton.setEnabled(false);
			difficulty.setEnabled(false);
			
			new GameFrame(name,level);
			
			System.out.println(name);
			System.out.println(level);
		}
		else if(e.getSource()==restartbutton) {
			inputbox.setText("NoobMaster69");
			inputbox.setEditable(true);
			startbutton.setEnabled(true);
			difficulty.setEnabled(true);
		}
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		level = difficulty.getValue();
	}
}