package pieceworkpayroll;

import taxcalculator.FederalLaw372_From_23_11_2020_PersonalIncomeTaxCalculator;
import taxcalculator.PersonalIncomeTaxCalculator;

// Функция отвечающая за основной функционал формы,
// Делегирует созданий интерфейса дизайнер,
// А создание обработчиков событий - классу Listeners
public class MainForm {
	private MainForm() {}; // Класс является утилитой (статичен) и не имеет экземпляров
	
	public static final double DISTRICT_COEFFICIENT = 1.15; // Районный коэффициаент (Башкортостан)

    private static final int SINGLE_PARENT_INDEX = 1; // Индекс родителя-одиночки в комбо-боксе (Ибо 0 - false)
    // Экземпляр калькулятора НДФЛ
    // В данном случае используется калькулятор, основанный на
    // Федеральном законе №372 от 23 ноября 2020 года
	private static final PersonalIncomeTaxCalculator TAX_CALCULATOR =  new FederalLaw372_From_23_11_2020_PersonalIncomeTaxCalculator();
	
	// Инициализация главной формы программы
	static void initialize() {
		Designer.initialize(); // Инициализация дизайнера
		Listeners.initialize(); // Инициализация обработчиков
	}
    
	// Функция для подсчёта налогового вычета и чистой зарплаты,
	static void calculate() {
		CalculatingParams params = readParams(); // Получение параметров из дизайнера
		
		// Передаём параметры калькулятору
		TAX_CALCULATOR.setSalary(params.count * params.price);
		TAX_CALCULATOR.setDistrictCoefficient(DISTRICT_COEFFICIENT);
		TAX_CALCULATOR.setChildcareCount(params.childcareCount);
		TAX_CALCULATOR.setDisabledChildrenCount(params.disabledChildrenCount);
		TAX_CALCULATOR.setSingleParent(params.isSingleParent);
        
        // Получаем от калькулятора налоговый вычет
        double personalIncomeTaxDeduction = TAX_CALCULATOR.getPersonalIncomeTaxDeduction();
        // Получаем от калькулятора чистую зарплату
        double netSalary = TAX_CALCULATOR.getNetSalary();

        printResult(personalIncomeTaxDeduction, netSalary); // Вывод результата через дизайнер
    }
	
	// Класс для хранения параметров, необходимых для подсчёта налогового вычета и чистой зарплаты
	public static class CalculatingParams {
	    public int count; // Число изделий
	    public double price; // Цена одного изделия
	    public int childcareCount; // Общее число детей
	    public int disabledChildrenCount; // Число детей-инвалидов
	    public boolean isSingleParent; // Является ли налогоплательщик родителем-одиночкой
	    
	    public CalculatingParams(int count, double price, int childcareCount, int disabledChildrenCount, boolean isSingleParent) {
	        this.count = count;
	        this.price = price;
	        this.childcareCount = childcareCount;
	        this.disabledChildrenCount = disabledChildrenCount;
	        this.isSingleParent = isSingleParent;
	    }
	}
	
	
	// Функция для получения параметров, необходимых для подсчёта налогового вычета и чистой зарплаты
	// От дизайнера
	 public static CalculatingParams readParams() {
        int count = (int) Designer.jSpinnerDetailsCount.getValue(); // Получение числа изделий
        double price = (double) Designer.jSpinnerDetailPrice.getValue(); // Получение цены одного изделия
        int childcareCount = (int) Designer.jSpinnerChildcareCount.getValue(); // Получения общего числа детей
        int disabledChildrenCount = (int) Designer.jSpinnerDisabledChildrenCount.getValue(); // Получение числа детей инвалидов
        boolean isSingleParent = Designer.jComboBoxIsSingleParent.getSelectedIndex() == SINGLE_PARENT_INDEX; // Проверка, что индекс комбо-бокса равен родителю-одиночке
        
        // Возврат полученных значений с помощью специального класса
        return new CalculatingParams(count, price, childcareCount, disabledChildrenCount, isSingleParent);
	}

	// Функция вывода налогового вычета и чистой зарплаты через дизайнер
    static void printResult(double personal_income_tax_deduction, double net_salary) {
    	// Вывода на форму налогового вычета
    	Designer.jLabelPersonalIncomeTaxDeduction.setText(Designer.LABEL_PERSONAL_INCOME_TAX_DEDUCTION_INIT_TEXT + personal_income_tax_deduction);
    	// Вывод на форму чистой зарплаты
    	Designer.jLabelSalary.setText(Designer.LABEL_SALARY_INIT_TEXT + net_salary);
    }
}