package emicalculator.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PropertyUtils {
	private static final Logger logger = LogManager.getLogger(PropertyUtils.class);
    private static final Properties properties = new Properties();
    private static final String CONFIG_FILE_PATH = "src/main/resources/config.properties";

    // Static block to load properties when the class is loaded
    static {
        try (InputStream fis = PropertyUtils.class.getClassLoader().getResourceAsStream("config.properties")) {
            properties.load(fis);
            logger.info("Properties file loaded successfully.");
        } catch (IOException e) {
            logger.error("Error loading properties file.", e);
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    // Method to get a property value by key
    public static String getProperty(String key) {
        String value = properties.getProperty(key);
        if (value == null || value.isEmpty()) {
            logger.warn("Property '{}' is not defined or empty in config.properties.", key);
            return null;
        }
        logger.info("Property '{}' retrieved successfully.", key);
        return value;
    }
}
