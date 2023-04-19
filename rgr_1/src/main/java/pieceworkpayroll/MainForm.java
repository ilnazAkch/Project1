package pieceworkpayroll;

import taxcalculator.FederalLaw372_From_23_11_2020_PersonalIncomeTaxCalculator;
import taxcalculator.PersonalIncomeTaxCalculator;

// ������� ���������� �� �������� ���������� �����,
// ���������� �������� ���������� ��������,
// � �������� ������������ ������� - ������ Listeners
public class MainForm {
	private MainForm() {}; // ����� �������� �������� (��������) � �� ����� �����������
	
	public static final double DISTRICT_COEFFICIENT = 1.15; // �������� ������������ (������������)

    private static final int SINGLE_PARENT_INDEX = 1; // ������ ��������-�������� � �����-����� (��� 0 - false)
    // ��������� ������������ ����
    // � ������ ������ ������������ �����������, ���������� ��
    // ����������� ������ �372 �� 23 ������ 2020 ����
	private static final PersonalIncomeTaxCalculator TAX_CALCULATOR =  new FederalLaw372_From_23_11_2020_PersonalIncomeTaxCalculator();
	
	// ������������� ������� ����� ���������
	static void initialize() {
		Designer.initialize(); // ������������� ���������
		Listeners.initialize(); // ������������� ������������
	}
    
	// ������� ��� �������� ���������� ������ � ������ ��������,
	static void calculate() {
		CalculatingParams params = readParams(); // ��������� ���������� �� ���������
		
		// ������� ��������� ������������
		TAX_CALCULATOR.setSalary(params.count * params.price);
		TAX_CALCULATOR.setDistrictCoefficient(DISTRICT_COEFFICIENT);
		TAX_CALCULATOR.setChildcareCount(params.childcareCount);
		TAX_CALCULATOR.setDisabledChildrenCount(params.disabledChildrenCount);
		TAX_CALCULATOR.setSingleParent(params.isSingleParent);
        
        // �������� �� ������������ ��������� �����
        double personalIncomeTaxDeduction = TAX_CALCULATOR.getPersonalIncomeTaxDeduction();
        // �������� �� ������������ ������ ��������
        double netSalary = TAX_CALCULATOR.getNetSalary();

        printResult(personalIncomeTaxDeduction, netSalary); // ����� ���������� ����� ��������
    }
	
	// ����� ��� �������� ����������, ����������� ��� �������� ���������� ������ � ������ ��������
	public static class CalculatingParams {
	    public int count; // ����� �������
	    public double price; // ���� ������ �������
	    public int childcareCount; // ����� ����� �����
	    public int disabledChildrenCount; // ����� �����-���������
	    public boolean isSingleParent; // �������� �� ���������������� ���������-���������
	    
	    public CalculatingParams(int count, double price, int childcareCount, int disabledChildrenCount, boolean isSingleParent) {
	        this.count = count;
	        this.price = price;
	        this.childcareCount = childcareCount;
	        this.disabledChildrenCount = disabledChildrenCount;
	        this.isSingleParent = isSingleParent;
	    }
	}
	
	
	// ������� ��� ��������� ����������, ����������� ��� �������� ���������� ������ � ������ ��������
	// �� ���������
	 public static CalculatingParams readParams() {
        int count = (int) Designer.jSpinnerDetailsCount.getValue(); // ��������� ����� �������
        double price = (double) Designer.jSpinnerDetailPrice.getValue(); // ��������� ���� ������ �������
        int childcareCount = (int) Designer.jSpinnerChildcareCount.getValue(); // ��������� ������ ����� �����
        int disabledChildrenCount = (int) Designer.jSpinnerDisabledChildrenCount.getValue(); // ��������� ����� ����� ���������
        boolean isSingleParent = Designer.jComboBoxIsSingleParent.getSelectedIndex() == SINGLE_PARENT_INDEX; // ��������, ��� ������ �����-����� ����� ��������-��������
        
        // ������� ���������� �������� � ������� ������������ ������
        return new CalculatingParams(count, price, childcareCount, disabledChildrenCount, isSingleParent);
	}

	// ������� ������ ���������� ������ � ������ �������� ����� ��������
    static void printResult(double personal_income_tax_deduction, double net_salary) {
    	// ������ �� ����� ���������� ������
    	Designer.jLabelPersonalIncomeTaxDeduction.setText(Designer.LABEL_PERSONAL_INCOME_TAX_DEDUCTION_INIT_TEXT + personal_income_tax_deduction);
    	// ����� �� ����� ������ ��������
    	Designer.jLabelSalary.setText(Designer.LABEL_SALARY_INIT_TEXT + net_salary);
    }
}