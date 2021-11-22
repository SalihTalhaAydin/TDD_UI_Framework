package tests;

import org.testng.annotations.Test;
import utilities.DataProviderUtils;

public class ExampleTest extends Hooks{


    @Test
    public void example(){

    }

    @Test (dataProvider = "data from exampleExcel", dataProviderClass = DataProviderUtils.class)
    public void dataProviderDemo(String column1Data, String column2Data, String column3Data){

        System.out.println(column1Data + " | " +  column2Data + " | " + column3Data);
    }

}
