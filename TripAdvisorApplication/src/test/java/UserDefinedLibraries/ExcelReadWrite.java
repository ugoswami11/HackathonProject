package userDefinedLibraries;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadWrite {

	public static File src;
	public static FileInputStream fileip;
	public static FileOutputStream fileop;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static String val1;
	public static int row;
	public static XSSFCell cell;
	public static XSSFRow Row;
	public static String[] data;

	public static String[] readexcel(){
		try {
			//GET THE SOURCE EXCEL FILE
			File src = new File(System.getProperty("user.dir")+"\\src\\test\\java\\dataTable\\TripAdvisor.xlsx");
			// CREATE FILEINPUTSTREAM OBJECT
			FileInputStream fileip = new FileInputStream(src);
			XSSFWorkbook workbook = new XSSFWorkbook(fileip);
			XSSFSheet sheet = workbook.getSheetAt(0);
			String[] testdata = new String[10];
			for (int i = 0; i < 8; i++) {
				// GET DATA FROM THE EXCEL SHEET
				testdata[i] = (sheet.getRow(1).getCell(i)).toString();
				System.out.println(testdata[i]);

			}
			
			data = testdata;
			fileip.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return data;
	}

	// Write data into excel sheet
	public static void writeexcel() {
		try {
			fileip.close();
			// Create an object of FileOutputStream class to create write data in excel file
			fileop = new FileOutputStream(src);
			// write data in the excel file
			workbook.write(fileop);
			// close output stream
			fileop.close();

		} catch (FileNotFoundException e) {
			FailReport.reportFail(e.getMessage());
		} catch (IOException e) {
			FailReport.reportFail(e.getMessage());
		}
	}
}