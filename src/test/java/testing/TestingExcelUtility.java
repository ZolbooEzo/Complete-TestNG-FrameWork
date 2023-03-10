package testing;

import java.io.IOException;

import util.Constants;
import util.ExcelUtility;

public class TestingExcelUtility {

	public static void main(String[] args) throws IOException {
		
		// ---------------------------------------------------------------------------------------------------------
		// THIS METHOD IS READING DATA...
		Object[][] data2 = ExcelUtility.readExcelFile(Constants.excelPathToTechCircle, "Sheet1");
		for (int i = 0; i < data2.length; i++) {
			for (int j = 0; j < data2[i].length; j++) {
				System.out.println(data2[i][j] + " ");
			}
			System.out.println();
		}
		// ---------------------------------------------------------------------------------------------------------
		
		Object[][] data11 = {{"John", 25, true}, {"Mary", 30, false}, {"Bob", 40, true}};
		
		ExcelUtility.writeExcelFile(Constants.excelPathToTechCircle, "Sheet1", data11);
		
		
	}
}
