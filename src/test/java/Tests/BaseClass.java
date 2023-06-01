package Tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class BaseClass {
    public static String currentDir = System.getProperty("user.dir");

    public static Properties loadProperties(){
        Properties properties = new Properties();
        try {
            FileInputStream fis = new FileInputStream(currentDir+ File.separator+"config.properties");
            properties.load(fis);
        }catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    protected AppiumDriver driver;
    public AppiumDriver getDriver(){
        return this.driver;
    }


    @BeforeMethod
    public void setUp(){
        Properties prop = loadProperties();
        String platformName = prop.getProperty("device.platform.name");
        String UDID = prop.getProperty("device.udid");
        String automationName = prop.getProperty("automation.name");
        String appPath = prop.getProperty("app.path");
        String appiumServerURL = prop.getProperty("appium.server.url");

        try {
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability(CapabilityType.PLATFORM_NAME,platformName);
            cap.setCapability(MobileCapabilityType.UDID, UDID);
            cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, automationName);
            cap.setCapability(MobileCapabilityType.APP, "D:\\TheAppScore\\src\\test\\resources\\apps\\thescore.apk");
            cap.setCapability("autoGrantPermissions", true);
            URL url = new URL(appiumServerURL);

            driver = new AppiumDriver(url,cap);
        }
        catch (Exception e){
            System.out.println(e);
        }

    }


    @AfterMethod
    public void tearDown(){
       driver.quit();
    }
}
