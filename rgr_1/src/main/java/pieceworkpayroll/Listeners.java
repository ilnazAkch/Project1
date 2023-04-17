package pieceworkpayroll;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


// �����, ���������� �� ���������� ������������ ������� ��� �����������, ��������� ����������
public class Listeners {
	private Listeners() {} // ����� �������� �������� (��������) � �� ����� �����������
	
	// ������������� ������������
	static void initialize() {
		// ���������� ������� ��������� �������� ����������:
		ChangeListener calculatingChangeListener = new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				MainForm.calculate(); // � ����� ������ ������� ���������� ����
			}
		};

		// ���������� ������� ��������� ���������� �������� ����������� ������:
		ItemListener calculatingItemListener = new ItemListener() {
			public void itemStateChanged(ItemEvent event) {
				MainForm.calculate(); // � ����� ������ ������� ���������� ����
			}
		};

		// ���������� ������� ��������� �������� �����������, ���������� �� ����� �����:
		ChangeListener anyChildChangeListener = new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				checkDisabledChildrenCountLessThanChildcareCount(); // � ����� ������, ���������, ��� ����� ����� ��������� �� ������ ������ ����� �����
				MainForm.calculate(); // � ������� ���������� ����
			}
		};
		
		
		ActionListener actiongrafik = new ListenerPDF();
		Designer.PDFnew.addActionListener(actiongrafik);
		Designer.ExitButt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // �������� ����������
                System.exit(0);
            }
        });
		
		// ��������� �������� ����������� ���:
		Designer.jSpinnerDetailsCount.addChangeListener(calculatingChangeListener); // �������� ����� �������
		Designer.jSpinnerDetailPrice.addChangeListener(calculatingChangeListener); // �������� ���� ����� ������
		Designer.jComboBoxIsSingleParent.addItemListener(calculatingItemListener); // ����������� ������, ��� �������� ����, ��� ���������������� �������� ���������-���������
		
		Designer.jSpinnerChildcareCount.addChangeListener(anyChildChangeListener); // �������� ������ ����� ����� �� ����������
		Designer.jSpinnerDisabledChildrenCount.addChangeListener(anyChildChangeListener); // �������� ����� �����-��������� �� ����������
		
	}
	
	// ������� ��� �������� ����, ��� ����� �����-��������� ������, ��� ����� ����� �����
	// � ���� ������: ����� �����-��������� ����� ���������� � ������ ����� �����
	public static void checkDisabledChildrenCountLessThanChildcareCount() {
		if (((Number) Designer.jSpinnerDisabledChildrenCount.getValue()).intValue() > ((Number) Designer.jSpinnerChildcareCount.getValue()).intValue())
        	Designer.jSpinnerDisabledChildrenCount.setValue(Designer.jSpinnerChildcareCount.getValue());
    }
}