package com.sv.initial;

import org.junit.jupiter.api.Test;

import java.util.Date;

public class CapitalCalculationTests {

    double commitment = 50.00;
    int riskTaking = 20;
    Date maturity = new Date();
    CapitalStrategy riskAdjustedCapitalStrategy = null;
    double outstanding = 79.00;
    

    @Test
    public void testTermLoanNoPayments() {
        //...
        Loan termLoan = new Loan(commitment, riskTaking, maturity);
        //...
    }

    @Test
    public void testTermLoanOnePayment() {
        //...
        Loan termLoan = new Loan(commitment, riskTaking, maturity);
        //...
    }

    @Test
    public void testTermLoanWithRiskAdjustedCapitalStrategy(){
        //...
        Loan termLoan = new Loan(riskAdjustedCapitalStrategy, commitment, outstanding, riskTaking, maturity, null);
        //...
    }
}
