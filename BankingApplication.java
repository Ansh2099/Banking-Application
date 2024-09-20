import java.util.Random;
import java.util.Scanner;

public class BankingApplication{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BankAccountInfo BK = new BankAccountInfo("Ashley", "abc1234");
        BK.showMenu();

        sc.close();
    }
}

class BankAccountInfo{

    double Balance = 0;
    double previousTransaction;
    String customerID;
    String customerName;
  
    Scanner s = new Scanner(System.in);

    BankAccountInfo(String customerName, String customerID){
        this.customerID = customerID;
        this.customerName = customerName;
    }

    void deposit(double amount){
        if(amount > 0){
            Balance += amount;
            previousTransaction = amount;
            System.out.println("Balance: " + Balance);
        } else{
            System.out.println("Please enter a valid amount.");
        }
    }

    void withdraw(double amount){
        if(amount < Balance && amount > 0){
            Balance -= amount;
            previousTransaction = -amount;
            System.out.println("Balance: " + Balance);
        } else{
            System.out.println("Please enter a valid amount.");
        }
    }

    void check(){
        System.out.println("Current Balance: " + Balance);
    }

    void checkPreviousTransaction(){
        if(previousTransaction > 0){
            System.out.println("Previous Transaction: " + previousTransaction);
        }else if(previousTransaction < 0){
            System.out.println("Previous Transaction: " + Math.abs(previousTransaction));
        }else{
            System.out.println("No previous transaction made");
        }
    }

    String dailyAdvice(){

        Random r = new Random();

        int random = r.nextInt(5) + 1;

        String no1 = "Review your bank statements regularly to catch any unauthorized transactions or errors." ;
        String no2 = "Consider opening a high-yield savings account for better interest rates on your deposits.";
        String no3 = "Be cautious of phishing scams - your bank will never ask for sensitive information via email or text.";
        String no4 = "If you're considering a major purchase or loan, check your credit report beforehand to ensure accuracy and address any issues.";
        String no5 = "Look into setting up account alerts for large transactions or low balances to help prevent overdrafts and catch potential fraud quickly.";
        
        return switch (random) {
            case 1 -> no1;
            case 2 -> no2;
            case 3 -> no3;
            case 4 -> no4;
            default -> no5;
        };
    }

    void showMenu(){

        System.out.println(" ");
        System.out.println("Welcome: " + customerName);
        System.out.println("Your Bank ID: " + customerID);
        System.out.println(" ");
        System.out.println("Here's your Daily Advice: " + dailyAdvice());
        System.out.println(" ");

        while(true){
        
        System.out.println(" ");
        System.out.println("What would you like to do today: ");
        System.out.println(" ");
        System.out.println("A. Check Bank Balance");
        System.out.println("B. Deposit Amount");
        System.out.println("C. Withdraw Amount");
        System.out.println("D. Check Previous Transactions");
        System.out.println("E. Exit");
        System.out.println(" ");

        String in = s.next().toLowerCase();
        char input = in.charAt(0);

        switch(input){

            case 'a' -> { 
                System.out.println(" ");
                check();
                }

            case 'b' -> {
                double amount = s.nextDouble();
                deposit(amount);
                }

            case 'c' -> {
                double amountToWithdraw = s.nextDouble();
                withdraw(amountToWithdraw);
                }

            case 'd' -> checkPreviousTransaction();

            case 'e' -> { 
                System.out.println("Thank you for using our services!");
                return;
                }

            default -> System.out.println("Invalid Command");
        }
       }
    }
    }