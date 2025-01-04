package emicalculator.pages;

import org.openqa.selenium.WebDriver;

public class HomeLoanPage extends BasePage {

	public HomeLoanPage(WebDriver driver) {
		super(driver);
	}
	 
	public void enterHomeLoanAmount(String amount) {
		loanAmountElement.sendKeys(amount);
	}
	
	@Override
	public void enterInterestRate(String interestRate) {
		interestRateAmountElement.sendKeys(interestRate);
	}

	@Override
	public void enterLoanTenureInYear(String tenure) {
		yearElement.click();
		loanTenureValueElement.sendKeys(tenure);
	}

	@Override
	public void enterLoanTenureInMonths(String tenure) {
		monthElement.click();
		loanTenureValueElement.sendKeys(tenure);
	}

	@Override
	public String getEmiAmount() {
		return loanEmiAmountElement.getValue();
	}

	@Override
	public String getTotalInterestPayable() {
		return totalInterestPayableElement.getText();
	}

	@Override
	public String getTotalPayment() {
		return totalPaymentElement.getText();
	}

}
