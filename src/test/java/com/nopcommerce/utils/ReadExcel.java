package com.nopcommerce.utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
	public static String[][] readExcelData(String wBookName) throws IOException {
		// Go to file location and open the file
		XSSFWorkbook wBook = new XSSFWorkbook("./data/"+wBookName+".xlsx");
		// Navigate to the particular sheet
		XSSFSheet sheet = wBook.getSheetAt(0);
		// Find the no of rows in the sheet
		int rowCount = sheet.getLastRowNum();
		/*sheet.getPhysicalNumberOfRows();*/
		// Find the no of columns in the sheet
		int cellCount = sheet.getRow(0).getLastCellNum();
		String[][] data = new String[rowCount][cellCount];
		// Read data inside each cell
		for (int i = 1; i <= rowCount; i++) {
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j < cellCount; j++) {
				XSSFCell cell = row.getCell(j);
				data[i-1][j] = cell.getStringCellValue();
			}
		}
		// close the workbook
		wBook.close();
		return data;
	}
}













