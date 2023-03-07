package Laba2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Image implements ActionListener{
	static int q = 1;
	private JLabel label;
	private JFrame main_GUI;
	
	public Image(int q, JLabel label, JFrame main_GUI) {
		this.q = q;
		this.label = label;
		this.main_GUI = main_GUI;
	}
	
	public int get_q(int q) {
		return this.q;
	}
	
	
	public void actionPerformed(ActionEvent e)
	{
		//Display Image
		q = 1;
		label.setBounds(280, -40, 203, 201);
		main_GUI.add(label);
		main_GUI.repaint();
	
		
	}
}



	
