package emicalculator.unittests;

import emicalculator.utility.PropertyUtils;
import org.junit.Assert;
import org.junit.Test;

public class CheckingPropertyLoadFunction {
    @Test
    public void testPropertyLoad(){
        Assert.assertEquals(PropertyUtils.getProperty("chrome.driver.path"), "D:\\WebDriver\\chromedriver.exe");
    }
}
