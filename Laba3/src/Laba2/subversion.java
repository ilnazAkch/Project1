package Laba2; //����� Java �������


import java.awt.event.ActionEvent;

import java.awt.event.ActionListener; //���������� ��� ������� ���������
import javax.swing.*; // ���������� ��� GUI (��������� �� ������ awt)
public class subversion implements ActionListener {
	private JFrame main_GUI;
	private JComboBox combobox;
	private JLabel label;
	private String message;
	private int q = 0;
	
	public subversion() {
		ImageIcon icon=new ImageIcon("src/Laba2/������� �����.jpg");
		label=new JLabel(icon);
		main_GUI = new JFrame("subversion");	// �������� ������������ ����
		main_GUI.setTitle ("Using subversion for developers");
		main_GUI.setSize(500,500);
		main_GUI.setResizable(false);
		main_GUI.setLocationRelativeTo(null);
		main_GUI.setLayout(null);
		main_GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel laba_info = new JLabel("������������ ������ �2"); // ����������� ������ ��� �����������
		laba_info.setBounds(10,10,150,30);
		JButton info_laba = new JButton("Info");
		info_laba.setBounds(350, 300, 120, 40);
		main_GUI.add(info_laba);
		ActionListener actionListener1 = new info_button();
		info_laba.addActionListener(actionListener1);
		JButton button_exit = new JButton("�����"); // ��������� ������
		button_exit.setBounds(350,350,120,40);
		main_GUI.add(button_exit);
		ActionListener actionListener = new ListenerButton(); //������� ���������
		button_exit.addActionListener(actionListener);
		
		JMenuBar jmenubar = new JMenuBar();
		main_GUI.setJMenuBar(jmenubar);
		JMenu menu = new JMenu("����");
		jmenubar.add(menu);
		JMenuItem menuItem1 = new JMenuItem ("���������� ������� �����");
		JMenuItem menuItem2 = new JMenuItem ("�����");
		menu.add(menuItem1);
		menu.add(menuItem2);
		
		JMenuItem menuItem3 = new JMenuItem ("��������� ���� � ������1");
		menu.add(menuItem3);
		
		ActionListener actionlistener3 = new Image(q, label, main_GUI);
		menuItem1.addActionListener(actionlistener3);
		
		combobox = new JComboBox();
		combobox.addItem("������� ������");
		combobox.addItem("������� �� ������");
		combobox.addItem("������� �����");
		combobox.addItem("������������� ������");
		combobox.setBounds(5, 350, 330, 40);
		main_GUI.add(combobox);
		message = "Display the logo in the menu";
        ActionListener actionlistener4 = new comboBox(label, main_GUI, message, combobox, q);
        combobox.addActionListener(actionlistener4);

		ActionListener vihod = new ListenerButton(); //������� ���������
		menuItem2.addActionListener(vihod);
		main_GUI.setVisible(true);
	
	
	main_GUI.setVisible(true);
	
	main_GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // �������� ���� JFrame � �������� Java
	
	
	}
	public static void main(String[] args) { 
		subversion student = new subversion();
		
	}
	
	}
