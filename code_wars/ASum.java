public class ASum {

    public static long findNb(long m) {
        long n = 0;
        long totalValue = 0;

        while (totalValue < m) {
            n++;
            totalValue += Math.pow(n, 3);
            if (totalValue == m) {
                return n;
            }
        }
        return -1L;
    }
}