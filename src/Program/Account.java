package Program;

import Utilities.Utils;

public class Account {

	private static int accountCounter = 1;

    private int NumberAccount;
    private Client client;
    private Double balance = 0.0;


    public Account(Client client) {
        this.NumberAccount = Account.accountCounter;
        this.client = client;
        this.updateBalance();
        Account.accountCounter += 1;
    }


    public int getNumberAccount() {
        return NumberAccount;
    }
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    public Double getBalance() {
        return balance;
    }
    public void setBalance(Double balance) {
        this.balance = balance;
    }

    private void updateBalance() {
        this.balance = this.getBalance();
    }

    public String toString() {

        return "\nBank account: " + this.getNumberAccount() +
                "\nClient: " + this.client.getName() +
                "\nCPF: " + this.client.getCpf() +
                "\nEmail: " + this.client.getEmail() +
                "\nBalance: " + Utils.doubleToString(this.getBalance()) +
                "\n" ;
    }

    public void deposit(Double value) {
        if(value > 0) {
            setBalance(getBalance() + value);
            
            System.out.println("Your deposit was successful!");
        }else {
            System.out.println("Could not make a deposit!");
        }
    }

    public void withdraw(Double value) {
        if(value > 0 && this.getBalance() >= value) {
            setBalance(getBalance() - value);
            System.out.println("Successful withdraw!");
        }else {
            System.out.println("It is not possible to withdraw!");
        }
    }

    public void transfer(Account depositAccount, Double value) {
        if(value > 0 && this.getBalance() >= value) {
            setBalance(getBalance() - value );
        
            depositAccount.balance = depositAccount.getBalance() + value;
            System.out.println("Transfer completed successfully!");
        }else {
            System.out.println("It is not possible to transfer!");
        }

    }
}

