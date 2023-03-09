package pieceworkpayroll;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

import javax.swing.JOptionPane;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.BaseFont;

import pieceworkpayroll.CreatePDF;



public class ListenerPDF implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
			String[][] NameCell = new String[2][4];
			NameCell[1][0]= String.valueOf(Designer.jSpinnerDetailsCount.getValue());
			NameCell[1][1]= String.valueOf(Designer.jSpinnerDetailPrice.getValue());
			NameCell[1][2] = String.valueOf(Designer.jSpinnerChildcareCount.getValue());
			NameCell[1][3]= String.valueOf(Designer.jSpinnerDisabledChildrenCount.getValue());
			
			String[] Hat = new String[4];
			Hat[0]="Количество деталей";
			Hat[1]="Цена одной детали";
			Hat[2]="Дети на содержании";
			Hat[3]="Детей инвалидов";
			
			String[][] NameCelltwo = new String[2][2];
			NameCelltwo[1][0] = Designer.jLabelPersonalIncomeTaxDeduction.getText();
			NameCelltwo[1][1]= Designer.jLabelSalary.getText();

			
			String[] Hattwo = new String[2];
			Hattwo[0]="Вычет по параметрам";
			Hattwo[1]="Зарплата за месяц";

			
			String[][] NameCellthree = new String[2][5];
			NameCellthree[1][0]= "Ответственность";
			NameCellthree[1][1]= "Модератор";
			NameCellthree[1][2]= "Разработчик №1";
			NameCellthree[1][3]= "Разработчик №2";
			NameCellthree[1][4]= "Разработчик №3";
			
			String[] Hatthree = new String[5];
			Hatthree[0]="ФИО";
			Hatthree[1]="Акчулпанов И.Р.";
			Hatthree[2]="Акчулпанов И.Р.";
			Hatthree[3]="Давлетов А.И.";
			Hatthree[4]="Тамочкин И.В.";
			
			String TextTabletwo = "                 Таблица 2. Результаты вычислений";

			String Texthat = "                               Зарплатный калькулятор";
			String Textgeneral = "Данный зарплатный калькулятор является надежным инструментом для расчета налога на доходы физических лиц. "
					+ "Он позволяет быстро и точно определить сумму зарплаты, которую необходимо уплатить работнику."
					+ "Данный документ содержит 3 таблицы: в первой таблице представлены ваши введенные данные, "
					+ "во второй таблице представлены результаты вычислений. в 3 таблице находится информация о разработчиках.";
					
			String TextTable = "                 Таблица 1. Ваши введенные данные";

			String TextTablethree = "                 Таблица 3. Команда разработчиков";
			URL Imagelink=getClass().getResource("/picture/logo.png");
			String Namefile = "Document.pdf";
			BaseFont times = null;
			try {
				times = BaseFont.createFont("/fonts/times.ttf", "cp1251", BaseFont.EMBEDDED);
			} catch (DocumentException e2) {
				e2.printStackTrace();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			
			CreatePDF pdf = new CreatePDF(Namefile,times);
			Document document = pdf.getDocument();
			
			pdf.addText(document, Texthat, 20,true);
			pdf.addText(document, " ", 14, true);
			pdf.addText(document, Textgeneral, 14,true);
			pdf.addText(document, TextTable, 14, true);
			pdf.InitTableAndAddHat(document,Hat);
			pdf.addRowsInTable(pdf.getTable(), NameCell);
			pdf.addTable(document,pdf.getTable());
			pdf.addText(document, " ", 14, true);
			
			
			pdf.addText(document, TextTabletwo, 14, true);
	        pdf.InitTableAndAddHat(document,Hattwo);
	        pdf.addRowsInTable(pdf.getTable(), NameCelltwo);
	        pdf.addTable(document,pdf.getTable());
	        pdf.addText(document, " ", 14, true);
	        
	        pdf.addText(document, TextTablethree, 14, true);
	        pdf.InitTableAndAddHat(document,Hatthree);
			pdf.addRowsInTable(pdf.getTable(), NameCellthree);
			pdf.addTable(document,pdf.getTable());
			pdf.addText(document, " ", 14, true);
	        
			pdf.addPicture(Imagelink, document, 480, 740);
			pdf.addText(document, " ", 14, true);
			pdf.getClose();
			
			
			//вывод окна с сообщением о создании файла
			JOptionPane.showMessageDialog(null, "Файл " + Namefile + " создан","Create PDF", JOptionPane.PLAIN_MESSAGE);
		}

	}