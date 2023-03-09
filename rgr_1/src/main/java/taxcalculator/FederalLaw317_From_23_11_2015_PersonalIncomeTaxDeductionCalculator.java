package taxcalculator;

// Калькулятор налогово вычета, основанный на федеральном законе №317 от 23 ноября 2015 года
public class FederalLaw317_From_23_11_2015_PersonalIncomeTaxDeductionCalculator implements PersonalIncomeTaxDeductionCalculator {
	// Контруктор без параметров
	public FederalLaw317_From_23_11_2015_PersonalIncomeTaxDeductionCalculator() {
		// По умолчанию:
		mChildcareCount = 0; // Общее число детей равно 0 
		mDisabledChildrenCount = 0; // Число детей-инвалидов равно 0
		mIsSingleParent = false; // Налогоплательщик не является родителем-одиночкой
	}
	
	// Конструктор с параметрами
	public FederalLaw317_From_23_11_2015_PersonalIncomeTaxDeductionCalculator(
			int childcareCount,
			int disabledChildrenCount,
			boolean isSingleParent) {
		setChildcareCount(childcareCount);
		setDisabledChildrenCount(disabledChildrenCount);
		mIsSingleParent = isSingleParent;
	}
	
	public static final int TAX_DEDUCTION_FOR_DISABLED_CHILD = 12000; // Вычет за ребёнка-инвалида
	public static final int TAX_DEDUCTION_FOR_FIRST_CHILD = 1400; // Вычет за первого ребёнка (не инвалид)
	public static final int TAX_DEDUCTION_FOR_SECOND_CHILD = 2800; // Вычет за второго ребёнка  (не инвалид)
	public static final int TAX_DEDUCTION_FOR_THIRD_CHILD = 5800; // Вычет за третьего ребёнка (не инвалид)
	public static final int TAX_DEDUCTION_FOR_NEXT_CHILD = 3000; // Вычет за каждого последующего ребёнка (не инвалид)
	public static final int SINGLE_PARENT_COEFFICIENT = 2; // Коэффциент умножения вычета для родиелей-одиночек
	
	private int mChildcareCount; // Общее число детей на содержании
	private int mDisabledChildrenCount; // Число детей инвалидов на содержании
	private boolean mIsSingleParent; // Является ли налогоплателищик родителем-одиночкой

	// Геттеры и сеттеры:
	
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

	public void setDisabledChildrenCount(int disabledСhildrenСount) {
		if (disabledСhildrenСount < 0)
			throw new IllegalArgumentException("Число детей не может быть меньше 0!");
		this.mDisabledChildrenCount = disabledСhildrenСount;
	}

	public boolean isSingleParent() {
		return mIsSingleParent;
	}

	public void setSingleParent(boolean isSingleParent) {
		this.mIsSingleParent = isSingleParent;
	}
	
	// Функция для получения объёма налогового вычета
	public double getPersonalIncomeTaxDeduction() {
		// Во первых: за каждого ребёнка-инвалида начисляется фиксированная сумма
        double personalIncomeTaxDeduction = TAX_DEDUCTION_FOR_DISABLED_CHILD * mDisabledChildrenCount;
        
        // Так как дети-инвалиды учтены, уменьшаем общее число детей для подсчёта
        int remainingСhildcareCount = mChildcareCount - mDisabledChildrenCount;
        
        // Затем к вычету добавлем конкретные фиксированные суммы вплоть до 3 детей
        // Для каждого послеюущего начисляется фиксированная сумма
        switch (remainingСhildcareCount)
        {
            case 0:
                break;
            case 1:
                personalIncomeTaxDeduction += TAX_DEDUCTION_FOR_FIRST_CHILD;
                break;
            case 2:
                personalIncomeTaxDeduction += TAX_DEDUCTION_FOR_SECOND_CHILD;
                break;
            case 3:
                personalIncomeTaxDeduction += TAX_DEDUCTION_FOR_THIRD_CHILD;
                break;
            default:
                personalIncomeTaxDeduction += TAX_DEDUCTION_FOR_THIRD_CHILD + TAX_DEDUCTION_FOR_NEXT_CHILD * (remainingСhildcareCount - 3);
                break;
        }
        
        // Если налогоплательшик является родителем-одиночкой, то налоговый вычет умножается на фиксированный коэффициент
        if (mIsSingleParent)
            personalIncomeTaxDeduction *= SINGLE_PARENT_COEFFICIENT;

        return personalIncomeTaxDeduction; // Возарщаем полученный налоговый вычет
    }
}
