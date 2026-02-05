package se.iths.lw.lab2testing.exceptions;

public class MaxWithdrawalExceededException extends RuntimeException{

    public MaxWithdrawalExceededException(String message) {
        super(message);
    }
}
