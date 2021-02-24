package userDefinedLibraries;

//Import all necessary Libraries
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//To utilize the data from the Excel and return the outputs in the Excel
public class ExcelReadWrite {

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
		File src=new File(System.getProperty("user.dir")+"\\src\\test\\java\\dataTable\\TripAdvisor.xlsx");
		FileInputStream file;
		try
		{

			file=new FileInputStream(src);
			XSSFWorkbook wb=new XSSFWorkbook(file);
			XSSFSheet sheet=wb.getSheetAt(1);
			XSSFRow row=null;
			Cell cell=null;
			if(column == 0) {
				row=sheet.createRow(rowno);
			}
			else {
				row = sheet.getRow(rowno);
			}
			cell=row.createCell(column);
			cell.setCellValue(result);
			FileOutputStream output=new FileOutputStream(src);
			wb.write(output);
			wb.close();
			
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
