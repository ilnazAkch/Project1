package taxcalculator;

//Интефрейс для калькулятора налогового вычета
//Необходим, чтобы можно было динамически переопределять калькулятор,
//Так как в дальнейшем они могут быть основаны на разных версиях закнодательства (В теории было бы интересно)
public interface PersonalIncomeTaxDeductionCalculator {
	public int getChildcareCount();
	public void setChildcareCount(int childcareCount);
	public int getDisabledChildrenCount();
	public void setDisabledChildrenCount(int disabledСhildrenСount);
	public boolean isSingleParent();
	public void setSingleParent(boolean isSingleParent);
	public double getPersonalIncomeTaxDeduction();
}