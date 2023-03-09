package rgr_1;

import org.junit.Test;

import pieceworkpayroll.Designer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DesignerTest {
    @Test
    public void initializeTest() {
        Designer.initialize();
        assertNotNull(Designer.jLabelDetailsCount);
        assertNotNull(Designer.jSpinnerDetailsCount);
        assertNotNull(Designer.jLabelDetailPrice);
        assertNotNull(Designer.jSpinnerDetailPrice);
        assertNotNull(Designer.PDFnew);
        assertEquals(Designer.jSpinnerDetailsCount.getValue(), 1);
        assertEquals(Designer.jSpinnerDetailPrice.getValue(), 0.00);
        assertEquals(Designer.jSpinnerChildcareCount.getValue(), 0);  
    }
}
