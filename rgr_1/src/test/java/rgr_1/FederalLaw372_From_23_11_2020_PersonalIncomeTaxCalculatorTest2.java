package rgr_1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import taxcalculator.FederalLaw372_From_23_11_2020_PersonalIncomeTaxCalculator;


public class FederalLaw372_From_23_11_2020_PersonalIncomeTaxCalculatorTest2 {

  
	 // Проверка, что конструктор со всеми параметрами устанавливает все значения правильно
    @Test
    public void testConstructorWithAllParams() {
        FederalLaw372_From_23_11_2020_PersonalIncomeTaxCalculator calculator = new FederalLaw372_From_23_11_2020_PersonalIncomeTaxCalculator(10000, 1.5, 2, 1, true);
        assertEquals(10000, calculator.getSalary(), 0.0);
        assertEquals(1.5, calculator.getDistrictCoefficient(), 0.0);
        assertEquals(2, calculator.getChildcareCount());
        assertEquals(1, calculator.getDisabledChildrenCount());
        assertTrue(calculator.isSingleParent());
    }
    // Проверка, что при установке отрицательной зарплаты выбрасывается IllegalArgumentException
    @Test(expected = IllegalArgumentException.class)
    public void testSetSalaryWithNegativeValue() {
        FederalLaw372_From_23_11_2020_PersonalIncomeTaxCalculator calculator = new FederalLaw372_From_23_11_2020_PersonalIncomeTaxCalculator();
        calculator.setSalary(-1);
    }

    // Проверка, что при установке отрицательного районного коэффициента выбрасывается IllegalArgumentException
    @Test(expected = IllegalArgumentException.class)
    public void testSetDistrictCoefficientWithNegativeValue() {
        FederalLaw372_From_23_11_2020_PersonalIncomeTaxCalculator calculator = new FederalLaw372_From_23_11_2020_PersonalIncomeTaxCalculator();
        calculator.setDistrictCoefficient(-1);
    }
}
  
   
