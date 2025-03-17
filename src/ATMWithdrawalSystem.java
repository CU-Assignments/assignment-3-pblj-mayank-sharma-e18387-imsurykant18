import java.util.Scanner;

class InvalidPinException extends Exception {
    public InvalidPinException(String message) {
        super(message);
    }
}

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

public class ATMWithdrawalSystem {
    private static final int PIN = 1234;
    private static double balance = 3000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter PIN: ");
            int enteredPin = sc.nextInt();
            if (enteredPin != PIN) throw new InvalidPinException("Invalid PIN.");

            System.out.print("Withdraw Amount: ");
            double amount = sc.nextDouble();
            if (amount > balance) throw new InsufficientBalanceException("Insufficient balance.");

            balance -= amount;
            System.out.println("Withdrawal successful! Remaining Balance: " + balance);
        } catch (InvalidPinException | InsufficientBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: Invalid input.");
        } finally {
            System.out.println("Current Balance: " + balance);
        }
    }
}
