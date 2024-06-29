package config;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class Config {
    private static Properties properties = new Properties();
    private final static String configPath = "src/test/resources/config.properties";
    public final static String BROWSER_NAME = System.getProperty("browser_name", getProperty("browser.name"));
    public static final String URL = System.getProperty("appium_url", getProperty("appium.url"));
    public static final String MOBILE_PLATFORM = System.getProperty("mobile_platform", getProperty("mobile.platform"));

    public static String getProperty(String name){
        try{
            InputStream inputStream = Files.newInputStream(Paths.get(configPath));
            properties.load(inputStream);
        }
        catch (IOException ioException){
            throw new RuntimeException(String.format("File not exist in path %s %s", configPath, ioException));
        }

        return properties.getProperty(name);
    }
}
