package testcase;

import java.io.IOException;
import java.util.Iterator;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public String[][] readData(String filename) throws IOException {
		System.out.println("I am Inside Excel class");
		XSSFWorkbook wb = new XSSFWorkbook("./TestNG-Excel/" + filename + ".xlsx");
		XSSFSheet sheet = wb.getSheet("Sheet2");
		// get row count
		int rowcount = sheet.getLastRowNum();
		System.out.println(rowcount);
		// getting cell count in a particular row
		int cellcount = sheet.getRow(0).getLastCellNum();
		System.out.println(cellcount);

		// return null ;
		// declaring String value with 2D array to get the values from excel
		String[][] data = new String[rowcount][cellcount];

		// using for loop to get each data in row and column
		for (int i = 1; i <= rowcount; i++) {
			for (int j = 0; j < cellcount; j++) {
				String cellvalue = sheet.getRow(i).getCell(j).getStringCellValue();
				System.out.println(cellvalue);
				// System.out.println("I is " + i + " and j is " + j);
				// System.out.println("The value in the cell is " +
				// sheet.getRow(i).getCell(j).getStringCellValue());
				data[i - 1][j] = cellvalue;
			}
		}

		wb.close();
		return data;
	}

}
