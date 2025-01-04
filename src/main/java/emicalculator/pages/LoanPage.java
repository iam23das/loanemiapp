package emicalculator.pages;

import emicalculator.driverCenter.WebElementFacade;

public interface LoanPage {
      void enterLoanAmount(String amount);
      void enterInterestRate(String interestRate);
      void enterLoanTenureInYear(String tenure);
      void enterLoanTenureInMonths(String tenure);
      String getEmiAmount();
      String getTotalInterestPayable();
      String getTotalPayment();
}
