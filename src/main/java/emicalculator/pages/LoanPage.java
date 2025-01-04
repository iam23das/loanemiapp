package emicalculator.pages;

import emicalculator.driverCenter.WebElementFacade;

public interface LoanPage {
      void enterLoanAmount();
      void enterInterestRate();
      void enterLoanTenureInYear();
      void enterLoanTenureInMonths();
      String getEmiAmount();
      String getTotalInterestPayable();
      String getTotalPayment();
}
