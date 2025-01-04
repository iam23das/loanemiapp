package emicalculator.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import emicalculator.driverCenter.WebElementFacade;

public abstract class BasePage implements LoanPage {
	private WebElementFacade loanAmountElement;
	private WebElementFacade interestRateAmountElement;
	private WebElementFacade loanTenureValueElement;
	private WebElementFacade loanEmiAmountElement;
	private WebElementFacade totalInterestPayableElement;
	private WebElementFacade totalPaymentElement;
	private WebElementFacade yearElement;
	private WebElementFacade monthElement;

	public BasePage(WebDriver driver) {
		loanAmountElement = new WebElementFacade(driver, By.id("loanamount"));
		interestRateAmountElement = new WebElementFacade(driver, By.id("loaninterest"));
		loanTenureValueElement = new WebElementFacade(driver, By.id("loanterm"));
		loanEmiAmountElement = new WebElementFacade(driver, By.xpath("//div[@id='emiamount']/p/span"));
		totalInterestPayableElement = new WebElementFacade(driver, By.id("//div[@id='emitotalinterest']/p/span"));
		totalPaymentElement = new WebElementFacade(driver, By.xpath("//div[@id='emitotalamount']/p/span"));
	}
	

	@Override
	public void enterLoanAmount() {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterInterestRate() {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterLoanTenureInYear() {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterLoanTenureInMonths() {
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
