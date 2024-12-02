public class WilsonPrime {

    private static boolean isPrime(long number) {
        if (number <= 1)
            return false;
        if (number == 2)
            return true;
        if (number % 2 == 0)
            return false;
        for (int i = 3; i * i <= number; i += 2) {
            if (number % i == 0)
                return false;
        }
        return true;
    }

    public static boolean amIWilson(long n) {
        if (!isPrime(n))
            return false;
        long fact = 1;
        // Обчислюємо факторіал (n-1)!
        for (int i = 2; i < n; i++) {
            fact *= i;
        }
        return (fact + 1) % (n * n) == 0;
    }
}