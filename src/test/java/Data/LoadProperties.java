package Data;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {

// load the properties file from the properties folder

    public static Properties useData = loadProperties("src\\main\\java\\properties\\userData.properties");

    private static Properties loadProperties(String path) {

        Properties pro = new Properties();
        // input stream to read the file

        try {
            FileInputStream stream = new FileInputStream(path);
            pro.load(stream);
            stream.close();
        } catch (IOException e) {
            System.out.println("Error Occurred " + e.getMessage());
        }
        return pro;
    }
}
