import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = 100;

        int minPrime = Integer.MAX_VALUE;
        long productNonPrime = 1;
        boolean hasNonPrime = false;

        while (true) {
            String input = scanner.next();

            if (input.equals("stop")) {
                break;
            }

            int num;
            num = Integer.parseInt(input);

            if (num <= 1 || num == N) {
                System.out.println("invalid");
                continue;
            }

            if (isPrime(num)) {
                if (num < minPrime) {
                    minPrime = num;
                }
            } else {
                productNonPrime *= num;
                hasNonPrime = true;
            }
        }
        if (minPrime == Integer.MAX_VALUE) {
            System.out.println("prime_undefined");
        } else {
            System.out.println("prime_" + minPrime);
        }

        if (!hasNonPrime) {
            System.out.println("non_prime_undefined");
        } else {
            System.out.println("non_prime_" + productNonPrime);
        }
    }
    public static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
