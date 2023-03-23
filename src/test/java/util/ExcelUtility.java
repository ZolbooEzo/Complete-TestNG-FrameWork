package util;
//
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.ss.usermodel.WorkbookFactory;
//
public class ExcelUtility {
//	
//	public static Object[][] readExcelFile(String filename, String sheetname) throws IOException {
//        FileInputStream inputStream = new FileInputStream(filename);
//        Workbook workbook = WorkbookFactory.create(inputStream);
//        Sheet sheet = workbook.getSheet(sheetname);
//        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum() + 1;
//        int colCount = sheet.getRow(0).getLastCellNum();
//        Object[][] data = new Object[rowCount][colCount];
//        for (int i = 0; i < rowCount; i++) {
//            Row row = sheet.getRow(i);
//            for (int j = 0; j < colCount; j++) {
//                Cell cell = row.getCell(j);
//                switch (cell.getCellType()) {
//                    case STRING:
//                        data[i][j] = cell.getStringCellValue();
//                        break;
//                    case NUMERIC:
//                        data[i][j] = cell.getNumericCellValue();
//                        break;
//                    case BOOLEAN:
//                        data[i][j] = cell.getBooleanCellValue();
//                        break;
//                    default:
//                        data[i][j] = null;
//                        break;
//                }
//            }
//        }
//        workbook.close();
//        inputStream.close();
//        return data;
//    }
//
//    public static void writeExcelFile(String filename, String sheetname, Object[][] data) throws IOException {
//        Workbook workbook = WorkbookFactory.create(true);
//        Sheet sheet = workbook.createSheet(sheetname);
//        for (int i = 0; i < data.length; i++) {
//            Row row = sheet.createRow(i);
//            for (int j = 0; j < data[i].length; j++) {
//                Cell cell = row.createCell(j);
//                if (data[i][j] instanceof String) {
//                    cell.setCellValue((String) data[i][j]);
//                } else if (data[i][j] instanceof Double) {
//                    cell.setCellValue((Double) data[i][j]);
//                } else if (data[i][j] instanceof Boolean) {
//                    cell.setCellValue((Boolean) data[i][j]);
//                } else {
//                    cell.setCellValue((String) null);
//                }
//            }
//        }
//        FileOutputStream outputStream = new FileOutputStream(filename);
//        workbook.write(outputStream);
//        workbook.close();
//        outputStream.close();
//    }
//
}
