package paylocity.utlities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    private static Properties properties = new Properties();

    static {

        try {
            File path = new File("");
            //#2- Load the file into FileInputStream

            FileInputStream file = new FileInputStream(path.getAbsoluteFile()+"\\configuration.properties");

            //#3- load properties object with the file (configuration.properties)
            properties.load(file);

            //close the file
            file.close();

        } catch (IOException e) {

            System.out.println("File not found in Configuration properties.");

        }
    }
    public static String getProperty(String keyWord){

        return properties.getProperty(keyWord);
    }
}
