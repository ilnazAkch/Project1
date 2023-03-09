package taxcalculator;

//Калькулятор НДФЛ, основанный на федеральном законе №372 от 23 ноября 2020 года
public class FederalLaw372_From_23_11_2020_PersonalIncomeTaxCalculator implements PersonalIncomeTaxCalculator {
	// Конструктор без параметров
	public FederalLaw372_From_23_11_2020_PersonalIncomeTaxCalculator() {
		mSalary = 0;
		mDistrictCoefficient = 1;
		mChildcareCount = 0;
		mDisabledChildrenCount = 0;
		mIsSingleParent = false;
	}
	
	// Конструктор, где указаны только зарлпата и районный коэффициент
	public FederalLaw372_From_23_11_2020_PersonalIncomeTaxCalculator(double salary, double districtCoefficient) {
		setSalary(salary);
		setDistrictCoefficient(districtCoefficient);
		mChildcareCount = 0;
		mDisabledChildrenCount = 0;
		mIsSingleParent = false;
	}
	
	// Конструктор для всех параметров
	public FederalLaw372_From_23_11_2020_PersonalIncomeTaxCalculator(
			double salary,
			double districtCoefficient,
			int childcareCount,
			int disabledChildrenCount,
			boolean isSingleParent) {
		setSalary(salary);
		setDistrictCoefficient(districtCoefficient);
		setChildcareCount(childcareCount);
		setDisabledChildrenCount(disabledChildrenCount);
		mIsSingleParent = isSingleParent;
	}
	
	// Для текущей редакции закона, будем считать, что налог составляет 13%
	public static final double TAX_RATE = 0.13;
	
	// В качетсве калькулятора налогового вычета будем применять калькулятор,
	// основанный на федеральном законе №317 от 23 ноября 2015 года
	public static final PersonalIncomeTaxDeductionCalculator DEDUCTION_CALCULATOR =
			new FederalLaw317_From_23_11_2015_PersonalIncomeTaxDeductionCalculator();
	
	private double mSalary;
	private double mDistrictCoefficient;
	private int mChildcareCount;
	private int mDisabledChildrenCount;
	private boolean mIsSingleParent;
	
	// Сеттеры и геттеры:

	public double getSalary() {
		return mSalary;
	}

	public void setSalary(double salary) {
		if (salary < 0)
			throw new IllegalArgumentException("Зарплата не может быть меньше 0!");
		this.mSalary = salary;
	}

	public double getDistrictCoefficient() {
		return mDistrictCoefficient;
	}

	public void setDistrictCoefficient(double districtCoefficient) {
		if (districtCoefficient <= 0)
			throw new IllegalArgumentException("Районный коэффциент не может быть меньше или равен 0!");
		this.mDistrictCoefficient = districtCoefficient;
	}

	public int getChildcareCount() {
		return mChildcareCount;
	}

	public void setChildcareCount(int childcareCount) {
		if (childcareCount < 0)
			throw new IllegalArgumentException("Число детей не может быть меньше 0!");
		this.mChildcareCount = childcareCount;
	}

	public int getDisabledChildrenCount() {
		return mDisabledChildrenCount;
	}

	public void setDisabledChildrenCount(int disabledChildrenCount) {
		if (disabledChildrenCount < 0)
			throw new IllegalArgumentException("Число детей не может быть меньше 0!");
		this.mDisabledChildrenCount = disabledChildrenCount;
	}

	public boolean isSingleParent() {
		return mIsSingleParent;
	}

	public void setSingleParent(boolean singleParent) {
		mIsSingleParent = singleParent;
	}
	
	
	// Функция для получения райнонной зарлаты (умножение на районный коэффициент)
	public double getDistrictSalary()
	{
		return mSalary * mDistrictCoefficient;
	}
	
	// Функция для получения чистой зарплаты (Разность районной зарлпаты и размера НДФЛ)
	public double getNetSalary()
    {
        return getDistrictSalary() - getPersonalIncomeTax();
    }
    
	// Функция для получения размера НДФЛ с учётом налогового вычета
    public double getPersonalIncomeTax()
    {
        double personalIncomeTaxDeduction = getPersonalIncomeTaxDeduction(); // Получаем размер налогового вычета
        double districtSalary = getDistrictSalary(); // Полуачем размер районно зарлпаты
    	if (personalIncomeTaxDeduction >= districtSalary) // Если размер вычета больше, чем размер ЗП, то налога нет
        	return 0;
    	// Иначе, возращаем фиксированный процент от разности районной зарлпаты и налогового вычета
    	return (districtSalary - personalIncomeTaxDeduction) * TAX_RATE;
    }
    
    // Функция для подсчёта налогового вычета
    public double getPersonalIncomeTaxDeduction() {
    	// Передаём калькулятору число детей, детей-инвалидов и информацию о том, является ли налогоплательшик родителем-одиночкой
		DEDUCTION_CALCULATOR.setChildcareCount(mChildcareCount);
		DEDUCTION_CALCULATOR.setDisabledChildrenCount(mDisabledChildrenCount);
		DEDUCTION_CALCULATOR.setSingleParent(mIsSingleParent);
		// Возвращаем полученный налоговый вычет
    	return DEDUCTION_CALCULATOR.getPersonalIncomeTaxDeduction();
    }
}