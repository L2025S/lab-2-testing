package se.iths.lw.lab2testing.service;

import se.iths.lw.lab2testing.component.AccountComponent;
import se.iths.lw.lab2testing.exceptions.InsufficientFundsException;
import se.iths.lw.lab2testing.exceptions.InvalidAmountException;
import se.iths.lw.lab2testing.exceptions.MaxWithdrawalExceededException;


public class ATMService {
    private final AccountComponent accountComponent;
    private static final int MAX_WITHDRAWAL_AMOUNT = 100000;
    private static final int MIN_AMOUNT = 1;

    public ATMService(AccountComponent accountComponent) {
        this.accountComponent = accountComponent;
    }

    public void withdraw(int amount){
        if (amount < MIN_AMOUNT) {
            throw new InvalidAmountException(String.format("The minimum amount is %d.", MIN_AMOUNT));
        } else if (amount > accountComponent.getBalance()) {
            throw new InsufficientFundsException("There is no sufficient amount in the account.");
        } else if(amount > MAX_WITHDRAWAL_AMOUNT ) {
            throw new MaxWithdrawalExceededException(String.format("The maximum amount per withdrawal is %d.", MAX_WITHDRAWAL_AMOUNT));
        } else {
             accountComponent.withdraw(amount);
        }

    }

    public void deposit(int amount) {
        if (amount <=MIN_AMOUNT) {
            throw new InvalidAmountException(String.format("The minimum amount is %d.", MIN_AMOUNT));
        } else {
           accountComponent.deposit(amount);
        }

    }

    public int showBalance(){

        return accountComponent.getBalance();
    }


}
