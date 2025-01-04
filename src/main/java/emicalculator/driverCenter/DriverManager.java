package emicalculator.driverCenter;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

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

    private void initializeDriver(String browser, boolean headless) {
        try {
            switch (browser.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
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
                    WebDriverManager.firefoxdriver().setup();
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
            logger.info("Clearing WebDriver cache.");
            if (driver != null) {
                driver.quit();
                driver = null;
                logger.info("WebDriver cache cleared and driver quit.");
            }
        } catch (Exception e) {
            logger.error("Error while clearing WebDriver cache.", e);
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
