package emicalculator.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomeLoanPage extends BasePage {
	private static final Logger logger = LogManager.getLogger(HomeLoanPage.class);

    public HomeLoanPage(WebDriver driver) {
        super(driver);
        logger.info("HomeLoanPage initialized with WebDriver.");
    }
    
    public void clearallFields() {
    	logger.debug("Clearing Loan Amount field...");
        loanAmountElement.clear();
        logger.debug("Loan Amount field cleared successfully.");

        logger.debug("Clearing Interest Rate field...");
        interestRateAmountElement.clear();
        logger.debug("Interest Rate field cleared successfully.");

        logger.debug("Clearing Loan Tenure field...");
        loanTenureValueElement.clear();
        logger.debug("Loan Tenure field cleared successfully.");

        logger.info("All fields cleared successfully.");
    }

    public void enterHomeLoanAmount(String amount) {
        logger.info("Entering home loan amount: {}", amount);
        loanAmountElement.sendKeys(amount);
        logger.debug("Home loan amount '{}' entered successfully.", amount);
    }

    @Override
    public void enterInterestRate(String interestRate) { 
        logger.info("Entering interest rate: {}", interestRate);
        interestRateAmountElement.sendKeys(Keys.BACK_SPACE + interestRate);
        logger.debug("Interest rate '{}' entered successfully.", interestRate);
    }

    @Override
    public void enterLoanTenureInYear(String tenure) {
        logger.info("Entering loan tenure in years: {}", tenure);
        yearElement.scrollAndClick();
        logger.debug("Year element clicked.");
        loanTenureValueElement.sendKeys(tenure);
        logger.debug("Loan tenure '{}' years entered successfully.", tenure);
    }

    @Override
    public void enterLoanTenureInMonths(String tenure) {
        logger.info("Entering loan tenure in months: {}", tenure);
        monthElement.click();
        logger.debug("Month element clicked.");
        loanTenureValueElement.sendKeys(tenure);
        logger.debug("Loan tenure '{}' months entered successfully.", tenure);
    }

    @Override
    public String getEmiAmount() {
        logger.info("Retrieving EMI amount.");
        String emi = loanEmiAmountElement.getText();
        logger.debug("Retrieved EMI amount: {}", emi);
        return emi;
    }

    @Override
    public String getTotalInterestPayable() {
        logger.info("Retrieving total interest payable.");
        String totalInterest = totalInterestPayableElement.getText();
        logger.debug("Retrieved total interest payable: {}", totalInterest);
        return totalInterest;
    }

    @Override
    public String getTotalPayment() {
        logger.info("Retrieving total payment.");
        String totalPayment = totalPaymentElement.getText();
        logger.debug("Retrieved total payment: {}", totalPayment);
        return totalPayment;
    }
}
