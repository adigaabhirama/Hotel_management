import java.util.Scanner;

public class PrimeNumber{

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter the  range: ");
        int start = s.nextInt();

        System.out.print("Enter the  range: ");
        int end = s.nextInt();

        System.out.println("Prime numbers between " + start + " and " + end + ":");
        generatePrimeNumbers(start, end);
    }

    private static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static void generatePrimeNumbers(int start, int end) {
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
    }
}