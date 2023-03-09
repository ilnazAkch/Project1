package taxcalculator;

// ��������� ��� ������������ ����
// ���������, ����� ����� ���� ����������� �������������� �����������,
// ��� ��� � ���������� ��� ����� ���� �������� �� ������ ������� ��������������� (� ������ ���� �� ���������)
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