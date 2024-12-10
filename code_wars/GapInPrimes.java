class GapInPrimes {

    public static long[] gap(int g, long m, long n) {
        long prevNum = 0;
        long nextNum;

        for (long i = m; i <= n; i++) {
            if (isPrime(i)) {
                nextNum = i;
                if (prevNum != 0 && (nextNum - prevNum) == g)  {
                    return new long[] { prevNum, nextNum };
                } else {
                    prevNum = nextNum;
                }
            }
        }

        return null;
    }

    private static boolean isPrime(long number) {
        if (number < 2) {
            return false;
        }
        for (long i = 2; i <= (long) Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}