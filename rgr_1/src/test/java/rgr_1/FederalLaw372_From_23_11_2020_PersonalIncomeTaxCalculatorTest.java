package rgr_1;

import org.junit.Test;

import taxcalculator.FederalLaw372_From_23_11_2020_PersonalIncomeTaxCalculator;

import static org.junit.Assert.*;

public class FederalLaw372_From_23_11_2020_PersonalIncomeTaxCalculatorTest {

    // Проверка, что конструктор без параметров устанавливает все значения по умолчанию
    @Test
    public void testConstructorWithNoParams() {
        FederalLaw372_From_23_11_2020_PersonalIncomeTaxCalculator calculator = new FederalLaw372_From_23_11_2020_PersonalIncomeTaxCalculator();
        assertEquals(0, calculator.getSalary(), 0.0);
        assertEquals(1, calculator.getDistrictCoefficient(), 0.0);
        assertEquals(0, calculator.getChildcareCount());
        assertEquals(0, calculator.getDisabledChildrenCount());
        assertFalse(calculator.isSingleParent());
    }

    // Проверка, что конструктор с двумя параметрами устанавливает зарплату и районный коэффициент, а остальные значения по умолчанию
    @Test
    public void testConstructorWithTwoParams() {
        FederalLaw372_From_23_11_2020_PersonalIncomeTaxCalculator calculator = new FederalLaw372_From_23_11_2020_PersonalIncomeTaxCalculator(10000, 1.5);
        assertEquals(10000, calculator.getSalary(), 0.0);
        assertEquals(1.5, calculator.getDistrictCoefficient(), 0.0);
        assertEquals(0, calculator.getChildcareCount());
        assertEquals(0, calculator.getDisabledChildrenCount());
        assertFalse(calculator.isSingleParent());
    }

   
}
  
   
