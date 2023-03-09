package taxcalculator;

// Интефрейс для калькулятора НДФЛ
// Необходим, чтобы можно было динамически переопределять калькулятор,
// Так как в дальнейшем они могут быть основаны на разных версиях закнодательства (В теории было бы интересно)
public interface PersonalIncomeTaxCalculator {
	public double getSalary();
	public void setSalary(double salary);
	public double getDistrictCoefficient();
	public void setDistrictCoefficient(double districtCoefficient);
	public int getChildcareCount();
	public void setChildcareCount(int childcareCount);
	public int getDisabledChildrenCount();
	public void setDisabledChildrenCount(int disabledChildrenCount);
	public boolean isSingleParent();
	public void setSingleParent(boolean singleParent);
	public double getDistrictSalary();
	public double getNetSalary();
    public double getPersonalIncomeTax();
    public double getPersonalIncomeTaxDeduction();
}