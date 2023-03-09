package taxcalculator;

//����������� ����, ���������� �� ����������� ������ �372 �� 23 ������ 2020 ����
public class FederalLaw372_From_23_11_2020_PersonalIncomeTaxCalculator implements PersonalIncomeTaxCalculator {
	// ����������� ��� ����������
	public FederalLaw372_From_23_11_2020_PersonalIncomeTaxCalculator() {
		mSalary = 0;
		mDistrictCoefficient = 1;
		mChildcareCount = 0;
		mDisabledChildrenCount = 0;
		mIsSingleParent = false;
	}
	
	// �����������, ��� ������� ������ �������� � �������� �����������
	public FederalLaw372_From_23_11_2020_PersonalIncomeTaxCalculator(double salary, double districtCoefficient) {
		setSalary(salary);
		setDistrictCoefficient(districtCoefficient);
		mChildcareCount = 0;
		mDisabledChildrenCount = 0;
		mIsSingleParent = false;
	}
	
	// ����������� ��� ���� ����������
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
	
	// ��� ������� �������� ������, ����� �������, ��� ����� ���������� 13%
	public static final double TAX_RATE = 0.13;
	
	// � �������� ������������ ���������� ������ ����� ��������� �����������,
	// ���������� �� ����������� ������ �317 �� 23 ������ 2015 ����
	public static final PersonalIncomeTaxDeductionCalculator DEDUCTION_CALCULATOR =
			new FederalLaw317_From_23_11_2015_PersonalIncomeTaxDeductionCalculator();
	
	private double mSalary;
	private double mDistrictCoefficient;
	private int mChildcareCount;
	private int mDisabledChildrenCount;
	private boolean mIsSingleParent;
	
	// ������� � �������:

	public double getSalary() {
		return mSalary;
	}

	public void setSalary(double salary) {
		if (salary < 0)
			throw new IllegalArgumentException("�������� �� ����� ���� ������ 0!");
		this.mSalary = salary;
	}

	public double getDistrictCoefficient() {
		return mDistrictCoefficient;
	}

	public void setDistrictCoefficient(double districtCoefficient) {
		if (districtCoefficient <= 0)
			throw new IllegalArgumentException("�������� ���������� �� ����� ���� ������ ��� ����� 0!");
		this.mDistrictCoefficient = districtCoefficient;
	}

	public int getChildcareCount() {
		return mChildcareCount;
	}

	public void setChildcareCount(int childcareCount) {
		if (childcareCount < 0)
			throw new IllegalArgumentException("����� ����� �� ����� ���� ������ 0!");
		this.mChildcareCount = childcareCount;
	}

	public int getDisabledChildrenCount() {
		return mDisabledChildrenCount;
	}

	public void setDisabledChildrenCount(int disabledChildrenCount) {
		if (disabledChildrenCount < 0)
			throw new IllegalArgumentException("����� ����� �� ����� ���� ������ 0!");
		this.mDisabledChildrenCount = disabledChildrenCount;
	}

	public boolean isSingleParent() {
		return mIsSingleParent;
	}

	public void setSingleParent(boolean singleParent) {
		mIsSingleParent = singleParent;
	}
	
	
	// ������� ��� ��������� ��������� ������� (��������� �� �������� �����������)
	public double getDistrictSalary()
	{
		return mSalary * mDistrictCoefficient;
	}
	
	// ������� ��� ��������� ������ �������� (�������� �������� �������� � ������� ����)
	public double getNetSalary()
    {
        return getDistrictSalary() - getPersonalIncomeTax();
    }
    
	// ������� ��� ��������� ������� ���� � ������ ���������� ������
    public double getPersonalIncomeTax()
    {
        double personalIncomeTaxDeduction = getPersonalIncomeTaxDeduction(); // �������� ������ ���������� ������
        double districtSalary = getDistrictSalary(); // �������� ������ ������� ��������
    	if (personalIncomeTaxDeduction >= districtSalary) // ���� ������ ������ ������, ��� ������ ��, �� ������ ���
        	return 0;
    	// �����, ��������� ������������� ������� �� �������� �������� �������� � ���������� ������
    	return (districtSalary - personalIncomeTaxDeduction) * TAX_RATE;
    }
    
    // ������� ��� �������� ���������� ������
    public double getPersonalIncomeTaxDeduction() {
    	// ������� ������������ ����� �����, �����-��������� � ���������� � ���, �������� �� ���������������� ���������-���������
		DEDUCTION_CALCULATOR.setChildcareCount(mChildcareCount);
		DEDUCTION_CALCULATOR.setDisabledChildrenCount(mDisabledChildrenCount);
		DEDUCTION_CALCULATOR.setSingleParent(mIsSingleParent);
		// ���������� ���������� ��������� �����
    	return DEDUCTION_CALCULATOR.getPersonalIncomeTaxDeduction();
    }
}