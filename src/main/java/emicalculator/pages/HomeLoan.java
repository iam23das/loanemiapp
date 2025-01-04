package emicalculator.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import emicalculator.driverCenter.WebElementFacade;

public class HomeLoan implements LoanPage{
	private WebElementFacade homeLoanAmountElement;
	private WebElementFacade interestRateAmountElement;
	private WebElementFacade loanTenureValueElement;
	private WebElementFacade loanEmiAmountElement;
	private WebElementFacade totalInterestPayableElement;
	private WebElementFacade totalPaymentElement;
	private WebElementFacade yearOrMnthElement;

	public HomeLoan(WebDriver driver) {
		homeLoanAmountElement = new WebElementFacade(driver, By.id("loanamount"));
		interestRateAmountElement = new WebElementFacade(driver, By.id("loaninterest"));
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
