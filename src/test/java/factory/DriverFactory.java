package factory;

import config.Config;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.options.BaseOptions;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class DriverFactory {
    private static DriverFactory instance = new DriverFactory();
    private static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();
    public static DriverFactory getInstance(){
        return instance;
    }

    public static AppiumDriver getDriver() {
        String platform = Config.MOBILE_PLATFORM;

        if(platform.equalsIgnoreCase("android")){
            BaseOptions androidOptions = new BaseOptions()
                    .amend("platformName", "android")
                    .amend("appium:options", Map.ofEntries(
                            Map.entry("automationName", "UiAutomator2"),
                            Map.entry("platformVersion", "14"),
                            Map.entry("deviceName", "emulator-5554")))
                    .amend("browserName", Config.BROWSER_NAME);
            try {
                driver.set(new AndroidDriver(new URL(Config.URL), androidOptions));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            return driver.get();
        }
        else if (platform.equalsIgnoreCase("ios")){
            BaseOptions iosOptions = new BaseOptions()
                    .amend("platformName", "ios")
                    .amend("appium:options", Map.ofEntries(
                            Map.entry("automationName", "XCUITest"),
                            Map.entry("platformVersion", "16"),
                            Map.entry("deviceName", "iPhone 14 Pro Max")))
                    .amend("browserName", Config.BROWSER_NAME);
            try {
                driver.set(new AndroidDriver(new URL(Config.URL), iosOptions));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            return driver.get();
        }
        else {
            throw new IllegalArgumentException("Invalid platform: " + platform);
        }
    }
}
