package UserDefinedLibraries;

/* Class  : Read and write - Excel
 * Author : Aishwariya
 * Date   : 24-04-2020
 * ID     : 851297
 */

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
	public static String category1;

	public static int readexcel(){
		try {
			// Get the source excel file
			src = new File(System.getProperty("user.dir")
					+ "\\src\\test\\java\\datatables\\CourseraDetails.xlsx");
			// Create FileInputStream object
			fileip = new FileInputStream(src);
			workbook = new XSSFWorkbook(fileip);
			sheet = workbook.getSheetAt(0);

			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				if (i == 1) {
					// Get input from row = i and cell = 0
					category1 = (sheet.getRow(i).getCell(0)).getStringCellValue();
					row = i;
					break;
				}
			}
		} catch (FileNotFoundException e) {
			FailReport.reportFail(e.getMessage());
		} catch (IOException e) {
			FailReport.reportFail(e.getMessage());
		}

		return row;
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