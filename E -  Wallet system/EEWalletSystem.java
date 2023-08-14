//import java.util.HashMap;
//import java.util.Map;
//
//class BankAccount {
//    private String accountNumber;
//    private double balance;
//
//    public BankAccount(String accountNumber, double balance) {
//        this.accountNumber = accountNumber;
//        this.balance = balance;
//    }
//
//    public String getAccountNumber() {
//        return accountNumber;
//    }
//
//    public double getBalance() {
//        return balance;
//    }
//
//    public void deposit(double amount) {
//        balance += amount;
//    }
//
//    public boolean withdraw(double amount) {
//        if (amount <= balance) {
//            balance -= amount;
//            return true;
//        } else {
//            return false;
//        }
//    }
//}
//
//class WalletAccount {
//    private String accountId;
//    private BankAccount linkedBankAccount;
//    private double balance;
//    private double creditLimit;
//    private double usageLimit;
//
//    public WalletAccount(String accountId, BankAccount linkedBankAccount, double creditLimit, double usageLimit) {
//        this.accountId = accountId;
//        this.linkedBankAccount = linkedBankAccount;
//        this.creditLimit = creditLimit;
//        this.usageLimit = usageLimit;
//    }
//
//    public String getAccountId() {
//        return accountId;
//    }
//
//    public double getBalance() {
//        return balance;
//    }
//
//    public double getCreditLimit() {
//        return creditLimit;
//    }
//
//    public double getUsageLimit() {
//        return usageLimit;
//    }
//
//    public boolean recharge(double amount) {
//        double newBalance = balance + amount;
//        if (newBalance <= creditLimit) {
//            balance = newBalance;
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    public boolean use(double amount) {
//        if (amount <= balance && amount <= usageLimit) {
//            balance -= amount;
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    public void viewUsageDetails() {
//        System.out.println("Account ID: " + accountId);
//        System.out.println("Balance: " + balance);
//    }
//}
//
//class Parent {
//    private String parentId;
//    private WalletAccount walletAccount;
//
//    public Parent(String parentId, WalletAccount walletAccount) {
//        this.parentId = parentId;
//        this.walletAccount = walletAccount;
//    }
//
//    public String getParentId() {
//        return parentId;
//    }
//
//    public WalletAccount getWalletAccount() {
//        return walletAccount;
//    }
//
//    public void rechargeWallet(double amount) {
//        if (walletAccount.recharge(amount)) {
//            System.out.println("Wallet recharge successful!");
//        } else {
//            System.out.println("Exceeded credit limit. Wallet recharge failed!");
//        }
//    }
//
//    public void setUsageLimit(double usageLimit) {
//        walletAccount.usageLimit = usageLimit;
//    }
//
//    public void viewUsageDetails() {
//        walletAccount.viewUsageDetails();
//    }
//}
//
//class Student {
//    private String studentId;
//    private WalletAccount walletAccount;
//
//    public Student(String studentId, WalletAccount walletAccount) {
//        this.studentId = studentId;
//        this.walletAccount = walletAccount;
//    }
//
//    public String getStudentId() {
//        return studentId;
//    }
//
//    public WalletAccount getWalletAccount() {
//        return walletAccount;
//    }
//
//    public void rechargeWallet(double amount) {
//        if (walletAccount.recharge(amount)) {
//            System.out.println("Wallet recharge successful!");
//        } else {
//            System.out.println("Exceeded credit limit. Wallet recharge failed!");
//        }
//    }
//
//    public void viewUsageDetails() {
//        walletAccount.viewUsageDetails();
//    }
//}
//
//public class EEWalletSystem {
//    public static void main(String[] args) {
//        BankAccount bankAccount = new BankAccount("123");
//        WalletAccount walletAccount = new WalletAccount("456", bankAccount, 500.0, 1000.0);
//        Parent parent = new Parent("P001", walletAccount);
//        Student student = new Student("S001", walletAccount);
//
//        // Parent performs actions
//        parent.rechargeWallet(200.0);
//        parent.setUsageLimit(800.0);
//        parent.viewUsageDetails();
//
//        // Student performs actions
//        student.rechargeWallet(100.0);
//        student.viewUsageDetails();
//        student.getWalletAccount().use(150.0); // Attempting to use more than the available balance
//
//        // Output usage details after attempted usage
//        student.viewUsageDetails();
//    }
//}
//
//
