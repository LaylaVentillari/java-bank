package Program;

import java.util.ArrayList;
import java.util.Scanner;

public class BankBranch {
	
	static Scanner input = new Scanner(System.in);
	static ArrayList<Account> bankAccounts;
	
	public static void main(String[] args) {
		bankAccounts = new ArrayList<Account>();
		operations();
	}
	

    public static void operations() {

        System.out.println("------------------------------------------------------");
        System.out.println("-------------Welcome to our agency---------------");
        System.out.println("------------------------------------------------------");
        System.out.println("*****Select an operation you want to perform*****");
        System.out.println("------------------------------------------------------");
        System.out.println("|   Option 1 - Create account   |");
        System.out.println("|   Opção 2 - Deposit     |");
        System.out.println("|   Opção 3 - Withdraw        |");
        System.out.println("|   Opção 4 - Transfer   |");
        System.out.println("|   Opção 5 - List       |");
        System.out.println("|   Opção 6 - Exit         |");
        
        int operation = input.nextInt();
        
        switch(operation) {
        case 1:
        	createAccount();
        	break;
        	
        case 2:
    	    deposit();
    	    break;
    	    
        case 3:
        	withdraw();
        	break;
        	
        case 4:
        	transfer();
        	break;
        	
        case 5:
        	listAccounts();
        	break;
        	
        case 6:
    	System.out.println("Thanks for use our service!");
    	System.exit(0);
    	
    	default:
    		System.out.println("Invalid Option");
    		operations();
    		break;
        }
	}
    
    public static void createAccount() {
    	System.out.println("\nName:");
    	String name = input.next();
    	
    	System.out.println("\nCPF:");
    	String cpf = input.next();
    	
    	System.out.println("\nEmail:");
    	String email = input.next();
    	
    	Client client = new Client(name, cpf, email);
    	
    	Account account = new Account(client);
    	
    	bankAccounts.add(account);
    	System.out.println("Your account has been created successfully!");
    	
    	operations();
    	
    }
    
    private static Account findAccount(int numberAccount) {
    	Account account = null;
    	if(bankAccounts.size() > 0) {
    		for (Account c: bankAccounts) {
    			if(c.getNumberAccount() == numberAccount) {
    			account = c;
    		}
    	}
    }
    	return account;
    	
    }
    public static void deposit() {
    	System.out.println("Number account:");
    	int numberAccount = input.nextInt();
    	
    	Account account = findAccount(numberAccount);
    	
    	if(account != null) {
    		System.out.println("What amount do you want to deposit?");
    		Double depositValue = input.nextDouble();
    		
    		account.deposit(depositValue);
    	}else {
    		System.out.println("Account not found!");
    	}
    	
    	operations();
     }
     
     public static void withdraw() {
    	 System.out.println("Number account:");
    	 int numberAccount = input.nextInt();
    	 
    	 Account account = findAccount(numberAccount);
     	
     	if(account != null) {
     		System.out.println("What amount do you want to withdraw?");
     		Double withdrawValue = input.nextDouble();
     		
     		account.withdraw(withdrawValue);
     		System.out.println("Amount withdraw successfully!");
     	}else {
     		System.out.println("Account not found!");
     	}
     	
     	operations();
     }
     
     public static void transfer() {
    	 System.out.println("Sender account number:");
    	 int numberSenderAccount = input.nextInt();
    	 
    	 Account accountSender = findAccount(numberSenderAccount);
    	 
    	 if(accountSender != null) {
    		 System.out.println("Recipient account number:");
    		 int numberRecipientAccount = input.nextInt();
    		 
    		 Account accountRecipient = findAccount(numberRecipientAccount);
    		 
    		 if(accountRecipient != null) {
    			 System.out.println("Transfer value:");
    			 Double value = input.nextDouble();
    			 
    			 accountRecipient.transfer(accountSender, value);
    		 }else {
                 System.out.println("--- Sender account not found! ---");
             }

         }else {
             System.out.println("--- Transfer account not found!---");
       
    	 }
    	 operations(); 
     }
     
     public static void listAccounts() {
    	 if(bankAccounts.size()> 0) {
    		 for(Account account: bankAccounts) {
    			 System.out.println(account);
    		 }
    	 }else {
    		System.out.println("There are no registered accounts");
    	 }
    	 
    	 operations();
     }
}
     

