package utils;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcel {

	public static String[][] getExceldata(String fileName) throws IOException {

		XSSFWorkbook wbook = new XSSFWorkbook(System.getProperty("user.dir")+"./src/main/java/resources/" + fileName + ".xlsx");
		XSSFSheet sheet = wbook.getSheetAt(0);
		// total rows
		int lastRowNum = sheet.getLastRowNum();
		// total column or cell
		short lastCellNum = sheet.getRow(0).getLastCellNum();

		String[][] data = new String[lastRowNum][lastCellNum];
		for (int i = 1; i <= lastRowNum; i++) {
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j < lastCellNum; j++) {
				XSSFCell cell = row.getCell(j);
				// convert all format to string (numbers,special characters,etc)
				DataFormatter dft = new DataFormatter();
				String value = dft.formatCellValue(cell);
				data[i - 1][j] = value;
			}
		}
		wbook.close();
		return data;
	}
}
