package emicalculator.runner;

import org.openqa.selenium.WebDriver;

import emicalculator.driverCenter.DriverManager;
import emicalculator.pages.HomeLoanPage;
import emicalculator.utility.PropertyUtils;

public class Runner {
	
	public static void main(String[] args) {
		DriverManager driverManager = DriverManager.getInstance();
		WebDriver driver = driverManager.getDriver("chrome", true);
		driverManager.clearCache();
		driverManager.maximizeBrowser();
		driverManager.openPage(PropertyUtils.getProperty("home.url"));
		HomeLoanPage homeLoan = new HomeLoanPage(driver);
		homeLoan.clearallFields();
		homeLoan.enterHomeLoanAmount("500000");
		homeLoan.enterInterestRate("11.5");
		homeLoan.enterLoanTenureInYear("5");
		homeLoan.getEmiAmount();
		homeLoan.getTotalInterestPayable();
		homeLoan.getTotalPayment();
		driverManager.quitDriver();
	}
}
