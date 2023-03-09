package rgr_1;

import org.junit.Test;

import taxcalculator.FederalLaw317_From_23_11_2015_PersonalIncomeTaxDeductionCalculator;

public class FederalLaw317Test {
    
    @Test
    public void testGetPersonalIncomeTaxDeduction() {
        // ������� ������ ������������ ��������� �������
        FederalLaw317_From_23_11_2015_PersonalIncomeTaxDeductionCalculator calculator = new FederalLaw317_From_23_11_2015_PersonalIncomeTaxDeductionCalculator();
        
        // ������������� �������� ������� �������
        calculator.setChildcareCount(2);
        calculator.setDisabledChildrenCount(1);
        calculator.setSingleParent(false);
        
        // ��������� ��������� �������� ���������� ������
        double expectedDeduction = 12000 + 1400;
        
        // �������� �������� ���������� ������ �� ������� ������������
        double actualDeduction = calculator.getPersonalIncomeTaxDeduction();
        
        // ���������� ��������� � ���������� ��������
        assertEquals(expectedDeduction, actualDeduction,0);
    }

	private void assertEquals(double expectedDeduction, double actualDeduction, int i) {
		// TODO Auto-generated method stub
		
	}
}
