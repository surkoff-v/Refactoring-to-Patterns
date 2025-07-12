package com.sv.MyWork;

import org.junit.Test;

import java.util.Date;

public class AnotherTest {

    double commitment = 50.00;
    int riskTaking = 20;
    Date maturity = new Date();
    double outstanding = 0;
    int riskRating = 20;
    Date expiry = new Date();

    @Test
    public void testTermLoanNoPayments() {
        Loan termLoan = Loan.createTermLoan(commitment, riskTaking, maturity);
    }

    @Test
    public void testTermLoanOnePayment() {
        Loan termLoan = Loan.createTermLoan(commitment, riskTaking, maturity);
    }

    @Test
    public void testTermLoanWithNullExpiryPassed(){
        Loan termLoan = Loan.createTermLoan(commitment, riskTaking, maturity);
    }
    
    @Test
    public void testRCTL(){
        //...
        Loan rctlLoan = Loan.createRCTL(null, commitment, outstanding, riskRating, maturity, expiry);
        //...
    }

    @Test
    public void testRCTLWithNullCapitalStrategyAndNoOutstanding(){
        //...
        Loan rctlLoan = Loan.createRCTL(commitment, riskRating, maturity, expiry);
        //...
    }


    @Test
    public void testRevolver(){
        //...
        Loan revolverLoan = Loan.createRevolverLoan(commitment, outstanding, riskRating, expiry);
        //...
    }


    @Test
    public void testRevolverWithCapitalStrategy(){
        //...
        Loan revolverLoan = Loan.getRevolverLoan(new CapitalStrategyRCTL(),commitment, outstanding, riskRating, expiry);
        //...
    }

}
