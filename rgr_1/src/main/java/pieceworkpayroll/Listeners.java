package pieceworkpayroll;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


// Класс, отвечающий за добавления обработчиков событий для компонентов, созданных дизайнером
public class Listeners {
	private Listeners() {} // Класс является утилитой (статичен) и не имеет экземпляров
	
	// Инициализация обработчиков
	static void initialize() {
		// Обработчик события изменения значения компонента:
		ChangeListener calculatingChangeListener = new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				MainForm.calculate(); // В таком случае вызвать перерасчёт НДФЛ
			}
		};

		// Обработчик события изменения выбранного элемента выпадающего списка:
		ItemListener calculatingItemListener = new ItemListener() {
			public void itemStateChanged(ItemEvent event) {
				MainForm.calculate(); // В таком случае вызвать перерасчёт НДФЛ
			}
		};

		// Обработчик события изменения значения компонентов, отвечающий за число детей:
		ChangeListener anyChildChangeListener = new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				checkDisabledChildrenCountLessThanChildcareCount(); // В таком случае, убедиться, что число детей инвалидов не больше общего числа детей
				MainForm.calculate(); // И вызвать перерасчёт НДФЛ
			}
		};
		
		
		ActionListener actiongrafik = new ListenerPDF();
		Designer.PDFnew.addActionListener(actiongrafik);
		Designer.ExitButt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Закрытие приложения
                System.exit(0);
            }
        });
		
		// Добавляем соданные обработчики для:
		Designer.jSpinnerDetailsCount.addChangeListener(calculatingChangeListener); // Спиннера числа деталей
		Designer.jSpinnerDetailPrice.addChangeListener(calculatingChangeListener); // Спиннера цены одной детали
		Designer.jComboBoxIsSingleParent.addItemListener(calculatingItemListener); // Выпадающего списка, для указания того, что налогоплательщик является родителем-одиночкой
		
		Designer.jSpinnerChildcareCount.addChangeListener(anyChildChangeListener); // Спиннера общего числа детей на содержании
		Designer.jSpinnerDisabledChildrenCount.addChangeListener(anyChildChangeListener); // Спиннера числа детей-инвалидов на содержании
		
	}
	
	// Функция для проверки того, что число детей-инвалидов меньше, чем общее число детей
	// В ином случае: число детей-инвалидов будет приравнено к общему числу детей
	public static void checkDisabledChildrenCountLessThanChildcareCount() {
		if (((Number) Designer.jSpinnerDisabledChildrenCount.getValue()).intValue() > ((Number) Designer.jSpinnerChildcareCount.getValue()).intValue())
        	Designer.jSpinnerDisabledChildrenCount.setValue(Designer.jSpinnerChildcareCount.getValue());
    }
}