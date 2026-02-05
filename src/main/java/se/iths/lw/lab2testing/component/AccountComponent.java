package se.iths.lw.lab2testing.component;


public class AccountComponent {
    private Long accountId;
    private int balance;

    public AccountComponent() {
    }

    public AccountComponent(int balance, Long accountId) {
        this.balance = balance;
        this.accountId = accountId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "AccountComponent{" +
                "accountId=" + accountId +
                ", balance=" + balance +
                '}';
    }

    public int deposit(int amount){
        return balance +=amount;

    }

    public int withdraw(int amount){
        return balance -= amount;
    }

}
