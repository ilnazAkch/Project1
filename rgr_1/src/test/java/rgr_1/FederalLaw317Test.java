package rgr_1;

import org.junit.Test;

import taxcalculator.FederalLaw317_From_23_11_2015_PersonalIncomeTaxDeductionCalculator;

public class FederalLaw317Test {
    
    @Test
    public void testGetPersonalIncomeTaxDeduction() {
        // Создаем объект калькулятора налоговых вычетов
        FederalLaw317_From_23_11_2015_PersonalIncomeTaxDeductionCalculator calculator = new FederalLaw317_From_23_11_2015_PersonalIncomeTaxDeductionCalculator();
        
        // Устанавливаем значения свойств объекта
        calculator.setChildcareCount(2);
        calculator.setDisabledChildrenCount(1);
        calculator.setSingleParent(false);
        
        // Вычисляем ожидаемое значение налогового вычета
        double expectedDeduction = 12000 + 1400;
        
        // Получаем значение налогового вычета от объекта калькулятора
        double actualDeduction = calculator.getPersonalIncomeTaxDeduction();
        
        // Сравниваем ожидаемое и полученное значения
        assertEquals(expectedDeduction, actualDeduction,0);
    }

	private void assertEquals(double expectedDeduction, double actualDeduction, int i) {
		// TODO Auto-generated method stub
		
	}
}
