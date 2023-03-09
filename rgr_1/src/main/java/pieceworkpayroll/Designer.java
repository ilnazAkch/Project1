package pieceworkpayroll;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;






// �����, ���������� �� ���������� ����� ���������, �.�. ���������
public class Designer {
	private Designer() {} // ����� �������� �������� (��������) � �� ����� �����������
	
	// ���� ������� ���������� � ������������� ��������� ����������:
	
	// �������: "���������� �������:"
    public static JLabel jLabelDetailsCount = new JLabel("���������� �������:");
    
    // ������� ��� ����� ���������� �������
    // �������� �� ���������: 1
    // ������������ ��������: 1
    // ������������ ��������: 999999999
    // �������������
    public static JSpinner jSpinnerDetailsCount = new JSpinner(new SpinnerNumberModel(1, 1, 999999999, 1));

	// �������: "���� ����� ������:"
    public static JLabel jLabelDetailPrice = new JLabel("���� ����� ������:");
    
    // ������� ��� ����� ���� ����� ������
    // �������� �� ���������: 0
    // ������������ ��������: 0
    // ������������ ��������: 999999999
    // ������������
    public static JSpinner jSpinnerDetailPrice = new JSpinner(new SpinnerNumberModel(0.00, 0.00, 999999999, 1.0));

	// �������: "���� �� ����������:"
    static JLabel jLabelChildcareCount = new JLabel("���� �� ����������:");
    
    // ������� ��� ����� ������ ����� ����� �� ����������
    // �������� �� ���������: 0
    // ������������ ��������: 0
    // ������������ ��������: 999999999
    // �������������
    public static JSpinner jSpinnerChildcareCount = new JSpinner(new SpinnerNumberModel(0, 0, 999999999, 1));

	// �������: "�� ��� �����-���������:"
    static JLabel jLabelDisabledChildrenCount = new JLabel("�� ��� �����-���������:");
    
    // ������� ��� ����� ����� �����-��������� �� ����������
    // �������� �� ���������: 0
    // ������������ ��������: 0
    // ������������ ��������: 999999999
    // �������������
    static JSpinner jSpinnerDisabledChildrenCount = new JSpinner(new SpinnerNumberModel(0, 0, 999999999, 1));

	// �������: "��������-��������?"
    static JLabel jLabelIsSingleParent = new JLabel("��������-��������?");
    
    // �������� ��� ����������� ������ jComboBoxIsSingleParent:
    // 0) "���"
    // 1) "�� - ������� x 2"
    static final String[] isSingleParentOptions = {"���", "�� - ������� x 2"};
    
    // ���������� ������, ���������� �� ������� isSingleParentOptions
    static JComboBox<String> jComboBoxIsSingleParent = new JComboBox<String>(isSingleParentOptions);

    static final String LABEL_PERSONAL_INCOME_TAX_DEDUCTION_INIT_TEXT = "����� �� ���������� ��������: ";
    
	// �������: "����� �� ���������� ��������: "
    static JLabel jLabelPersonalIncomeTaxDeduction = new JLabel(LABEL_PERSONAL_INCOME_TAX_DEDUCTION_INIT_TEXT);

    static final String LABEL_SALARY_INIT_TEXT = "�������� �� �����: ";
    
	// �������: "�������� �� �����: "
    static JLabel jLabelSalary = new JLabel(LABEL_SALARY_INIT_TEXT);
    
    public static JButton PDFnew = new JButton("PDF");

	
    // ������������� ����������
	public static void initialize() {
        JFrame frame = createFrame(); // ������ �����
        fillFrame(frame); // ��������� �����
        frame.setVisible(true); // ������ ����� �������
	}
	
	// ������� ��� �������� ������ (�������� ����)
	static JFrame createFrame() {
		JFrame frame = new JFrame("���� ������"); // ������ ��������� ������ � ���������� "���� ������"
		
		 // ������ ��������� ������� ��� ������� ������� ����� ����������� ��������� ��������
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350,256); // ������������ ������ ������ 350, � ������ - 256
        // ��������� ������� ������������ ������ �������� ���� � ����������� �� 256 �������� �� ����������� � 128 - �� ���������
        frame.setLocation(256, 128);
        
        return frame; // ��������� ������������ �����
	}
	
	// ������� ��� ���������� ������ ������������
	static void fillFrame(JFrame frame) {
        Container container = frame.getContentPane(); // �������� ��������� ������
        container.setLayout(new FlowLayout(FlowLayout.LEFT)); // ������������ ������ ���������� ������������ �� ������ ����
        
        // ��������� ��� ��������� ����������
        // �����! ���������� �������� � ��� �� �������, � ������� ��� ���������
        // ��� ����� ������� ����������
        container.add(jLabelDetailsCount);
        container.add(jSpinnerDetailsCount);
        container.add(jLabelDetailPrice);
        container.add(jSpinnerDetailPrice);
        container.add(jLabelChildcareCount);
        container.add(jSpinnerChildcareCount);
        container.add(jLabelDisabledChildrenCount);
        container.add(jSpinnerDisabledChildrenCount);
        container.add(jLabelIsSingleParent);
        container.add(jComboBoxIsSingleParent);
        container.add(jLabelPersonalIncomeTaxDeduction);
        container.add(jLabelSalary);
        container.add(PDFnew);
	}
}