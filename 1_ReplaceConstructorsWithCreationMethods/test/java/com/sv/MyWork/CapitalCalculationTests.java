package com.sv.MyWork;

import org.junit.Test;

import java.util.Date;

public class CapitalCalculationTests {

    double commitment = 50.00;
    int riskTaking = 20;
    Date maturity = new Date();
    double outstanding = 79.00;

    @Test
    public void testTermLoanNoPayments() {
        //...
        Loan termLoan = Loan.createTermLoan(commitment, riskTaking, maturity);
        //...
    }

    @Test
    public void testTermLoanOnePayment() {
        //...
        Loan termLoan = Loan.createTermLoan(commitment, riskTaking, maturity);
        //...
    }

    @Test
    public void testTermLoanWithRiskAdjustedCapitalStrategy(){
        //...
        Loan termLoan = Loan.createTermLoan(null, commitment, outstanding, riskTaking, maturity);
        //...
    }

}
