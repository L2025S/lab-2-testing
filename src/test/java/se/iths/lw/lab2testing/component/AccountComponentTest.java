package se.iths.lw.lab2testing.component;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountComponentTest {

    private AccountComponent account;

    @BeforeEach
    public void setUp(){
       account = new AccountComponent(0, 1L);
    }

    @Test
    public void depositTest(){

        //Arrange
        int amount = 100;

        // Act
        int result = account.deposit(amount);
        // Assert
        assertEquals(100, result);

    }

    @Test
    public void withdrawTest(){

        //Arrange
        int amount = 50;

        //Act
       int result = account.withdraw(amount);


        // Assert
        assertEquals(-50, result);
    }

    @Test
    public void getDefaultBalanceTest(){

        // Arrange
        // Act
        int result=account.getBalance();

        // Assert
        assertEquals(0, result);
    }

    @Test
    public void getCurrentBalanceTest(){
        //Arrange

        //Act
        int result1=account.deposit(500);
        int result2=account.withdraw(200);

        //Assert
        assertEquals(500, result1);
        assertEquals(300, result2);


    }
}
