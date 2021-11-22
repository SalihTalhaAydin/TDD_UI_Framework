package utilities;

import org.testng.annotations.DataProvider;

public class DataProviderUtils {

    @DataProvider(name = "data from exampleExcel")
    public static Object[][] getExampleExcelData() {
        ExcelUtils.openExcelFile("Sheet1");
        return ExcelUtils.convert2DListToObject(ExcelUtils.getValues());
    }
}
