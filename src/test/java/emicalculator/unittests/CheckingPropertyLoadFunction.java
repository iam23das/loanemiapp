package emicalculator.unittests;

import emicalculator.utility.PropertyUtils;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

import org.junit.Assert;
import org.junit.Test;

public class CheckingPropertyLoadFunction {
    @Test
    public void testPropertyLoad(){
    	System.out.println(PropertyUtils.getProperty("chrome.driver.path"));
        Assert.assertEquals(PropertyUtils.getProperty("chrome.driver.path"), "D:\\WebDriver\\chromedriver.exe");
    }
}
