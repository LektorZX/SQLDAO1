package util;

import lombok.experimental.UtilityClass;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

@UtilityClass
public class PropertiesUtil {
    private static Properties properties;
    static {

        try {
            properties=new Properties();
            InputStream resourceAsStream = PropertiesUtil.class.getClassLoader().getResourceAsStream("application.properties");

             properties.load(resourceAsStream);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String get(String key){
        return properties.getProperty(key);
    }

}
