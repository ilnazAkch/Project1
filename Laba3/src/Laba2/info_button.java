package Laba2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class info_button implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		JFrame infoo = new JFrame("Информация");
		infoo.setTitle ("Students");
		infoo.setSize(400,400);
		infoo.setResizable(false);
		infoo.setLocationRelativeTo(null);
		infoo.setLayout(null);
		infoo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		infoo.setVisible(true);
		
		JButton button1 = new JButton("Назад");
		button1.setBounds(140, 250, 100, 40);
		infoo.add(button1);
		button1.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				infoo.dispose();
			}
		});
		
		JLabel one = new JLabel("Акчулпанов Ильназ Рафаэлевич № 218");
		JLabel two = new JLabel("Давлетов Альберт Ильдарович № 047 ");
		JLabel three = new JLabel("Тамочкин Илья Валерьевич № 688");

		
		infoo.add(one);
		infoo.add(two);
		infoo.add(three);

		
		one.setBounds(20,20,250,200);
		two.setBounds(20,40,250,200);
		three.setBounds(20,60,250,200);

		
        }
}

