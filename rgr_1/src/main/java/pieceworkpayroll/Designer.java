package pieceworkpayroll;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;






// Класс, отвечающий за визуальную часть программы, т.е. интерфейс
public class Designer {
	private Designer() {} // Класс является утилитой (статичен) и не имеет экземпляров
	
	// Ниже следуют объявления и инициализация элементов интерфейса:
	
	// Надпись: "Количество деталей:"
    public static JLabel jLabelDetailsCount = new JLabel("Количество деталей:");
    
    // Спиннер для ввода количества деталей
    // Значение по умолчанию: 1
    // Минимальныое значение: 1
    // Максимальное значение: 999999999
    // Целочисленное
    public static JSpinner jSpinnerDetailsCount = new JSpinner(new SpinnerNumberModel(1, 1, 999999999, 1));

	// Надпись: "Цена одной детали:"
    public static JLabel jLabelDetailPrice = new JLabel("Цена одной детали:");
    
    // Спиннер для ввода цены одной детали
    // Значение по умолчанию: 0
    // Минимальныое значение: 0
    // Максимальное значение: 999999999
    // Вещественное
    public static JSpinner jSpinnerDetailPrice = new JSpinner(new SpinnerNumberModel(0.00, 0.00, 999999999, 1.0));

	// Надпись: "Дети на содержании:"
    static JLabel jLabelChildcareCount = new JLabel("Дети на содержании:");
    
    // Спиннер для ввода общего числа детей на содержании
    // Значение по умолчанию: 0
    // Минимальныое значение: 0
    // Максимальное значение: 999999999
    // Целочисленное
    public static JSpinner jSpinnerChildcareCount = new JSpinner(new SpinnerNumberModel(0, 0, 999999999, 1));

	// Надпись: "Из них детей-инвалидов:"
    static JLabel jLabelDisabledChildrenCount = new JLabel("Из них детей-инвалидов:");
    
    // Спиннер для ввода числа детей-инвалидов на содержании
    // Значение по умолчанию: 0
    // Минимальныое значение: 0
    // Максимальное значение: 999999999
    // Целочисленное
    static JSpinner jSpinnerDisabledChildrenCount = new JSpinner(new SpinnerNumberModel(0, 0, 999999999, 1));

	// Надпись: "Родитель-одиночка?"
    static JLabel jLabelIsSingleParent = new JLabel("Родитель-одиночка?");
    
    // Варианты для выпадающего списка jComboBoxIsSingleParent:
    // 0) "Нет"
    // 1) "Да - детские x 2"
    static final String[] isSingleParentOptions = {"Нет", "Да - детские x 2"};
    
    // Выпадающий список, основанный на массиве isSingleParentOptions
    static JComboBox<String> jComboBoxIsSingleParent = new JComboBox<String>(isSingleParentOptions);

    static final String LABEL_PERSONAL_INCOME_TAX_DEDUCTION_INIT_TEXT = "Вычет по параметрам составит: ";
    
	// Надпись: "Вычет по параметрам составит: "
    static JLabel jLabelPersonalIncomeTaxDeduction = new JLabel(LABEL_PERSONAL_INCOME_TAX_DEDUCTION_INIT_TEXT);

    static final String LABEL_SALARY_INIT_TEXT = "Зарплата за месяц: ";
    
	// Надпись: "Зарплата за месяц: "
    static JLabel jLabelSalary = new JLabel(LABEL_SALARY_INIT_TEXT);
    
    public static JButton PDFnew = new JButton("PDF");

	
    // Инициализация интерфейса
	public static void initialize() {
        JFrame frame = createFrame(); // Создаём фрейм
        fillFrame(frame); // Заполняем фрейм
        frame.setVisible(true); // Делаем фрейм видимым
	}
	
	// Фукнция для создания фрейма (главного окна)
	static JFrame createFrame() {
		JFrame frame = new JFrame("НДФЛ вычеты"); // Создаём экзмепляр фрейма с заголовком "НДФЛ вычеты"
		
		 // Делаем дефолтной функцие при попытки закрыть форму стандартную процедуру закрытия
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350,256); // Устанавлиаем высоту равной 350, а ширину - 256
        // Размещаем элемент относительно левого верхнего угла с отклонением на 256 пикселей по горизонтали и 128 - по вертикали
        frame.setLocation(256, 128);
        
        return frame; // Возаращем получившийся фрейм
	}
	
	// Функция для заполнения фрейма компонентами
	static void fillFrame(JFrame frame) {
        Container container = frame.getContentPane(); // Получаем контейнер фрейма
        container.setLayout(new FlowLayout(FlowLayout.LEFT)); // Устаналиваем внутри контейнера вырванивание по левому краю
        
        // Добавлеям все имеющиеся компоненты
        // ВАЖНО! Добавляйте элементы в том же порядке, в котором они объявлены
        // Для более простой разработки
        container.add(jLabelDetailsCount);
        container.add(jSpinnerDetailsCount);
        container.add(jLabelDetailPrice);
        container.add(jSpinnerDetailPrice);
        container.add(jLabelChildcareCount);
        container.add(jSpinnerChildcareCount);
        container.add(jLabelDisabledChildrenCount);
        container.add(jSpinnerDisabledChildrenCount);
        container.add(jLabelIsSingleParent);
        container.add(jComboBoxIsSingleParent);
        container.add(jLabelPersonalIncomeTaxDeduction);
        container.add(jLabelSalary);
        container.add(PDFnew);
	}
}