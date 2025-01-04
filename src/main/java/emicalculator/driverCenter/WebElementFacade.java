package emicalculator.driverCenter;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

public class WebElementFacade implements WebElement{
	private static final Logger logger = LogManager.getLogger(WebElement.class);
    private WebDriver driver;
    private WebElement element;

    // Constructor to initialize the WebElementFacade with WebDriver and By locator
    public WebElementFacade(WebDriver driver, By locator) {
        this.driver = driver;
        try {
            logger.debug("Attempting to locate element using locator: {}", locator);
            this.element = driver.findElement(locator);
            logger.info("WebElement initialized successfully with locator: {}", locator);
        } catch (NoSuchElementException e) {
            logger.error("Element not found using locator: {}", locator, e);
            throw e;
        } catch (Exception e) {
            logger.error("Unexpected error while initializing WebElement with locator: {}", locator, e);
            throw e;
        }
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        try {
            logger.debug("Taking screenshot for the element of type: {}", target.getClass().getName());
            X screenshot = element.getScreenshotAs(target);
            logger.info("Screenshot successfully captured for the element.");
            return screenshot;
        } catch (WebDriverException e) {
            logger.error("Failed to capture screenshot for the element.", e);
            throw e;
        }
    }

    @Override
    public void click() {
        try {
            logger.debug("Attempting to click on the element: {}", element);
            element.click();
            logger.info("Successfully clicked on the element.");
        } catch (WebDriverException e) {
            logger.error("Failed to click on the element: {}", element, e);
            throw e;
        }
    }
    
    public String getValue() {
    	 try {
             logger.debug("Attempting to get value of the element: {}", element);
             String value = element.getAttribute("value");
             logger.info("Successfully fetched value: {}", value);
             return value;
         } catch (WebDriverException e) {
             logger.error("Failed to get tag name for the element: {}", element, e);
             throw e;
         }
    }

    @Override
    public void submit() {
        try {
            logger.debug("Attempting to submit the element: {}", element);
            element.submit();
            logger.info("Element submitted successfully.");
        } catch (WebDriverException e) {
            logger.error("Failed to submit the element: {}", element, e);
            throw e;
        }
    }

    @Override
    public void sendKeys(CharSequence... keysToSend) {
        try {
            logger.debug("Attempting to send keys: '{}' to the element: {}", keysToSend, element);
            element.sendKeys(keysToSend);
            logger.info("Successfully sent keys to the element.");
        } catch (WebDriverException e) {
            logger.error("Failed to send keys '{}' to the element: {}", keysToSend, element, e);
            throw e;
        }
    }

    @Override
    public void clear() {
        try {
            logger.debug("Attempting to clear the element: {}", element);
            element.clear();
            logger.info("Element cleared successfully.");
        } catch (WebDriverException e) {
            logger.error("Failed to clear the element: {}", element, e);
            throw e;
        }
    }

    @Override
    public String getTagName() {
        try {
            logger.debug("Attempting to get tag name of the element: {}", element);
            String tagName = element.getTagName();
            logger.info("Successfully fetched tag name: {}", tagName);
            return tagName;
        } catch (WebDriverException e) {
            logger.error("Failed to get tag name for the element: {}", element, e);
            throw e;
        }
    }

    @Override
    public String getAttribute(String name) {
        try {
            logger.debug("Attempting to get attribute '{}' for the element: {}", name, element);
            String attribute = element.getAttribute(name);
            logger.info("Successfully fetched attribute '{}' with value: {}", name, attribute);
            return attribute;
        } catch (WebDriverException e) {
            logger.error("Failed to get attribute '{}' for the element: {}", name, element, e);
            throw e;
        }
    }

    @Override
    public boolean isSelected() {
        try {
            logger.debug("Checking if the element is selected: {}", element);
            boolean isSelected = element.isSelected();
            logger.info("Element is selected: {}", isSelected);
            return isSelected;
        } catch (WebDriverException e) {
            logger.error("Failed to check if the element is selected: {}", element, e);
            throw e;
        }
    }

    @Override
    public boolean isEnabled() {
        try {
            logger.debug("Checking if the element is enabled: {}", element);
            boolean isEnabled = element.isEnabled();
            logger.info("Element is enabled: {}", isEnabled);
            return isEnabled;
        } catch (WebDriverException e) {
            logger.error("Failed to check if the element is enabled: {}", element, e);
            throw e;
        }
    }

    @Override
    public String getText() {
        try {
            logger.debug("Attempting to get text of the element: {}", element);
            String text = element.getText();
            logger.info("Successfully fetched text: '{}'", text);
            return text;
        } catch (WebDriverException e) {
            logger.error("Failed to get text for the element: {}", element, e);
            throw e;
        }
    }

    @Override
    public List<WebElement> findElements(By by) {
        try {
            logger.debug("Finding elements by locator: {}", by);
            List<WebElement> foundElements = element.findElements(by);
            logger.info("Found {} element(s) by locator: {}", foundElements.size(), by);
            return foundElements;
        } catch (WebDriverException e) {
            logger.error("Failed to find elements by locator: {}", by, e);
            throw e;
        }
    }

    @Override
    public WebElement findElement(By by) {
        try {
            logger.debug("Finding single element by locator: {}", by);
            WebElement foundElement = element.findElement(by);
            logger.info("Successfully found element: {}", foundElement);
            return foundElement;
        } catch (WebDriverException e) {
            logger.error("Failed to find element by locator: {}", by, e);
            throw e;
        }
    }

    @Override
    public boolean isDisplayed() {
        try {
            logger.debug("Checking if the element is displayed: {}", element);
            boolean isDisplayed = element.isDisplayed();
            logger.info("Element is displayed: {}", isDisplayed);
            return isDisplayed;
        } catch (WebDriverException e) {
            logger.error("Failed to check if the element is displayed: {}", element, e);
            throw e;
        }
    }

    @Override
    public Point getLocation() {
        try {
            logger.debug("Getting location of the element: {}", element);
            Point location = element.getLocation();
            logger.info("Element location: {}", location);
            return location;
        } catch (WebDriverException e) {
            logger.error("Failed to get location for the element: {}", element, e);
            throw e;
        }
    }

    @Override
    public Dimension getSize() {
        try {
            logger.debug("Getting size of the element: {}", element);
            Dimension size = element.getSize();
            logger.info("Element size: {}", size);
            return size;
        } catch (WebDriverException e) {
            logger.error("Failed to get size for the element: {}", element, e);
            throw e;
        }
    }

    @Override
    public Rectangle getRect() {
        try {
            logger.debug("Getting rectangle of the element: {}", element);
            Rectangle rect = element.getRect();
            logger.info("Element rectangle: {}", rect);
            return rect;
        } catch (WebDriverException e) {
            logger.error("Failed to get rectangle for the element: {}", element, e);
            throw e;
        }
    }

    @Override
    public String getCssValue(String propertyName) {
        try {
            logger.debug("Getting CSS value for property '{}':", propertyName);
            String cssValue = element.getCssValue(propertyName);
            logger.info("CSS value for '{}': {}", propertyName, cssValue);
            return cssValue;
        } catch (WebDriverException e) {
            logger.error("Failed to get CSS value for property '{}':", propertyName, e);
            throw e;
        }
    }
}
