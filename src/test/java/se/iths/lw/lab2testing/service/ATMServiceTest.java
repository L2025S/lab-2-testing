package se.iths.lw.lab2testing.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import se.iths.lw.lab2testing.component.AccountComponent;
import se.iths.lw.lab2testing.exceptions.InsufficientFundsException;
import se.iths.lw.lab2testing.exceptions.InvalidAmountException;
import se.iths.lw.lab2testing.exceptions.MaxWithdrawalExceededException;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ATMServiceTest {

    @Mock
    private AccountComponent accountComponent;

    @InjectMocks
    private ATMService atmService;



    // Test withdraw method can throw 3 different exceptions.
    @Test
    public void testWithdrawWithNegativeAmountThrowException(){

        //Arrange

        int amount = -10;


        //Act + Assert
        Assertions.assertThrows(InvalidAmountException.class, ()-> atmService.withdraw(amount));
    }

    @Test
    public void testWithdrawAboveLimitThrowException(){
        //Arrange
        int amount = 200000;
        when(accountComponent.getBalance()).thenReturn(500000);
        // Act

        // Assert
        Assertions.assertThrows(MaxWithdrawalExceededException.class, ()-> atmService.withdraw(amount));
        //verify(accountComponent, never()).withdraw(anyInt());
        verify(accountComponent,times(0)).withdraw(amount);

    }

    @Test
    public void testWithdrawExceededAmountThrowException(){

        //Arrange
        int amount = 50000;

        when(accountComponent.getBalance()).thenReturn(1000);

        //Act & Assert
        Assertions.assertThrows(InsufficientFundsException.class, ()-> atmService.withdraw(amount));
        verify(accountComponent, never()).withdraw(anyInt());
        verify(accountComponent, times(0)).withdraw(amount);

    }

    @Test
    public void testDepositWithNegativeThrowException(){
        //Arrange
        int amount = -10;
        //Act + Assert
        Assertions.assertThrows(InvalidAmountException.class, ()-> atmService.deposit(amount));
        verify(accountComponent,times(0)).deposit(amount);
        verify(accountComponent,never()).deposit(anyInt());
    }

    //Test if the deposit, withdraw and showBalance work as expected.

    @Test
    public void testWithdraw(){

        //Arrange
        int amount = 1000;

        when(accountComponent.getBalance()).thenReturn(1001000);


        //Act
        atmService.withdraw(amount);

        //Assert
        verify(accountComponent).withdraw(amount);

    }

    @Test
    public void testDeposit(){
        //Arrange
        int amount = 50000;
        when(accountComponent.deposit(amount)).thenReturn(10050000);

        //Act
        atmService.deposit(amount);

        //Assert
        verify(accountComponent).deposit(amount);
        // It verifies that AccountComponent's object/instance has called the method withdraw();
    }

    @Test
    public void testShowBalance(){
        //Arrange
        when(accountComponent.getBalance()).thenReturn(1000000);

        //Act
        int result = atmService.showBalance();

        //Assert
        Assertions.assertEquals(1000000,result);
    }



}
