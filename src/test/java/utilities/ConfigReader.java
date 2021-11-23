package utilities;

import org.openqa.selenium.NotFoundException;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    static {
        //Configuration file path
        String path = "configuration.properties";
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            properties = new Properties();
            properties.load(fileInputStream);
        }catch (Exception e ){
            System.out.println("Error! The config file is not found. " +
                    "{Check the path or the file existing or not}" +
                    "Message: " + e.getMessage());
        }
    }

    public static String getProperty(String key){
        return properties.getProperty(key);
    }
}
