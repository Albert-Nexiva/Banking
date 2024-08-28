public class BankingAccount {
   private float balance;
private long accountNumber;
   public BankingAccount(){}

    public BankingAccount(float balance,long accountNumber){
       this.balance=balance;
       this.accountNumber=accountNumber;
    }

    // Method to get account Number;
    public long getAccountNumber() {
        return this.accountNumber;
    }

    // Method to deposit amount to balance;
    public void deposit(float depositAmount){
       if(depositAmount<=0){
           return;
       }
       if(depositAmount>0){
           this.balance+=depositAmount;
           System.out.println("***************************************");
           System.out.println("Deposited: " + depositAmount);
           System.out.println("***************************************");
           System.out.println("Available Balance: "+ this.balance);
           System.out.println("***************************************");
       }else{
           System.out.println("Deposit amount must be greater than Zero.");
       }

    }
    // Method to withdraw an amount from the balance
    public void withdraw(float withdrawAmount) {
        if (withdrawAmount > 0 && withdrawAmount <= this.balance) {
            this.balance -= withdrawAmount;
            System.out.println("***************************************");
            System.out.println("Amount Withdrawn: " + withdrawAmount);
            System.out.println("***************************************");
            System.out.println("Available Balance: "+ this.balance);
            System.out.println("***************************************");
        } else {
            System.out.println("Insufficient balance");
        }
    }
    // Method to print the current balance
    public void printBalance() {
        System.out.println("Current balance: " + this.balance);
    }
    // Method to transfer balance from one bank account to another
    public void transfer(BankingAccount transferAccount, float amount) {
        if (amount > 0 && amount <= balance) {
            this.withdraw(amount);
            transferAccount.deposit(amount);
            System.out.println("Transfer successful.");
        } else {
            System.out.println("Transfer failed. Check the amount and balance.");
        }
    }
}
