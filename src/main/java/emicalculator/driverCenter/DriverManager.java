package emicalculator.driverCenter;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import emicalculator.utility.PropertyUtils;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	private static final Logger logger = LogManager.getLogger(DriverManager.class);

    private static DriverManager instance;
    private WebDriver driver;

    // Private constructor to prevent instantiation
    private DriverManager() {
    }

    // Singleton instance to ensure a single driver instance
    public static synchronized DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
            logger.info("DriverManager instance created.");
        }
        return instance;
    }

    // Initialize WebDriver based on the browser type (Chrome, Firefox) and headless option
    public WebDriver getDriver(String browser, boolean headless) {
        if (driver == null) {
            logger.info("Initializing WebDriver for browser: {} with headless option: {}", browser, headless);
            initializeDriver(browser, headless);
        } else {
            logger.info("WebDriver already initialized.");
        }
        return driver;
    }
    
    public void openPage(String url) {
        try {
            logger.info("Navigating to URL: {}", url);
            if (driver == null) {
                throw new IllegalStateException("WebDriver not initialized. Call getDriver() before openPage().");
            }
            driver.get(url);
            logger.info("Successfully navigated to URL: {}", url);
        } catch (Exception e) {
            logger.error("Error while navigating to URL: {}", url, e);
            throw e;
        }
    }
    
    public void maximizeBrowser() {
    	logger.info("Maximizing the browser window.");
        if (driver == null) {
            throw new IllegalStateException("WebDriver not initialized. Call getDriver() before maximizing the browser.");
        }
        driver.manage().window().maximize();
        logger.info("Browser window maximized successfully.");
    }

    private void initializeDriver(String browser, boolean headless) {
        try {
            switch (browser.toLowerCase()) {
                case "chrome":
                    String chromeDriverPath = PropertyUtils.getProperty("chrome.driver.path");
                    if (chromeDriverPath == null || chromeDriverPath.isEmpty()) {
                        throw new RuntimeException("Chrome driver path not specified in config.properties.");
                    }
                    System.setProperty("webdriver.chrome.driver", chromeDriverPath);
                    ChromeOptions chromeOptions = new ChromeOptions();
                    if (headless) {
                        chromeOptions.addArguments("--headless");
                        chromeOptions.addArguments("--disable-gpu"); // Recommended for headless mode
                        chromeOptions.addArguments("--window-size=1920x1080"); // Set window size for headless mode
                        logger.info("Running Chrome in headless mode.");
                    }
                    driver = new ChromeDriver(chromeOptions);
                    logger.info("Chrome WebDriver initialized.");
                    break;
                case "firefox":
                    String geckoDriverPath = PropertyUtils.getProperty("gecko.driver.path");
                    if (geckoDriverPath == null || geckoDriverPath.isEmpty()) {
                        throw new RuntimeException("Gecko driver path not specified in config.properties.");
                    }
                    System.setProperty("webdriver.gecko.driver", geckoDriverPath);
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    if (headless) {
                        firefoxOptions.addArguments("-headless");
                        logger.info("Running Firefox in headless mode.");
                    }
                    driver = new FirefoxDriver(firefoxOptions);
                    logger.info("Firefox WebDriver initialized.");
                    break;
                default:
                    throw new UnsupportedOperationException("Unsupported browser: " + browser);
            }
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            logger.info("Implicit wait set to 10 seconds.");
        } catch (Exception e) {
            logger.error("Error while initializing WebDriver for browser: {}", browser, e);
            throw e;
        }
    }

    // Method to clear the WebDriver cache
    public void clearCache() {
    	try {
            logger.info("Clearing browser cache.");
            if (driver == null) {
                throw new IllegalStateException("WebDriver not initialized. Call getDriver() before clearCache().");
            }

            // Clear cache using browser-specific commands
            driver.manage().deleteAllCookies(); // Deletes all cookies
            logger.info("Browser cache cleared successfully.");
        } catch (Exception e) {
            logger.error("Error while clearing browser cache.", e);
        }
    }

    // Method to close the WebDriver
    public void quitDriver() {
        try {
            logger.info("Closing WebDriver.");
            if (driver != null) {
                driver.quit();
                driver = null;
                logger.info("WebDriver successfully closed.");
            }
        } catch (Exception e) {
            logger.error("Error while closing WebDriver.", e);
        }
    }

    // Getter for the WebDriver instance
    public WebDriver getWebDriver() {
        return driver;
    }

    // Ensure that the Singleton instance is cleaned up on JVM shutdown
    public static void shutdown() {
        if (instance != null) {
            instance.quitDriver();
            logger.info("DriverManager shutdown complete.");
        }
    }
}
