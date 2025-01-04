package emicalculator.pages;

public interface LoanPage {
      void enterLoanAmount();
      void enterInterestRate();
      void enterLoanTenureInYear();
      void enterLoanTenureInMonths();
      String getEmiAmount();
      String getTotalInterestPayable();
      String getTotalPayment();
}
