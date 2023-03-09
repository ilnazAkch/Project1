package taxcalculator;

//��������� ��� ������������ ���������� ������
//���������, ����� ����� ���� ����������� �������������� �����������,
//��� ��� � ���������� ��� ����� ���� �������� �� ������ ������� ��������������� (� ������ ���� �� ���������)
public interface PersonalIncomeTaxDeductionCalculator {
	public int getChildcareCount();
	public void setChildcareCount(int childcareCount);
	public int getDisabledChildrenCount();
	public void setDisabledChildrenCount(int disabled�hildren�ount);
	public boolean isSingleParent();
	public void setSingleParent(boolean isSingleParent);
	public double getPersonalIncomeTaxDeduction();
}