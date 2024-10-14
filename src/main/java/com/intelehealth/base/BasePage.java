package com.intelehealth.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BasePage {

    WebDriver driver;
    Properties prop;
    OptionsManager optionsManager;
    private Properties testData;

    public static String highlight;
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

    public static synchronized WebDriver getDriver() {
        return tlDriver.get();
    }

    /**
     * This method is used to initialize the WebDriver based on the browserName
     * 
     * @param prop Properties object containing configuration properties
     * @return WebDriver instance
     */
    public WebDriver init_driver(Properties prop) {
        String browserName = prop.getProperty("browser");
        System.out.println("Running on ----> " + browserName + " browser");
        optionsManager = new OptionsManager(prop);

        if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver(optionsManager.getChromeOptions());
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver(optionsManager.getFirefoxOptions());
        } else if (browserName.equalsIgnoreCase("safari")) {
            driver = new SafariDriver();
        } else {
            System.out.println(browserName + " is not found, please pass the right browser Name");
        }

        tlDriver.set(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(prop.getProperty("url"));
        return driver;
    }

    /**
     * This method returns properties loaded from a configuration file.
     * 
     * @return Properties object containing configuration properties
     */
    public Properties init_prop() {

        prop = new Properties();
        String path = null;
        String env = null;

        try {
            env = System.getProperty("env");
            if (env == null) {
                path = "./src/main/java/com/intelehealth/config/config.qa.properties";
            } else {
                switch (env) {
                case "qa":
                    path = "./src/main/java/com/intelehealth/config/config.qa.properties";
                    break;
                case "stg":
                    path = "./src/main/java/com/intelehealth/config/config.stg.properties";
                    break;
                case "prod":
                    path = "./src/main/java/com/qa/hubspot/config/config.properties";
                    break;
                default:
                    System.out.println("no env is passed");
                    break;
                }
            }
            FileInputStream ip = new FileInputStream(path);
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("config file is not found.....");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }

    /**
     * This method takes a screenshot and saves it to the specified directory.
     * 
     * @return Path to the saved screenshot
     */
    public String getScreenshot() {
        File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "/TestReports/screenshots/" + System.currentTimeMillis()
                + ".png";
        File destination = new File(path);

        try {
            FileUtils.copyFile(src, destination);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return path;
    }

    public List<String> getPropertyList(String name) {
        List<String> list = Arrays.asList(name.toString().split("\\,"));
        System.out.println(list);
        return list;
    }
}
