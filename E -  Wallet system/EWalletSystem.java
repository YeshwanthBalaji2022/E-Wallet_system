import java.util.HashMap;
import java.util.Map;


abstract class User {
    protected String username;
    protected double balance;
    protected BankAccount bankAccount;

    public User(String username, double balance, BankAccount bankAccount) {
        this.username = username;
        this.balance = balance;
        this.bankAccount = bankAccount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public abstract void viewUsageDetails();
}

class Stuuuudent extends User {
    public Stuuuudent(String username, double balance, BankAccount bankAccount) {
        super(username, balance, bankAccount);
    }

    public void recharge(double amount) {
        balance += amount;
        System.out.println("Recharged " + amount + " units. New balance: " + balance);
    }

    public void use(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Used " + amount + " units. Remaining balance: " + balance);
        } else {
            System.out.println("Insufficient balance. Please recharge your wallet.");
        }
    }

    public void viewUsageDetails() {
        System.out.println("Usage details for student " + username + ":");
    }
}

class Parent extends User {
    private double usageLimit;

    public Parent(String username, double balance, BankAccount bankAccount, double usageLimit) {
        super(username, balance, bankAccount);
        this.usageLimit = usageLimit;
    }

    public double getUsageLimit() {
        return usageLimit;
    }

    public void setUsageLimit(double usageLimit) {
        this.usageLimit = usageLimit;
    }

    public void recharge(double amount) {
        balance += amount;
        System.out.println("Recharged " + amount + " units. New balance: " + balance);
    }

    public void use(double amount) {
        if (balance >= amount) {
            if (amount <= usageLimit) {
                balance -= amount;
                System.out.println("Used " + amount + " units. Remaining balance: " + balance);
            } else {
                System.out.println("Exceeded usage limit. Please adjust the usage limit.");
            }
        } else {
            System.out.println("Insufficient balance. Please recharge your wallet.");
        }
    }

    public void viewUsageDetails() {
        System.out.println("Usage details for parent " + username + ":");
    }
}

class BankAccount {
    private String accountNumber;
    private String bankName;

    public BankAccount(String accountNumber, String bankName) {
        this.accountNumber = accountNumber;
        this.bankName = bankName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getBankName() {
        return bankName;
    }
}

public class EWalletSystem {
    private Map<String, User> users;

    public EWalletSystem() {
        users = new HashMap<>();
    }

    public void addUser(User user) {
        users.put(user.username, user);
    }

    public User getUser(String username) {
        return users.get(username);
    }

    public static void main(String[] args) {
        EWalletSystem eWallet = new EWalletSystem();

        BankAccount studentBankAccount = new BankAccount("123456789", "ABC Bank");
        BankAccount parentBankAccount = new BankAccount("987654321", "XYZ Bank");

        Stuuuudent student = new Stuuuudent("student1", 0, studentBankAccount);
        Parent parent = new Parent("parent1", 0, parentBankAccount, 100);

        eWallet.addUser(student);
        eWallet.addUser(parent);

        student.recharge(50);
        parent.recharge(100);

        student.use(20);
        parent.use(50);

        student.viewUsageDetails();
        parent.viewUsageDetails();
    }
}
