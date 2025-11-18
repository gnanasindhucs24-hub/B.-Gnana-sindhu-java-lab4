class Account {
    protected String customerName;
    protected int accountNumber;
    protected String accountType;
    protected double balance;

    public Account(String name, int accNo, String type) {
        this.customerName = name;
        this.accountNumber = accNo;
        this.accountType = type;
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited ₹" + amount + ". New balance: ₹" + balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void displayBalance() {
        System.out.println("Account Balance for " + customerName + " (#" + accountNumber + "): ₹" + balance);
    }
}
class SavAcct extends Account {
    private final double interestRate = 0.04; // 4% annual

    public SavAcct(String name, int accNo) {
        super(name, accNo, "Savings");
    }

    public void computeInterest(int months) {
        double interest = balance * interestRate * months / 12;
        balance += interest;
        System.out.printf("Interest of ₹%.2f added for %d months. New balance: ₹%.2f%n", interest, months, balance);
    }

    public void withdraw(double amount) {
        double minBalance = 500;
        double penalty = 50;

        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew ₹" + amount + ". New balance: ₹" + balance);
            if (balance < minBalance) {
                balance -= penalty;
                System.out.println("Balance below ₹" + minBalance + ". Penalty of ₹" + penalty + " imposed. New balance: ₹" + balance);
            }
        } else {
            System.out.println("Insufficient funds for withdrawal.");
        }
    }
}
class CurAcct extends Account {
    private final double minBalance = 1000;
    private final double penalty = 100;

    public CurAcct(String name, int accNo) {
        super(name, accNo, "Current");
    }

    public void computeInterest(int months) {
        System.out.println("No interest for current accounts.");
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew ₹" + amount + ". New balance: ₹" + balance);
            if (balance < minBalance) {
                balance -= penalty;
                System.out.println("Balance below ₹" + minBalance + ". Penalty of ₹" + penalty + " imposed. New balance: ₹" + balance);
            }
        } else {
            System.out.println("Insufficient funds for withdrawal.");
        }
    }
}
public class BankDemo {
    public static void main(String[] args) {
        SavAcct s = new SavAcct("Alice", 101);
        s.deposit(2000);
        s.computeInterest(6);
        s.withdraw(1800);
        s.displayBalance();

        System.out.println();

        CurAcct c = new CurAcct("Bob", 102);
        c.deposit(3000);
        c.withdraw(2500);
        c.computeInterest(6);
        c.displayBalance();
    }
}