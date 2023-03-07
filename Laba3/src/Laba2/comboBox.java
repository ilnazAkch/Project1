package Laba2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

public class comboBox implements ActionListener {
	private  JLabel label;
	private  JFrame main_GUI;
	private  String message;
	private  JComboBox combobox;
	private  int q;
	
    public comboBox(JLabel label, JFrame main_GUI, String message, JComboBox combobox, int q) { 
		
        this.label = label;
        this.main_GUI = main_GUI;
        this.message = message;
        this.combobox = combobox;
		this.q = q;
       
    }
    
public void actionPerformed(ActionEvent e) {
		
		String s = (String)combobox.getSelectedItem();
		if (s == "Sort data in project1") {
			main_GUI.add(label);
			main_GUI.repaint();
			JOptionPane.showMessageDialog(new JFrame(), "Sort data");
		}
		else if (Image.q == 1) {
		if (s == "логотип справа") {
			label.setBounds(280, -40, 203, 201);
			main_GUI.add(label);
		    main_GUI.repaint();
		}
		if (s == "логотип по центру") {
			label.setBounds(150, 100, 203, 201);
			main_GUI.add(label);
			main_GUI.repaint();
		}
		if (s == "логотип слева") {
			label.setBounds(5, -40, 203, 201);
			main_GUI.add(label);
			main_GUI.repaint();
		}
		}
		else {
			JOptionPane.showMessageDialog(new JFrame(), message, "Error",JOptionPane.WARNING_MESSAGE);
		}
	}
		
	}