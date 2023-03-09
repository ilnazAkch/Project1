package taxcalculator;

// ����������� �������� ������, ���������� �� ����������� ������ �317 �� 23 ������ 2015 ����
public class FederalLaw317_From_23_11_2015_PersonalIncomeTaxDeductionCalculator implements PersonalIncomeTaxDeductionCalculator {
	// ���������� ��� ����������
	public FederalLaw317_From_23_11_2015_PersonalIncomeTaxDeductionCalculator() {
		// �� ���������:
		mChildcareCount = 0; // ����� ����� ����� ����� 0 
		mDisabledChildrenCount = 0; // ����� �����-��������� ����� 0
		mIsSingleParent = false; // ���������������� �� �������� ���������-���������
	}
	
	// ����������� � �����������
	public FederalLaw317_From_23_11_2015_PersonalIncomeTaxDeductionCalculator(
			int childcareCount,
			int disabledChildrenCount,
			boolean isSingleParent) {
		setChildcareCount(childcareCount);
		setDisabledChildrenCount(disabledChildrenCount);
		mIsSingleParent = isSingleParent;
	}
	
	public static final int TAX_DEDUCTION_FOR_DISABLED_CHILD = 12000; // ����� �� ������-��������
	public static final int TAX_DEDUCTION_FOR_FIRST_CHILD = 1400; // ����� �� ������� ������ (�� �������)
	public static final int TAX_DEDUCTION_FOR_SECOND_CHILD = 2800; // ����� �� ������� ������  (�� �������)
	public static final int TAX_DEDUCTION_FOR_THIRD_CHILD = 5800; // ����� �� �������� ������ (�� �������)
	public static final int TAX_DEDUCTION_FOR_NEXT_CHILD = 3000; // ����� �� ������� ������������ ������ (�� �������)
	public static final int SINGLE_PARENT_COEFFICIENT = 2; // ���������� ��������� ������ ��� ��������-��������
	
	private int mChildcareCount; // ����� ����� ����� �� ����������
	private int mDisabledChildrenCount; // ����� ����� ��������� �� ����������
	private boolean mIsSingleParent; // �������� �� ���������������� ���������-���������

	// ������� � �������:
	
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

	public void setDisabledChildrenCount(int disabled�hildren�ount) {
		if (disabled�hildren�ount < 0)
			throw new IllegalArgumentException("����� ����� �� ����� ���� ������ 0!");
		this.mDisabledChildrenCount = disabled�hildren�ount;
	}

	public boolean isSingleParent() {
		return mIsSingleParent;
	}

	public void setSingleParent(boolean isSingleParent) {
		this.mIsSingleParent = isSingleParent;
	}
	
	// ������� ��� ��������� ������ ���������� ������
	public double getPersonalIncomeTaxDeduction() {
		// �� ������: �� ������� ������-�������� ����������� ������������� �����
        double personalIncomeTaxDeduction = TAX_DEDUCTION_FOR_DISABLED_CHILD * mDisabledChildrenCount;
        
        // ��� ��� ����-�������� ������, ��������� ����� ����� ����� ��� ��������
        int remaining�hildcareCount = mChildcareCount - mDisabledChildrenCount;
        
        // ����� � ������ �������� ���������� ������������� ����� ������ �� 3 �����
        // ��� ������� ����������� ����������� ������������� �����
        switch (remaining�hildcareCount)
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
                personalIncomeTaxDeduction += TAX_DEDUCTION_FOR_THIRD_CHILD + TAX_DEDUCTION_FOR_NEXT_CHILD * (remaining�hildcareCount - 3);
                break;
        }
        
        // ���� ���������������� �������� ���������-���������, �� ��������� ����� ���������� �� ������������� �����������
        if (mIsSingleParent)
            personalIncomeTaxDeduction *= SINGLE_PARENT_COEFFICIENT;

        return personalIncomeTaxDeduction; // ��������� ���������� ��������� �����
    }
}
