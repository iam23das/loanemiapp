package emicalculator.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import emicalculator.driverCenter.WebElementFacade;

public class BasePage implements LoanPage {
	
	protected WebElementFacade loanAmountElement;
	protected WebElementFacade interestRateAmountElement;
	protected WebElementFacade loanTenureValueElement;
	protected WebElementFacade loanEmiAmountElement;
	protected WebElementFacade totalInterestPayableElement;
	protected WebElementFacade totalPaymentElement;
	protected WebElementFacade yearElement;
	protected WebElementFacade monthElement;

	public BasePage(WebDriver driver) {
		loanAmountElement = new WebElementFacade(driver, By.id("loanamount"));
		interestRateAmountElement = new WebElementFacade(driver, By.id("loaninterest"));
		loanTenureValueElement = new WebElementFacade(driver, By.id("loanterm"));
		loanEmiAmountElement = new WebElementFacade(driver, By.xpath("//div[@id='emiamount']/p/span"));
		totalInterestPayableElement = new WebElementFacade(driver, By.id("//div[@id='emitotalinterest']/p/span"));
		totalPaymentElement = new WebElementFacade(driver, By.xpath("//div[@id='emitotalamount']/p/span"));
	    yearElement = new WebElementFacade(driver, By.xpath("//input[@id='loanyears']"));
	    monthElement = new WebElementFacade(driver, By.xpath("//input[@id='loanmonths']"));
	}

	@Override
	public void enterLoanAmount(String amount) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterInterestRate(String interestRate) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterLoanTenureInYear(String tenure) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterLoanTenureInMonths(String tenure) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getEmiAmount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTotalInterestPayable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTotalPayment() {
		// TODO Auto-generated method stub
		return null;
	}

}
