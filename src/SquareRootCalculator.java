import java.util.Scanner;

public class SquareRootCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter a number: ");
            double num = sc.nextDouble();
            if (num < 0) throw new ArithmeticException("Cannot calculate the square root of a negative number.");
            System.out.println("Square root: " + Math.sqrt(num));
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: Invalid input. Please enter a numeric value.");
        }
    }
}
