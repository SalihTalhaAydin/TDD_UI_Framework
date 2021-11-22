package utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExcelUtils {

    private static XSSFWorkbook xssfWorkbook;
    private static XSSFSheet xssfSheet;
    private static XSSFRow xssfRow;
    private static Cell cell;

    private static File file;
    private static FileInputStream excelFile;

    // your excel data file path comes from configuration.properties
    private static final String exampleExcelPath = ConfigReader.getProperty("exampleExcelPath");

    /**
     * @param sheetName
     */
    public static void openExcelFile(String sheetName) {
        try {
            excelFile = new FileInputStream(exampleExcelPath);
            file = new File(exampleExcelPath);
            xssfWorkbook = new XSSFWorkbook(excelFile);
            xssfSheet = xssfWorkbook.getSheet(sheetName);
        } catch (Exception exception) {
            System.out.println("Error!!! File path is wrong or file doesn't exist" +
                    "\nMessage: " + exception.getMessage());
        }
    }

    /**
     * @param rowNum
     * @param columnNum
     * @return
     */
    public static String getValue(int rowNum, int columnNum) {
        cell = getCell(rowNum, columnNum);
        cell.setCellType(CellType.STRING);
        return cell.toString();
    }

    /**
     * Puts data into EXISTING cell
     *
     * @param newValue
     * @param rowNum
     * @param columnNum
     */
    public static void setValue(String newValue, int rowNum, int columnNum) {
        getCell(rowNum, columnNum).setCellValue(newValue);
        saveFile();
    }

    /**
     * Puts data into empty CREATED cell
     *
     * @param newValue
     * @param rowNum
     * @param columnNum
     */
    public static void insertValue(String newValue, int rowNum, int columnNum) {
        createCell(rowNum, columnNum).setCellValue(newValue);
        saveFile();
    }

    /**
     * @return all the existing data from Excel sheet
     */
    public static List<List<String>> getValues() {
        List<List<String>> allValues = new ArrayList<>();

        for (int i = xssfSheet.getFirstRowNum() + 1; i <= xssfSheet.getLastRowNum(); i++) {
            List<String> eachRow = new ArrayList<>();
            xssfRow = xssfSheet.getRow(i);

            for (int j = xssfRow.getFirstCellNum(); j < xssfRow.getLastCellNum(); j++) {
                eachRow.add(getValue(i + 1, j + 1));
            }
            allValues.add(eachRow);
        }

        return allValues;
    }

    /**
     * Converting List of list ArrayList to 2D Object Array for data provider compatible
     * @param listValues
     * @return
     */
    public static Object[][] convert2DListToObject(List<List<String>> listValues){
        Object[][] arrayValues = new Object[listValues.size()][listValues.get(0).size()];

        for (int i = 0; i < arrayValues.length; i++) {
            for (int j = 0; j < arrayValues[i].length; j++) {
                arrayValues[i][j] = listValues.get(i).get(j);
            }
        }
        return arrayValues;
    }

    /**
     * @param rowNum
     * @param columnNum
     * @return
     */
    private static Cell getCell(int rowNum, int columnNum) {
        return xssfSheet.getRow(--rowNum).getCell(--columnNum);
    }

    /**
     * Saves and exists the file
     */
    private static void saveFile() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file.getPath());
            xssfWorkbook.write(fileOutputStream);
        } catch (Exception exception) {
            System.out.println("Error!!! Can't save the file." +
                    "\nMessage: " + exception.getMessage());
        }
    }

    /**
     * Creates a new empty cell
     *
     * @param rowNum
     * @param columnNum
     * @return
     */
    private static Cell createCell(int rowNum, int columnNum) {
        return xssfSheet.createRow(--rowNum).createCell(--columnNum);
    }

}
