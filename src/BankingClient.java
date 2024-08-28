import java.util.Random;
import java.util.Scanner;

public class BankingClient {
    private static final BankingAccount[] accounts = new BankingAccount[100];
    private static int accountCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("=====================================");
            System.out.println("          Banking Account Menu       ");
            System.out.println("=====================================");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Print Balance");
            System.out.println("5. Transfer");
            System.out.println("6. Exit");
            System.out.println("=====================================");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("***************************************");
                    System.out.println("* WARNING: Initial deposit required!  *");
                    System.out.println("***************************************");
                    System.out.println("Deposit an initial balance of at least 500 to open an account.");
                    System.out.println("Enter the deposit amount: ");
                    float initialBalance = scanner.nextFloat();
                    if(initialBalance>=500)
                {
                    Random random = new Random();
                    BankingAccount newAccount = new BankingAccount(initialBalance, Math.abs(random.nextLong()));
                    accounts[accountCount++] = newAccount;
                    System.out.println("Account created with account number: " + newAccount.getAccountNumber());
                }else{
                        System.out.println("***************************************");
                        System.out.println("* WARNING: Initial deposit of 500 required!  *");
                        System.out.println("***************************************");
                    }
                    break;
                case 2:
                    System.out.print("Enter account number: ");
                    long depositAccountNumber = scanner.nextLong();
                    BankingAccount depositAccount = findAccount(depositAccountNumber);
                    if (depositAccount != null) {
                        System.out.print("Enter deposit amount: ");
                        float depositAmount = scanner.nextFloat();
                        depositAccount.deposit(depositAmount);

                    } else {
                        System.out.println("***************************************");
                        System.out.println("* Account not found! *");
                        System.out.println("***************************************");
                    }
                    break;
                case 3:
                    System.out.print("Enter account number: ");
                    long withdrawAccountNumber = scanner.nextLong();
                    BankingAccount withdrawAccount = findAccount(withdrawAccountNumber);
                    if (withdrawAccount != null) {
                        System.out.print("Enter withdraw amount: ");
                        float withdrawAmount = scanner.nextFloat();
                        withdrawAccount.withdraw(withdrawAmount);
                    } else {
                        System.out.println("***************************************");
                        System.out.println("* Account not found! *");
                        System.out.println("***************************************");
                    }
                    break;
                case 4:
                    System.out.print("Enter account number: ");
                    long balanceAccountNumber = scanner.nextLong();
                    BankingAccount balanceAccount = findAccount(balanceAccountNumber);
                    if (balanceAccount != null) {
                        balanceAccount.printBalance();
                    } else {
                        System.out.println("***************************************");
                        System.out.println("* Account not found! *");
                        System.out.println("***************************************");
                    }
                    break;
                case 5:
                    System.out.print("Enter your account number: ");
                    long fromAccountNumber = scanner.nextLong();
                    BankingAccount fromAccount = findAccount(fromAccountNumber);
                    if (fromAccount != null) {
                        System.out.print("Enter recipient account number: ");
                        long toAccountNumber = scanner.nextLong();
                        BankingAccount toAccount = findAccount(toAccountNumber);
                        if (toAccount != null) {
                            System.out.print("Enter transfer amount: ");
                            float transferAmount = scanner.nextFloat();
                            fromAccount.transfer(toAccount, transferAmount);
                        } else {
                            System.out.println("***************************************");
                            System.out.println("Recipient account not found.");
                            System.out.println("***************************************");

                        }
                    } else {
                        System.out.println("***************************************");
                        System.out.println("* Account not found! *");
                        System.out.println("***************************************");
                    }
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static BankingAccount findAccount(long accountNumber) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i].getAccountNumber() == accountNumber) {
                return accounts[i];
            }
        }
        return null;
    }
}